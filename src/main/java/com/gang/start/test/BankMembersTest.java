package com.gang.start.test;

import java.util.ArrayList;

import com.gang.members.BankMembersDAO;
import com.gang.members.BankMembersDTO;
import com.gang.members.BankMembersView;

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
		
		ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID("ID");
		
		bankMembersView.view(ar);
		
		
		
	}

}
