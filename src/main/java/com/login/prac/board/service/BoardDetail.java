package com.login.prac.board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.login.prac.board.BoardService;
import com.login.prac.board.model.BoardDTO;

public class BoardDetail implements BoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) {
		String postNo = (String)request.getParameter("postNo");
		
		sqlSession.update("boardUpdateViews", postNo);
		BoardDTO dto = sqlSession.selectOne("boardSelectOneByPostNo", postNo);
		
		request.setAttribute("post", dto);
		request.setAttribute("mainUrl", "board/Detail");
		
	}

}
