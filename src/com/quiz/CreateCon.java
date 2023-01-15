package com.quiz;

import java.sql.Connection;
import java.sql.DriverManager;




public class CreateCon {
	 Connection con;
	public   Connection createCOn() {
		
		
			
			
			try {
				// driver load
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// create connection
				
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");
				
				
			
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			return con;
		
	}

	

}
