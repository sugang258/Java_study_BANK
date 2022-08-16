package com.gang.start.di;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gang.start.members.BankMembersDAO;
import com.gang.start.members.BankMembersDTO;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	//로그인
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
		
	}
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
		return bankMembersDAO.setJoin(bankMembersDTO);
	}
		
	//검색어를 입력해서 id를 찾기
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		
		return bankMembersDAO.getSearchByID(search);
		
	}
}
