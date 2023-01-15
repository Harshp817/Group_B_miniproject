package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	private int id;
	private String name;
	private String city;
	private String mo;
	static int count = 1;
	int sid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMo() {
		return mo;
	}

	public void setMo(String mo) {
		this.mo = mo;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String city, String mo) {
		super();
		this.name = name;
		this.city = city;
		this.mo = mo;
	}

	public Student(int id, String name, String city, String mo) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.mo = mo;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", mo=" + mo + "]";
	}

	public static Student getStuInfo() {
		// multiple Student data store

		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		student.setName(sc.nextLine());
		System.out.println("Enter city");
		student.setCity(sc.next());
		System.out.println("Enter mono");
		student.setMo(sc.next());
		sc.close();
		return student;

	}

	public static void insertInDb(Student student) {
		CreateCon t = new CreateCon();
		Connection s = t.createCOn();

		// Student Addmission and information store into DB
		try {
			String insert = "insert into studentinfo(name,city,mo) values(?,?,?)";
			PreparedStatement ps = s.prepareStatement(insert);

			ps.setString(1, student.getName());
			ps.setString(2, student.getCity());
			ps.setString(3, student.getMo());

			int a = ps.executeUpdate();
			if (a != 0) {
				count++;
				System.out.println(count);
			} else {
				System.out.println("Something wrong......");
			}
			String iE = "insert into examstatus(name,examst) values(?,?)";
			PreparedStatement es = s.prepareStatement(iE);
			// es.setInt(1, student.getId());
			es.setString(1, student.getName());
			es.setString(2, "Pending");
			es.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int getIdName() {
		// ID and Name check before start Exam
		CreateCon t = new CreateCon();
		Connection s = t.createCOn();
		Scanner sc = new Scanner(System.in);
		System.out.println(">>enter your id ");
		int id = sc.nextInt();
		int sid = id;
		System.out.println("Enter your name");
		String uname = sc.next();
		try {

			String getIdName = "select name from studentinfo where id=?";
			String s11 = "";
			PreparedStatement ps = s.prepareStatement(getIdName);
			ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				s11 = rs.getString(1);
			}
			if (s11.equals(uname)) {
				int mark = 0;
				int count = 1;

				// CreateCon t=new CreateCon();
				// Connection co = t.createCOn();
				int qno;
				String que, A, B, C, D, Rans;

				// Question get from DB by random
				String question = "select * from Qbank Order by RAND()";
				PreparedStatement ps1 = s.prepareStatement(question);
				ResultSet rs1 = ps1.executeQuery();
				while (rs1.next()) {
					qno = rs1.getInt(1);
					// Question and option print
					System.out.print("Qno=" + count++ + "] ");
					System.out.println(que = rs1.getString(2));
					System.out.println(" ");
					System.out.println("A) " + rs1.getString(3));
					System.out.println("B) " + rs1.getString(4));
					System.out.println("C) " + rs1.getString(5));
					System.out.println("D) " + rs1.getString(6));
					Rans = rs1.getString(7);
					System.out.println("Enter your Option. A,B,C,D");
					System.out.print("Ans) ");
					String uans = sc.next();

					if (Rans.equalsIgnoreCase(uans)) {
						mark++;
						System.out.println("*******");

					}

				}
				System.out.println("Total mark>>>" + mark);
				if (mark >= 8) {
					System.out.println("Grade A " + " mark >> " + mark);
				} else if (mark >= 6 && mark < 8) {
					System.out.println("Grade B " + " mark >> " + mark);
				} else if (mark == 5) {
					System.out.println("Grade C " + " mark >> " + mark);
				} else {
					System.out.println("Fail " + " mark >> " + mark);
				}
				// int Rno = Student.getIdName();
				// Insert mark into DB
				
				String inMark = "insert into Result(id,marks) values(?,?)";
				PreparedStatement im = s.prepareStatement(inMark);
				im.setInt(1, id);
				im.setInt(2, mark);
				im.executeUpdate();

				
				// Exam status update
				String examUp = "update  examstatus set examst=? where id=?";
				PreparedStatement sp = s.prepareStatement(examUp);
				sp.setString(id, "done");
				

				sc.close();
			}

			

		} catch (Exception e) {
			System.out.println(e);
		}
		return sid;
	}
}
