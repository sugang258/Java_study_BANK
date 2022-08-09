package com.gang.start.test;

import java.util.ArrayList;
import java.util.Calendar;

import com.gang.start.bankbook.BankBookDAO;
import com.gang.start.bankbook.BankBookDTO;
import com.gang.start.bankbook.BankBookView;
import com.gang.start.members.BankMembersDTO;

public class BankBookTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//setBankBook
		
		Calendar ca = Calendar.getInstance();
		long num = ca.getTimeInMillis();
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		BankBookView bankBookView = new BankBookView();
		
		bankBookDTO.setBooknum(num);
		bankBookDTO.setBookname("SSUSU");
		bankBookDTO.setBookrate(3.88);
		bankBookDTO.setBooksale(true);
		
		int result = bankBookDAO.setBankBook(bankBookDTO);
		
		if(result > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		
		/*
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		
		bankBookView.view(ar);
		*/
		/*
		bankBookDTO.setBooknum(1659509410859L);
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		bankBookDAO.setChangeSale(bankBookDTO);
		bankBookView.view(bankBookDTO);
		*/
		
		/*
		bankBookDTO.setBooknum(1659509410859L);
		
		bankBookDAO.setChangeSale(bankBookDTO);
		
		bankBookView.view(bankBookDTO);
		*/
		
		
		/*
		bankBookDTO.setBooknum(1659509410859L);
		bankBookDAO.getDetail(bankBookDTO);
		bankBookView.view(bankBookDTO);
		*/
		
		//bankBookView.view(bankBookDTO);
		

	}

}
