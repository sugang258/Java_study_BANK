package com.gang.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.gang.start.util.DBConnector;

public class BankBookDAO implements BookDAO {
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BANKBOOK VALUES (?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setLong(1, bankBookDTO.getBooknum());
		st.setString(2, bankBookDTO.getBookname());
		st.setDouble(3, bankBookDTO.getBookrate());
		st.setBoolean(4, bankBookDTO.getBooksale());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
	
		return result;

	}

	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<BankBookDTO> ar = new ArrayList();
		
		Connection con = DBConnector.getConnection();
		
		String sql ="SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
		    long num = rs.getLong("booknum");
			String name = rs.getString("bookname");
			Double rate = rs.getDouble("bookrate");
			boolean sale = rs.getBoolean("booksale");
			
			bankBookDTO.setBooknum(num);
			bankBookDTO.setBookname(name);
			bankBookDTO.setBookrate(rate);
			bankBookDTO.setBooksale(sale);
			
			ar.add(bankBookDTO);
			
		}
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = DBConnector.getConnection();
		
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		boolean salechange = !bankBookDTO.isBookSale();
		
		st.setBoolean(1, salechange);
		st.setLong(2, bankBookDTO.getBooknum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
	
		return result;
		
		
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		
		BankBookDTO bankBookDTO2 = null;
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bankBookDTO.getBooknum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bankBookDTO2 = new BankBookDTO();
			bankBookDTO2.setBooknum(rs.getLong("booknum"));
			bankBookDTO2.setBookname(rs.getString("bookname"));
			bankBookDTO2.setBookrate(rs.getDouble("bookrate"));
			bankBookDTO2.setBooksale(rs.getBoolean("booksale"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return bankBookDTO2;
	}

	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = DBConnector.getConnection();
		
		String sql = "UPDATE BANKBOOK SET BOOKNAME = ?, BOOKRATE = ? WHERE BOOKNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bankBookDTO.getBookname());
		st.setDouble(2, bankBookDTO.getBookrate());
		st.setLong(3, bankBookDTO.getBooknum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
	
		return result;
		
	}

	@Override
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = DBConnector.getConnection();
		
		String sql = "DELETE FROM BANKBOOK WHERE BOOKNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bankBookDTO.getBooknum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	
	

}
