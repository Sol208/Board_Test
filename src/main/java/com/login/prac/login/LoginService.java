package com.login.prac.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

public interface LoginService {
	
		void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession);
		
}
