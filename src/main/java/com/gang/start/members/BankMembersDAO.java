package com.gang.start.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.gang.start.util.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO {
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BANKMEMBERS VALUES(?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		//값 세팅
		st.setString(1, bankMembersDTO.getUserName());
		st.setString(2, bankMembersDTO.getPassword());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}

	@Override
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<BankMembersDTO> ar = new ArrayList();
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKMEMBERS WHERE USERNAME LIKE ? ORDER BY USERNAME DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		//값 세팅
		st.setString(1, "%"+search+"%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserName(rs.getString("userName"));
			bankMembersDTO.setPassword(rs.getString("password"));
			bankMembersDTO.setName(rs.getString("name"));
			bankMembersDTO.setEmail(rs.getString("Email"));
			bankMembersDTO.setPhone(rs.getString("phone"));
			
			ar.add(bankMembersDTO);
		}
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT USERNAME, PASSWORD FROM BANKMEMBERS WHERE USERNAME = ? AND PASSWORD = ?";
		
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, bankMembersDTO.getUserName());
		st.setString(2, bankMembersDTO.getPassword());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserName(rs.getString("USERNAME"));
			bankMembersDTO.setPassword(rs.getString("PASSWORD"));
		}else {
			bankMembersDTO = null;
		}
		
		
		DBConnector.disConnect(rs, st, con);
		
		
		return bankMembersDTO;
		
	}

}
