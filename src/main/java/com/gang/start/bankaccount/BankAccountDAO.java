package com.gang.start.bankaccount;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.gang.start.util.DBConnector;

@Repository
public class BankAccountDAO {
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BANKACCOUNT VALUES (ACCOUNT_SEQ.NEXTVAL,?,?,SYSDATE)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setString(1, bankAccountDTO.getUserName());
		st.setLong(2, bankAccountDTO.getBookNum());
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}

}
