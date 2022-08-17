package com.gang.start.bankbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	//BankBook Table에 Insert
		//BookNum : 현재시간을 밀리세컨즈로 변환해서 입력
		//BookSale : 1로 입력
		public int setBankBook(BankBookDTO bankBookDTO) throws Exception{
			return bankBookDAO.setBankBook(bankBookDTO);
		}
		
		//BankBook 모든 데이터를 조회 최신순으로
		public ArrayList<BankBookDTO> getList() throws Exception{
			return bankBookDAO.getList();
		}
		
		
		//sale의 값을 바꿈
		public int setChangeSale(BankBookDTO bankBookDTO) throws Exception{
			return bankBookDAO.setChangeSale(bankBookDTO);
		}
		
		//BookNum의 값으로 조회
		public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
			return bankBookDAO.getDetail(bankBookDTO);
		}
		
		//BankBook 업데이트
		public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
			return bankBookDAO.setUpdate(bankBookDTO);
		}
		
		//BankBook 삭제
		public int setDelete(BankBookDTO bankBookDTO) throws Exception{
			return bankBookDAO.setDelete(bankBookDTO);
		}

}
