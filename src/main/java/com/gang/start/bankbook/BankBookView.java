package com.gang.start.bankbook;

import java.util.ArrayList;

import com.gang.start.members.BankMembersDTO;

public class BankBookView {
public void view(ArrayList<BankBookDTO> ar) {
		
		for(BankBookDTO bankBookDTO : ar) {
			
			Long num = bankBookDTO.getBooknum();
			String name = bankBookDTO.getBookname();
			double rate = bankBookDTO.getBookrate();
			boolean sale = bankBookDTO.getBooksale();
			
			System.out.println(num);
			System.out.println(name);
			System.out.println(rate);
			System.out.println(sale);
			System.out.println("===============");
		}
}
		
		public void view(BankBookDTO bankBookDTO) {
			
			Long num = bankBookDTO.getBooknum();
			String name = bankBookDTO.getBookname();
			double rate = bankBookDTO.getBookrate();
			boolean sale = bankBookDTO.getBooksale();
			
			System.out.println(num);
			System.out.println(name);
			System.out.println(rate);
			System.out.println(sale);
			System.out.println("===============");

}
}