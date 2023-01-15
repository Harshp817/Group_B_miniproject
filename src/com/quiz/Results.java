package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Results {
	
	public static void getAllRes(){
		CreateCon t=new CreateCon();
		Connection co = t.createCOn();
		try {
			String allRes="select studentinfo.id,studentinfo.name,result.marks from studentinfo right outer join Result on studentinfo.id=Result.id;";
			PreparedStatement pa = co.prepareStatement(allRes);
			ResultSet rs = pa.executeQuery();
			System.out.println("ID     Name     marks");
			while(rs.next()){
				
				System.out.print(rs.getInt(1)+"     ");
				System.out.print(rs.getString(2)+"\t");
				System.out.println(rs.getInt(3));
			}
			
		} catch (Exception e) {
			
		}
	}
	public static void singleRes(){
		CreateCon t=new CreateCon();
		Connection co = t.createCOn();
		Scanner sc=new Scanner(System.in);
		
		try {
			System.out.println("Enter id which student mark show");
			int rno=sc.nextInt();
			String sRes="select studentinfo.name,studentinfo.id,result.marks from studentinfo right outer join Result on studentinfo.id=Result.id where studentinfo.id=?";
			PreparedStatement ps = co.prepareStatement(sRes);
			ps.setInt(1, rno);
		} catch (Exception e) {
			System.out.println(e);
		}
		sc.close();
	}
public static void mainResult(){
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter 1 for all result, 2 for single student result");
	int r=sc.nextInt();
	if(r==1){
		Results.getAllRes();
	}else if(r==2){
		Results.singleRes();
	}else{
		System.out.println("wrong choice");
	}
	sc.close();
  }
}
