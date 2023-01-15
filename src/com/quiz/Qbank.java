package com.quiz;

import java.sql.Connection;

import java.sql.Statement;

public class Qbank {
	
	// Add question

	public static void quesQuize(){
		CreateCon t = new CreateCon();
		Connection s = t.createCOn();
		try {
			String insertQ="insert into qbank(que,A,B,C,D,Rans) values('Who invented Java Programming?','Guido van Rossum','James Gosling','Dennis Ritchie','Bjarne Stroustrup','b',),('Which one of the following is not a Java feature?','Object-oriented','Use of pointers','Portable','Dynamic and Extensible','b'),"
					+ "('Which of these cannot be used for a variable name in Java?','identifier & keyword','identifier','keyword','none of the mentioned','c'),"
					+ "('What is the extension of java code files?','.js','.txt','.class','.java','d'),"
					+ "('Which of the following is not an OOPS concept in Java?','Polymorphism','Inheritance','Compilation','Encapsulation','c'),"
					+ "('JVVA invented in which year?','1995','1991','1998','1996','a'),"
					+ "('Which component is used to compile, debug and execute the java programs?','JVM','JDK','JIT','JRE','b'),"
					+ "('Which environment variable is used to set the java path?','MAVEN_PATH','javaPATH','java','java_HOME','d'),"
					+ "('Which of the below is not a Java Profiler?','JPROFILER','Eclips Profiler','JVM','JConsolve','c'),"
					+ "('Which of these packages contains the exception Stack Overflow in Java?','java.lang','java.io','java.util','java.sql','a'),";
			Statement ss = s.createStatement();
			
			ss.execute(insertQ);
			
		} catch (Exception e) {
		}
	}
}
