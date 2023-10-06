package com.acorn.day2.실습;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieDAO {
	
	@Autowired
	DataSource ds;
	
	public ArrayList<Movie> MoviePrint(){
		ArrayList<Movie> list = new ArrayList<Movie>();
		String sql = "select *from amovietbl";
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if(con != null) System.out.println("ok");
			while(rs.next()) {
				String name = rs.getString(1);
				String price = rs.getString(2);
				Movie movie = new Movie(name,Integer.parseInt(price));
				list.add(movie);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}
