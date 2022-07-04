package com.login.prac.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.login.prac.login.LoginService;
import com.login.prac.member.model.MemberDTO;

public class LoginCheck implements LoginService{

	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) {
		String pid = (String) request.getParameter("pid");
		String pw = (String) request.getParameter("pw");
//		System.out.println("pid ====> " + pid);
		
		MemberDTO dto = sqlSession.selectOne("member.selectMemberById", pid);
//		System.out.println("dto ====> " + dto);
		
		if (dto == null) {
			System.out.println("==== Login ID Check fail Check ====");
			request.setAttribute("msg", "아이디를 확인해주세요.");
			request.setAttribute("mainUrl", "alert");
			request.setAttribute("goUrl", "Login");
		} else if(dto.getPid().equals(pid) && dto.getPw().equals(pw)){
			HttpSession session = request.getSession();
			session.setAttribute("UserInfo", dto);
			request.setAttribute("msg", "로그인 되었습니다.");
			request.setAttribute("mainUrl", "alert");
			request.setAttribute("goUrl", "/");
		} else if (dto.getPw().equals(pw) || dto.getPw() != pw) {
			System.out.println("==== Login PW Check fail Check ====");
			request.setAttribute("msg", "비밀번호를 확인해주세요.");
			request.setAttribute("mainUrl", "alert");
			request.setAttribute("goUrl", "Login");
		}

		
	}

}
