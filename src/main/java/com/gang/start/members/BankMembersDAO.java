package com.gang.start.members;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gang.start.util.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.gang.start.members.BankMembersDAO.";
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
		
		
	}

	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(NAMESPACE+"getSearchByID", search);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		
	
		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
		
	}

}
