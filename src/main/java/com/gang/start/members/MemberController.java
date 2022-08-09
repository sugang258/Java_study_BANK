package com.gang.start.members;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gang.start.members.BankMembersDAO;
import com.gang.start.members.BankMembersDTO;

@Controller 
@RequestMapping(value = "/member/*")
//이 클래스는 Controller 역할, 
//Container에게 이 클래스의 객체를 생성 위임(New ~~~)
public class MemberController {
	
	//annotation
	//@ : 설명 + 실행
	
	// /member/login
	@RequestMapping(value = "login", method= RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}

	// /member/join  Get
	@RequestMapping(value = "join",method= RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 GET 실행");
		
		return "member/join";
	}
	
	@RequestMapping(value = "join", method=RequestMethod.POST)
	public String join(HttpServletRequest request) throws Exception {
		System.out.println("회원가입 POST 실행");
		String username = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName(username);
		bankMembersDTO.setPassword(pw);
		bankMembersDTO.setName(name);
		bankMembersDTO.setEmail(email);
		bankMembersDTO.setPhone(phone);
		
		BankMembersDAO bankMembersDAO = new BankMembersDAO();

		int result = bankMembersDAO.setJoin(bankMembersDTO);
		
		System.out.println(result);
		return "member/join";
	}
}
