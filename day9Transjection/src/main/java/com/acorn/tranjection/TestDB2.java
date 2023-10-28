package com.acorn.tranjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDB2 {

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
			con.setAutoCommit(false);
			String sql1 = "insert into testdb values('a2','0000')";
			PreparedStatement pst = con.prepareStatement(sql1);
			int result = pst.executeUpdate();
			
			String sql2 = "insert into testdb values('a2','0000')";
			PreparedStatement pst2 = con.prepareStatement(sql1);
			int result2 = pst.executeUpdate();
			
			//둘다 실행되었을 때 커밋실행
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				//에러 반환 시 롤백
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

}
