//package com.quiz;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Scanner;
//
//public class Exam {
//	//Exam start method
//	public static void startExam(){
//		 int mark=0;
//	     int count=1;
//		Scanner sc=new Scanner(System.in);
//		CreateCon t=new CreateCon();
//		Connection co = t.createCOn();
//		int qno;
//		String que,A,B,C,D,Rans;
//		try {
//			// Question get from DB by random
//			String question="select * from Qbank Order by RAND()";
//			PreparedStatement ps = co.prepareStatement(question);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()){
//				qno=rs.getInt(1);
//				// Question and option print
//				System.out.print("Qno="+ count++ +"] ");
//				System.out.println(que=rs.getString(2));
//				System.out.println(" ");
//				System.out.println("A) "+rs.getString(3));
//				System.out.println("B) "+rs.getString(4));
//				System.out.println("C) "+rs.getString(5));
//				System.out.println("D) "+rs.getString(6));
//				Rans=rs.getString(7);
//				System.out.println("Enter your Option. A,B,C,D");
//				System.out.print("Ans) ");
//				String uans=sc.next();
//				
//				if(Rans.equalsIgnoreCase(uans)){
//					 mark++;
//					System.out.println("*******"); 
//					
//				}
//				
//				
//			}
//			System.out.println("Total mark>>>"+mark);
//			if(mark>=8){
//				System.out.println("Grade A "+" mark >> "+mark);
//			}else if(mark>=6 && mark<8){
//				System.out.println("Grade B "+" mark >> "+mark);
//			}else if(mark==5){
//				System.out.println("Grade C "+" mark >> "+mark);
//			}else {
//				System.out.println("Fail "+" mark >> "+mark);
//			}
//			//int Rno = Student.getIdName();
//			//Insert mark into DB
//			System.out.println("11111111");
//			String inMark="insert into Result(id,mark) values(?,?)";
//			PreparedStatement im = co.prepareStatement(inMark);
//			//im.setInt(1, Rno);
//			im.setInt(2, mark);
//			im.executeUpdate();
//			
//			System.out.println("2222222");
//			//Exam status update
//			String examUp="update  examstatus set examst=? where id=?";
//			PreparedStatement sp = co.prepareStatement(examUp);
//			//sp.setString(Rno, "done");
//			System.out.println("3333333");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		sc.close();
//	}
//
//}
