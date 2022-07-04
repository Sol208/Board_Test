package com.login.prac.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.prac.login.LoginService;
import com.login.prac.member.MemberService;

@Controller
public class MemberController {

	@Autowired
	ApplicationContext context;
	
	ArrayList<String> nonClass;
	
    public MemberController() {
        super();
        nonClass = new ArrayList<String>();
        nonClass.add("SignUp");
    }
	
	@RequestMapping(value="/Member/*")
	public String memCon(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		SqlSession sqlSession = context.getBean("sqlSession", SqlSession.class);
		
		String serviceStr = request.getRequestURI().substring(
				(request.getContextPath() + "/Member/").length());
		
		System.out.println("serviceStr ====> " + serviceStr);
		
		if(nonClass.contains(serviceStr)) {
			request.setAttribute("mainUrl", "member/"+serviceStr);
			return "template";
		}else {
			try {
				MemberService serv = 
						(MemberService)Class.forName("com.login.prac.member.service.Member" + serviceStr).newInstance();
				serv.execute(request, response, sqlSession);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "template";
	}
	
}
