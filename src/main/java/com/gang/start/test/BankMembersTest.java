package com.gang.start.test;

import java.util.ArrayList;

import com.gang.start.members.BankMembersDAO;
import com.gang.start.members.BankMembersDTO;
import com.gang.start.members.BankMembersView;

public class BankMembersTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		BankMembersView bankMembersView = new BankMembersView();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		
		/*
		bankMembersDTO.setUserName("SSSUUU");
		bankMembersDTO.setPassword("GGGAAAA");
		bankMembersDTO.setName("N1");
		bankMembersDTO.setEmail("EMAIL");
		bankMembersDTO.setPhone("0103333");
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		
		if(result > 0) {
			System.out.println("성공");
			
		}else {
			System.out.println("실패");
		}
		*/
		
		//rrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID("ID");
		
		//bankMembersView.view(ar);
		
		
		
	}

}
