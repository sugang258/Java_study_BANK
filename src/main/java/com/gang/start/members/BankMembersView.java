package com.gang.start.members;

import java.util.ArrayList;

public class BankMembersView {
	
	public void view(BankMembersDTO bankMembersDTO) {
		
		String username = bankMembersDTO.getUserName();
		String pw = bankMembersDTO.getPassword();
		String name = bankMembersDTO.getName();
		String email = bankMembersDTO.getEmail();
		String phone = bankMembersDTO.getPhone();
		
		System.out.println(username);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(email);
		System.out.println(phone);
		System.out.println("==================");
	}
	
	public void view(ArrayList<BankMembersDTO> ar) {
		
		for(BankMembersDTO bankMembersDTO : ar) {
			
			String u_name = bankMembersDTO.getUserName();
			String password = bankMembersDTO.getPassword();
			String name = bankMembersDTO.getName();
			String email = bankMembersDTO.getEmail();
			String phone = bankMembersDTO.getPhone();
			System.out.println(u_name);
			System.out.println(password);
			System.out.println(name);
			System.out.println(email);
			System.out.println(phone);
			System.out.println("===============");
		}
	}

}
