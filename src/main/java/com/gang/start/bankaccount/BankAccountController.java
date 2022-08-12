package com.gang.start.bankaccount;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gang.start.members.BankMembersDTO;

@Controller
@RequestMapping(value="/bankaccount/*")
public class BankAccountController {
	private BankAccountDAO bankAccountDAO;
	
	public BankAccountController() {
		this.bankAccountDAO = new BankAccountDAO();
	}
	
	@RequestMapping(value="add.gang", method=RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session ) throws Exception {
	
		System.out.println("계좌 생성");
		//BankAccountDAO bankAccountDAO = new BankAccountDAO();
		//DTO : USERNAME,BOOKNUM
		System.out.println(bankAccountDTO.getBookNum());
		
		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		bankAccountDTO.setUserName(bankMembersDTO.getUserName());
		int result = bankAccountDAO.add(bankAccountDTO);
		
		
		
		return "redirect:../bankbook/list.gang";
	}
}
