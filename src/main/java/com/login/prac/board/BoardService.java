package com.login.prac.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

public interface BoardService {
		
		void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession);
	
}
