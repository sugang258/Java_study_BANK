package com.gang.start.members;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
//이 클래스는 Controller 역할, 
//Container에게 이 클래스의 객체를 생성 위임(New ~~~)
public class MemberController {
	
	//annotation
	//@ : 설명 + 실행
	
	// /member/login
	@RequestMapping(value = "/member/login")
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}

	// /member/join
	@RequestMapping(value = "/member/join")
	public String join() {
		System.out.println("회원가입 실행");
		
		return "member/join";
	}
}
