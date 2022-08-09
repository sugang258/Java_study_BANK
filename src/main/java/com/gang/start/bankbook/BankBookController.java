package com.gang.start.bankbook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gang.start.bankbook.BankBookDAO;
import com.gang.start.bankbook.BankBookDTO;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@RequestMapping(value ="list", method=RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		BankBookDAO bankbookDAO = new BankBookDAO();

		ArrayList<BankBookDTO> ar = bankbookDAO.getList();
		request.setAttribute("list", ar);
		
		System.out.println();
		return "/bankbook/list";
	}
	
	@RequestMapping(value = "detail", method=RequestMethod.GET)
	public String detail(HttpServletRequest request) throws Exception {
		
		String bookNum = request.getParameter("bookNum");
		System.out.println(bookNum);
		
		BankBookDTO bankbookDTO = new BankBookDTO();
		Long l = Long.parseLong(bookNum);
		bankbookDTO.setBooknum(l);
		
		BankBookDAO bankbookDAO = new BankBookDAO();
		
		bankbookDTO = bankbookDAO.getDetail(bankbookDTO);
		request.setAttribute("dto", bankbookDTO);
		
		return "/bankbook/detail";
		
	}

}
