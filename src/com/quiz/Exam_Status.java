package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam_Status {
	
	// To check Exam Status
	
	public  void examStatus(){
		CreateCon t = new CreateCon();
		Connection s = t.createCOn();
		try {
			String exam="select * from examstatus";
			PreparedStatement ps = s.prepareStatement(exam);
			ResultSet rs = ps.executeQuery();
			System.out.println("ID     Name     marks");
			while(rs.next()){
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.println(rs.getString(3));
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

}
