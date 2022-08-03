package com.gang.start.test;

import java.sql.Connection;

import com.gang.start.util.DBConnector;

public class DBConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Connection con = DBConnector.getConnection();
			DBConnector.getConnection();
			System.out.println(con != null);
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
