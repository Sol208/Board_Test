package com.login.prac.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.login.prac.board.BoardService;
import com.login.prac.board.model.BoardDTO;
import com.login.prac.member.model.MemberDTO;

public class BoardInsertReg implements BoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) {
		HttpSession session = request.getSession();
		MemberDTO userInfo = (MemberDTO) session.getAttribute("UserInfo");
		String title = request.getParameter("title");
		String mainText = request.getParameter("mainText");
		int postNo = sqlSession.selectList("boardSelectListAll").size()+1;	
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("title", title);
		param.put("maintext", mainText);
		param.put("pid", userInfo.getPid());
		param.put("postno", postNo);
		
//		System.out.println(param);
		
		sqlSession.insert("boardInsert", param);
		
		
		request.setAttribute("mainUrl", "alert");
		request.setAttribute("goUrl", "List");
		request.setAttribute("msg", "저장되었습니다.");
		
		
	}

}
