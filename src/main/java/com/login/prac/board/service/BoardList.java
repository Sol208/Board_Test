package com.login.prac.board.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.login.prac.board.BoardService;
import com.login.prac.board.model.BoardDTO;

public class BoardList implements BoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) {
			List<BoardDTO> dto= sqlSession.selectList("boardSelectListAll");	
			
			System.out.println("boardList ===> " + dto);
			
			
			request.setAttribute("mainData", dto);
			request.setAttribute("mainUrl", "board/List");
		
	}

}
