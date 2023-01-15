package com.quiz;

import java.util.Scanner;

public class Test {
	static int a = 1;

	public static void main(String[] args) {
		Welcome.wel();
		Student student = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your code...");
		System.out.println("1.Student Registration");
		System.out.println("2.Start Exam");
		System.out.println("3.Result");
		System.out.println("4.for add question only Admin");
		System.out.println("5. for check Exam status");

		int code = sc.nextInt();

		if (code == 1) {
			student = Student.getStuInfo();
			Student.insertInDb(student);

		} else if (code == 2) {
			Student.getIdName();

		} else if (code == 3) {
			Results.mainResult();

		} else if (code == 4) {
			if (a == 1) {    // question only one time load in DB
				System.out.println("Enter admin pass");
				int pass = sc.nextInt();
				if (pass == 123) {
					Qbank.quesQuize();
					a++;
				} else {
					System.out.println("password wrong");
				}
			}

		} else if(code==5){  //check exam status
			Exam_Status ex=new Exam_Status();
			ex.examStatus();
			
		}else {
		
			System.out.println("Wrong choice");

		}
		sc.close();

	}

}
