package com.login.prac.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.prac.board.BoardService;
import com.login.prac.login.LoginService;

@Controller
public class BoardController {
		
		@Autowired
		ApplicationContext context;
		
		ArrayList<String> nonClass;
		
		  public BoardController() {
		        super();
		        nonClass = new ArrayList<String>();
		        nonClass.add("Insert");
		    }
		
		@RequestMapping(value="/Board/*")
		public String boardCon(HttpServletRequest request, HttpServletResponse response, Locale locale , Model model) {
			SqlSession sqlSession = context.getBean("sqlSession", SqlSession.class);
			
			String serviceStr = request.getRequestURI().substring(
					(request.getContextPath() + "/Board/").length());
			System.out.println("serviceStr ====> " + serviceStr);
			
			int page = 1;
			
			if(request.getParameter("page")!=null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			request.setAttribute("nowPage", page);
			
			if(nonClass.contains(serviceStr)) {
				request.setAttribute("mainUrl", "board/"+serviceStr);
				return "template";
			}else {
				try {
					BoardService serv =
							(BoardService)Class.forName("com.login.prac.board.service.Board" + serviceStr).newInstance();
					serv.execute(request, response, sqlSession);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return "template";
			
		}
}
