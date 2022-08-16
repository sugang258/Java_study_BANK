package com.gang.start.members;

import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gang.start.di.BankMembersService;

@Controller 
@RequestMapping(value = "/member/*")
//이 클래스는 Controller 역할, 
//Container에게 이 클래스의 객체를 생성 위임(New ~~~)
public class MemberController {
	
	@Autowired
	private BankMembersService bankMembersService;
	
	/*
	@Autowired
	@Qualifier("myDAO")
	private BankMembersDAO bankMembersDAO;
	*/
	/*
	@Autowired
	public MemberController(BankMembersDAO bankMembersDAO) {
		this.bankMembersDAO = bankMembersDAO;
	}
	*/
	
	//annotation
	//@ : 설명 + 실행
	
	// /member/login
	@RequestMapping(value = "login.gang", method= RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	// /member/login
		@RequestMapping(value = "login.gang", method= RequestMethod.POST)
		public String login(HttpSession session, BankMembersDTO bankMembersDTO, Model model, HttpServletRequest request) throws Exception {
			System.out.println("DB에 로그인 실행");
			//"redirect:다시접속할URL주소(절대경로, 상대경로)"
			String userName = request.getParameter("userName");
			
			bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
			model.addAttribute("member",bankMembersDTO);
			
			//HttpSession session = request.getSession();
			session.setAttribute("member", bankMembersDTO);
			HttpSession se = request.getSession();
			se.setAttribute("user", userName);
			
			
			 if(bankMembersDTO != null) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패");
			}
			
			//System.out.println(bankMembersDTO);
			
			return "redirect:../";
		}
		
	

	// /member/join  Get
	@RequestMapping(value = "join.gang",method= RequestMethod.GET)
	public void join() throws Exception {
		System.out.println("회원가입 GET 실행");
		
		//return "member/join";
	}
	
	@RequestMapping(value = "join.gang", method=RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("회원가입 POST 실행");
		
		/*
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName(username);
		bankMembersDTO.setPassword(pw);
		bankMembersDTO.setName(name);
		bankMembersDTO.setEmail(email);
		bankMembersDTO.setPhone(phone);
		*/
		

		int result = bankMembersService.setJoin(bankMembersDTO);
		
		System.out.println(result);
		return "redirect:./login.gang";
	}
	
	@RequestMapping(value = "search.gang", method=RequestMethod.GET) 
	public ModelAndView getSearchByID() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/search");
		
		System.out.println("ID 검색 실행");
		
		return mv;
		
	}
	
	@RequestMapping(value="search.gang",method=RequestMethod.POST)
	public String getSearchByID(String userName, Model model) throws Exception {
			
		ArrayList<BankMembersDTO> ar = bankMembersService.getSearchByID(userName);
		
		model.addAttribute("list", ar);
		
		return "member/list";
	}
	
	@RequestMapping(value="logout.gang", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:../";
		
	}
}
