package com.login.prac.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

public interface MemberService {
	
		void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession);

}
