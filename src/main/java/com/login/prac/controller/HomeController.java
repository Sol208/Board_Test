package com.login.prac.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/*")
	public String home(Locale locale, Model model, HttpServletRequest request) {
		String serviceStr = request.getRequestURI().substring(
				(request.getContextPath() + "/").length());
		System.out.println("ServiceStr ==> " + serviceStr);
		
		if(serviceStr.equals("")) {
			return "home";
		}
		
		
		return serviceStr;
	}
	
}
