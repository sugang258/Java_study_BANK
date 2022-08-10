package com.gang.start.bankbook;

import java.util.ArrayList;
import java.util.Calendar;

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
	public void list(HttpServletRequest request) throws Exception {
		BankBookDAO bankbookDAO = new BankBookDAO();

		ArrayList<BankBookDTO> ar = bankbookDAO.getList();
		request.setAttribute("list", ar);
		
		System.out.println();
		
	}
	
	@RequestMapping(value = "detail", method=RequestMethod.GET)
	public void detail(Long bookNum, HttpServletRequest request) throws Exception {
		
		System.out.println(bookNum);
		
		BankBookDTO bankbookDTO = new BankBookDTO();
		//Long l = Long.parseLong(bookNum);
		bankbookDTO.setBooknum(1);
		
		BankBookDAO bankbookDAO = new BankBookDAO();
		
		bankbookDTO = bankbookDAO.getDetail(bankbookDTO);
		
		request.setAttribute("dto", bankbookDTO);
		
		//return "/bankbook/detail";
		
	}
	
	// /bankbook/add GET /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value ="add", method=RequestMethod.GET)
	public void add() throws Exception {
		System.out.println("상품 등록 실행 GET");
		
		//return "/bankbook/add";
		
		
	}
	
	@RequestMapping(value ="add", method=RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		
		System.out.println("상품 등록 실행 POST");
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		Calendar ca = Calendar.getInstance();
		long num = ca.getTimeInMillis();
		
		bankBookDTO.setBooknum(num);
		bankBookDTO.setBooksale(true);

		
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result);
		
		return "/bankbook/add";
		
	}

}
