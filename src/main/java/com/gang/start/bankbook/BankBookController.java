package com.gang.start.bankbook;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value ="list.gang", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		
		//ModelAndView mv = new ModelAndView();
		
		ArrayList<BankBookDTO> ar = bankBookService.getList();
		
		model.addAttribute("list", ar);
		
		//request.setAttribute("list", ar);
				
		return "bankbook/list";
		
	}
	
	@RequestMapping(value = "detail.gang", method=RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		//String bookNum = request.getParameter("bookNum");
		//Long l = Long.parseLong(bookNum);
	
		
		//System.out.println(bookNum);
		//BankBookDTO bankbookDTO = new BankBookDTO();
		
		
		//bankbookDTO.setBooknum(l);
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		
		//request.setAttribute("dto", bankbookDTO);
		
		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankBookDTO);
		//return "/bankbook/detail";
		return mv;
		
	}
	
	// /bankbook/add GET /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value ="add.gang", method=RequestMethod.GET)
	public void add() throws Exception {
		System.out.println("상품 등록 실행 GET");
		
		//return "/bankbook/add";
		
		
	}
	
	@RequestMapping(value ="add.gang", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("상품 등록 실행 POST");
		
		Calendar ca = Calendar.getInstance();
		long num = ca.getTimeInMillis();
		
		bankBookDTO.setBooknum(num);
		bankBookDTO.setBooksale(true);

		bankBookService.setBankBook(bankBookDTO);
		//System.out.println(result);
		mv.setViewName("redirect:./list.gang");
		//mv.addObject("list",bankBookDTO);
		
		return mv;
		
	}
	
	@RequestMapping(value="update.gang" , method=RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception{
		System.out.println("업데이트 실행");
		
		System.out.println(bankBookDTO.getBooknum());
		bankBookDTO= bankBookService.getDetail(bankBookDTO);
		
		model.addAttribute("dto",bankBookDTO);
	
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		System.out.println("업데이트 POST 실행");
		
		int result = bankBookService.setUpdate(bankBookDTO);
		
		System.out.println(result);
		
		mv.setViewName("redirect:./detail.gang?booknum="+bankBookDTO.getBooknum());
		//mv.setViewName("redirect:./list");
		return mv;
	
	}
	
	@RequestMapping(value="delete.gang", method=RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		System.out.println("삭제 실행");
		
		int result = bankBookService.setDelete(bankBookDTO);
		
		System.out.println(result);
		
		mv.setViewName("redirect:./list.gang");
		
		return mv;
	}
	
	

}
