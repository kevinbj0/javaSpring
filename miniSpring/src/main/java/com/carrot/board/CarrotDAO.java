package com.carrot.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrotDAO {
	@Autowired
	DataSource ds;
	
	public ArrayList<CarrotDTO> pBoard(){
		ArrayList<CarrotDTO> list = new ArrayList<CarrotDTO>();
		String sql = "select * from carrot";
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if(con != null) System.out.println("ok");
			while(rs.next()) {
				String id = rs.getString(1);
				int number = rs.getInt(2);
				String info = rs.getString(3);
				String newTime = rs.getString(4);
				CarrotDTO item = new CarrotDTO(id,number,info,info);
				list.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
