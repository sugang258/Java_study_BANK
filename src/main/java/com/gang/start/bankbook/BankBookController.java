package com.gang.start.bankbook;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gang.start.bankbook.BankBookDAO;
import com.gang.start.bankbook.BankBookDTO;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@RequestMapping(value ="list", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		
		//ModelAndView mv = new ModelAndView();
		BankBookDAO bankbookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankbookDAO.getList();
		
		model.addAttribute("list", ar);
		
		//request.setAttribute("list", ar);
				
		return "bankbook/list";
		
	}
	
	@RequestMapping(value = "detail", method=RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankbookDTO, HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		String bookNum = request.getParameter("bookNum");
		Long l = Long.parseLong(bookNum);
	
		
		//System.out.println(bookNum);
		//BankBookDTO bankbookDTO = new BankBookDTO();
		
		BankBookDAO bankbookDAO = new BankBookDAO();
		
		bankbookDTO.setBooknum(l);
		bankbookDTO = bankbookDAO.getDetail(bankbookDTO);
		
		//request.setAttribute("dto", bankbookDTO);
		
		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankbookDTO);
		//return "/bankbook/detail";
		return mv;
		
	}
	
	// /bankbook/add GET /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value ="add", method=RequestMethod.GET)
	public void add() throws Exception {
		System.out.println("상품 등록 실행 GET");
		
		//return "/bankbook/add";
		
		
	}
	
	@RequestMapping(value ="add", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("상품 등록 실행 POST");
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		Calendar ca = Calendar.getInstance();
		long num = ca.getTimeInMillis();
		
		bankBookDTO.setBooknum(num);
		bankBookDTO.setBooksale(true);

		bankBookDAO.setBankBook(bankBookDTO);
		//System.out.println(result);
		mv.setViewName("redirect:./list");
		//mv.addObject("list",bankBookDTO);
		
		return mv;
		
	}

}
