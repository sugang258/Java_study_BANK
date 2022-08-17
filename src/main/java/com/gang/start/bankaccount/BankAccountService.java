package com.gang.start.bankaccount;

import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
	
	private BankAccountDAO bankAccountDAO;
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		
		return bankAccountDAO.add(bankAccountDTO);
		
	}

}
