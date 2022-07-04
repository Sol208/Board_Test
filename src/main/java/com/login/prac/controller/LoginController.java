package com.login.prac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.login.prac.login.LoginService;

@Controller
public class LoginController {

	@Autowired
	ApplicationContext context;
	
	ArrayList<String> nonClass;
	
	  public LoginController() {
	        super();
	        nonClass = new ArrayList<String>();
	        nonClass.add("Login");
	    }
	
	@RequestMapping(value="/Login/*")
	public String logCon(HttpServletRequest request, HttpServletResponse response ,Locale locale, Model model) {
		SqlSession sqlSession = context.getBean("sqlSession", SqlSession.class);
		
//		System.out.println(session.selectOne("member.selectMemberById", "ood1208"));
		
		String serviceStr = request.getRequestURI().substring(
				(request.getContextPath() + "/Login/").length());
		System.out.println("ServiceStr ==> " + serviceStr);
		
		
		if(nonClass.contains(serviceStr)) {
			request.setAttribute("mainUrl", "login/"+serviceStr);
			return "template";
		}else {
			try {
				LoginService serv =
						(LoginService)Class.forName("com.login.prac.login.service.Login" + serviceStr).newInstance();
				serv.execute(request, response, sqlSession);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		return "template";
		
	}
	
}
