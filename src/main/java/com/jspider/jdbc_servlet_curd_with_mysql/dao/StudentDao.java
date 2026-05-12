package com.jspider.jdbc_servlet_curd_with_mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jspider.jdbc_servlet_curd_with_mysql.connection.JdbcStudentConnection;
import com.jspider.jdbc_servlet_curd_with_mysql.dto.Student;
import com.mysql.cj.jdbc.JdbcConnection;

public class StudentDao {
	
			Connection connection=JdbcStudentConnection.getJdbcStudentConnection();
		public Student registerStudentDao(Student student) {
		String insertStudentQuery="insert into student(id,name,email,password,phone,dob,age,address) values (?,?,?,?,?,?,?,?)";
			
		try {
			PreparedStatement ps=connection.prepareStatement(insertStudentQuery);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPassword());
			ps.setLong(5, student.getPhone());
			ps.setObject(6, student.getDob());
			ps.setInt(7, student.getAge());
			ps.setString(8, student.getAddress());
			
			int a=ps.executeUpdate();
			String msg=a!=0?"data saved":"fail";
			System.out.println(msg);
			return student;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		}
		
		public Student getStudentByEmailDao(String email) {
			String getStudentByEmailQuery="select * from student where email=?";
			try {
				PreparedStatement ps = connection.prepareStatement(getStudentByEmailQuery);
				ps.setString(1, email);
				ResultSet resultSet=ps.executeQuery();
				
				if(resultSet.next()) {
					int id=resultSet.getInt("id");
					String name=resultSet.getString("name");
					String emaildb=resultSet.getString("email");
					String password=resultSet.getString("password");
					long phone=resultSet.getLong("phone");
					LocalDate dob=resultSet.getDate("dob").toLocalDate();
					int age=resultSet.getInt("age");
					String address=resultSet.getString("address");
					
					Student student=new Student();
					student.setId(id);
					student.setName(name);
					student.setEmail(emaildb);
					student.setPassword(password);
					student.setPhone(phone);
					student.setDob(dob);
					student.setAge(age);
					student.setAddress(address);
					return student;
				}
				return null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		
		
		
		public List<Student> getAllStudentDao(){
			String displayAllStudentQuery="select * from student";
			
			try {
			PreparedStatement ps=connection.prepareStatement(displayAllStudentQuery);
			ResultSet resultSet=ps.executeQuery();
			
			List<Student> students=new ArrayList<Student>();
			
			while(resultSet.next()) {
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String email=resultSet.getString("email");
				String password=resultSet.getString("password");
				long phone=resultSet.getLong("phone");
				LocalDate dob=resultSet.getDate("dob").toLocalDate();
				int age=resultSet.getInt("age");
				String address=resultSet.getString("address");
				
				Student student=new Student();
				student.setId(id);
				student.setName(name);
				student.setEmail(email);
				student.setPassword(password);
				student.setPhone(phone);
				student.setDob(dob);
				student.setAge(age);
				student.setAddress(address);
				
				students.add(student);
			
			}
			return students;
			} catch (SQLException e) {
				
				e.printStackTrace();
				return null;
			}
		}
		
		public List<Student> insertMultipleStudent(List<Student>students){
					String insertMultipleStudentQuery="insert into student(id,name,email,password,phone,dob,age,address) values (?,?,?,?,?,?,?,?)";
					try {
						PreparedStatement ps=connection.prepareStatement(insertMultipleStudentQuery);
						for(Student student:students) {
							ps.setInt(1, student.getId());
							ps.setString(2, student.getName());
							ps.setString(3, student.getEmail());
							ps.setString(4, student.getPassword());
							ps.setLong(5, student.getPhone());
							ps.setObject(6, student.getDob());
							ps.setInt(7, student.getAge());
							ps.setString(8, student.getAddress());
							ps.addBatch();
						}
						
						int a[]=ps.executeBatch();
						if(a.length>0)
							connection.commit();
						System.out.println(a.length+"row affected");
						return students;
					}catch(SQLException e){
						e.printStackTrace();
						return null;
					}
		}
}
