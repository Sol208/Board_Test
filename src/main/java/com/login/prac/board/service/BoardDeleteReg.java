package com.login.prac.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.login.prac.board.BoardService;

public class BoardDeleteReg implements BoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) {
		String postNo = request.getParameter("postNo");
		
		sqlSession.delete("boardDeletePost", postNo);
		
		request.setAttribute("msg", "삭제되었습니다.");
		request.setAttribute("mainUrl", "alert");
		request.setAttribute("goUrl",  "List");
	}

}
