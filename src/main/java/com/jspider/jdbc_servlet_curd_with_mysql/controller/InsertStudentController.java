package com.jspider.jdbc_servlet_curd_with_mysql.controller;

import java.time.LocalDate;

import com.jspider.jdbc_servlet_curd_with_mysql.dao.StudentDao;
import com.jspider.jdbc_servlet_curd_with_mysql.dto.Student;

public class InsertStudentController {
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();
		Student student=new Student();
		
		student.setId(104);
		student.setName("Nitish");
		student.setEmail("nitish@gmail.com");
		student.setPassword("Nitish");
		student.setPhone(1234567890);
		LocalDate dob=LocalDate.parse("2003-11-22");
		student.setDob(dob);
		student.setAge(LocalDate.now().getYear()-dob.getYear());
		student.setAddress("Noida Sector-15");
		studentDao.registerStudentDao(student);
		
	}
}
