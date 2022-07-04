package com.login.prac.member.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.login.prac.member.MemberService;
import com.login.prac.member.model.MemberDTO;

public class MemberSignUpReg implements MemberService{
		
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) {
				String pid = request.getParameter("pid");
				String pw = request.getParameter("pw");
				System.out.println("sign ====> " + pid + ", " + pw);
				
//				MemberDTO dto = sqlSession.selectOne("selectMemberByID", pid);
				
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("pid", pid);
				param.put("pw", pw);
				
				sqlSession.insert("insertMember", param);
				
				request.setAttribute("msg", "회원가입 되었습니다.");
				request.setAttribute("mainUrl", "alert");
				request.setAttribute("goUrl", "/");
				
				
				
			
		}
		
}
