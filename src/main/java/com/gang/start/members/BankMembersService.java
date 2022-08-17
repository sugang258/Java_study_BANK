package com.gang.start.members;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;

	//bankMembers 회원가입
		public int setJoin(BankMembersDTO bankMembersDTO) throws Exception{
			
			return bankMembersDAO.setJoin(bankMembersDTO);
		}
		
		//검색어를 입력해서 id를 찾기
		public List<BankMembersDTO> getSearchByID(String search) throws Exception{
			
			return bankMembersDAO.getSearchByID(search);
			
		}
			
		public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
			
			return bankMembersDAO.getLogin(bankMembersDTO);
		}
}
