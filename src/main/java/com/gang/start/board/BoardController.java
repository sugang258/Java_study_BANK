package com.gang.start.board;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gang.start.members.BankMembersDTO;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	@RequestMapping(value="list.gang", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		
		System.out.println("게시판 목록 GET");
		
		BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardDTO> ar = boardDAO.getList();
		
		model.addAttribute("board", ar);
		
		return "board/list";
		
		//return null;
		
	}
	
	@RequestMapping(value = "detail.gang", method=RequestMethod.GET)
	public ModelAndView detail(BoardDTO boardDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BoardDAO boardDAO = new BoardDAO();
		
		boardDTO = boardDAO.getDetail(boardDTO);
		
		mv.setViewName("board/detail");
		mv.addObject("board", boardDTO);
		
		return mv;
	}
	
	@RequestMapping(value="delete.gang", method=RequestMethod.GET)
	public ModelAndView delete(BoardDTO boardDTO) throws Exception{		
		System.out.println("삭제 실행");
		ModelAndView mv = new ModelAndView();
		BoardDAO boardDAO = new BoardDAO();
		int result = boardDAO.delete(boardDTO);
		mv.setViewName("redirect:./list.gang");
		
		System.out.println(result);
		
		return mv;
		
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.GET)
	public void update(BoardDTO boardDTO,Model model) throws Exception {
		System.out.println("업데이트 실행");
		BoardDAO boardDAO = new BoardDAO();	
		
		System.out.println(boardDTO.getNum());
		boardDTO = boardDAO.getDetail(boardDTO);
		
		model.addAttribute("board", boardDTO);
		
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.POST)
	public ModelAndView update(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		System.out.println("업데이트 POST 실행");
		
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.update(boardDTO);
		
		System.out.println(result);
		mv.setViewName("redirect:./list.gang");
		
		return mv;
	}
	
	@RequestMapping(value="add.gang", method=RequestMethod.GET)
	public void add() throws Exception {
		System.out.println("글 작성 GET");
		
	}
	
	@RequestMapping(value = "add.gang", method=RequestMethod.POST)
	public ModelAndView add(BoardDTO boardDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("글 작성 실행 post");
		
		BoardDAO boardDAO = new BoardDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		
		boardDTO.setUserName("id1");
		
		boardDAO.add(boardDTO);
		mv.setViewName("redirect:./list.gang");
		
		return mv;
	}
	
	

}
