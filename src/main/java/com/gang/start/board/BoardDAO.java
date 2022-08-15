package com.gang.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.gang.start.util.DBConnector;

public class BoardDAO {
	
	//글 목록보기
	public ArrayList<BoardDTO> getList() throws Exception {
		
		ArrayList<BoardDTO> ar = new ArrayList();
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BOARD";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setContexts(rs.getString("contexts"));
			boardDTO.setTextDate(rs.getDate("textDate"));
			boardDTO.setViews(rs.getInt("views"));
			
			ar.add(boardDTO);
		}
		DBConnector.disConnect(rs, st, con);
		
		return ar;
		
	}
	
	//글 상세보기 detail
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		BoardDTO boardDTO2 = null;
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, boardDTO.getNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			boardDTO2 = new BoardDTO();
			boardDTO2.setNum(rs.getInt("num"));
			boardDTO2.setTitle(rs.getString("title"));
			boardDTO2.setContexts(rs.getString("contexts"));
			boardDTO2.setUserName(rs.getString("userName"));
			boardDTO2.setTextDate(rs.getDate("textDate"));
			boardDTO2.setViews(rs.getInt("views"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return boardDTO2;
		
	}
	
	//글 쓰기 add
	public int add(BoardDTO boardDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,boardDTO.getTitle());
		st.setString(2, boardDTO.getContexts());
		st.setString(3, boardDTO.getUserName());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	//글 수정 update
	public int update(BoardDTO boardDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "UPDATE BOARD SET TITLE = ?, CONTEXTS = ? WHERE NUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContexts());
		st.setInt(3, boardDTO.getNum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	//글 삭제 delete
	public int delete(BoardDTO boardDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "DELETE FROM BOARD WHERE NUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, boardDTO.getNum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	
	

}
