package com.jspider.jdbc_servlet_curd_with_mysql.controller;

import java.util.List;
import java.util.Scanner;

import com.jspider.jdbc_servlet_curd_with_mysql.dao.StudentDao;
import com.jspider.jdbc_servlet_curd_with_mysql.dto.Student;

public class GetAllStudentController {
	public static void main(String[] args) {
		StudentDao dao=new StudentDao();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Email");
		String email=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		
		Student student=dao.getStudentByEmailDao(email);
		
		if(student!=null) {
			if(student.getPassword().equals(pass)) {
				System.out.println("Login success");
				List<Student>students=dao.getAllStudentDao();
				for(Student st:students) {
					System.out.println(st);
				}
			}
			else {
				System.out.println("Wrong Password");
			}
		}
		else {
			System.out.println("Incorrect email");
		}
	}
}
