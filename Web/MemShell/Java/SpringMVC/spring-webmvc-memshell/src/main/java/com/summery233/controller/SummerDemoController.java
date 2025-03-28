package com.summery233.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * spring index controller
 *
 * @author su18,233
 */
@Controller
@RequestMapping(value = "/index")
public class SummerDemoController {

	@GetMapping()
	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.getWriter().println("Summer Demo Controller");
	}

}