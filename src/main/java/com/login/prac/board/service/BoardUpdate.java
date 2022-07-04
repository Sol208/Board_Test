package com.login.prac.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.login.prac.board.BoardService;
import com.login.prac.board.model.BoardDTO;

public class BoardUpdate implements BoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) {
		
		String postNo = request.getParameter("postNo");
		
		BoardDTO dto = sqlSession.selectOne("boardSelectOneByPostNo", postNo);
		
		request.setAttribute("post", dto);
		request.setAttribute("mainUrl", "board/Update");
		
	}

}
