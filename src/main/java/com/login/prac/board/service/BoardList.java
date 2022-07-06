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
			int page = (int) request.getAttribute("nowPage");
			int limit = 3;
			int pageLimit = 5;
		
			List<BoardDTO> dto= sqlSession.selectList("boardSelectListAll");	
//			System.out.println("boardList ===> " + dto);
			
			int totalCnt = sqlSession.selectOne("boardSelectTotalCount");
			System.out.println(totalCnt);

			int pageTotal = totalCnt/limit;
			 System.out.println(pageTotal);
			
			if(totalCnt%limit > 0) {
				pageTotal++;
			}
			
			int start = (page-1) * limit + 1;
			int pageStart = (page-1) / pageLimit * pageLimit+1;
			int pageEnd = (pageStart+pageLimit)-1;
			
			request.setAttribute("mainData", dto);
			request.setAttribute("mainUrl", "board/List");
			
			request.setAttribute("start", start);
			request.setAttribute("pageTotal", pageTotal);
			request.setAttribute("pageStart", pageStart);
			request.setAttribute("pageEnd", pageEnd);		
	}

}
