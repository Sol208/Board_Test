package com.login.prac.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.login.prac.login.LoginService;

public class LoginLogoutReg implements LoginService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) {
			HttpSession session = request.getSession();
			session.invalidate();
			
			request.setAttribute("msg", "로그아웃되었습니다.");
			request.setAttribute("goUrl", "/");
			request.setAttribute("mainUrl", "alert");
			
	}
	
}
