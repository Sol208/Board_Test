package com.login.prac.board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.login.prac.board.BoardService;

public class BoardUpdateReg implements BoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) {
		String postNo = request.getParameter("postNo");
		String title = request.getParameter("title");
		String mainText = request.getParameter("mainText");
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("title", title);
		param.put("maintext", mainText);
		param.put("postno", postNo);
		
		sqlSession.update("boardUpdatePost", param);
		
		request.setAttribute("msg", "수정되었습니다.");
		request.setAttribute("mainUrl", "alert");
		request.setAttribute("goUrl", "List");
		
		
	}

}
