package com.acorn.tranjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDB {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:testdb";
		String user="scott";
		String password="tiger";
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// try, 캐치 여러개 말고 exception e(최상위) 하나만 받아도 됨
			e.printStackTrace();
		} 
		
		try {
			String sql = "insert into testdb values('a1','0000')";
			PreparedStatement pst = con.prepareStatement(sql);
			int result = pst.executeUpdate();
			
			String sql2 = "insert into testdb values('a1','1111')";
			PreparedStatement pst2 = con.prepareStatement(sql2);
			int result2 = pst2.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
