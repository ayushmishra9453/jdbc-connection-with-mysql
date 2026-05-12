package com.jspider.jdbc_servlet_curd_with_mysql.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.mysql.cj.jdbc.Driver;
 
public class DisplayStudentController {
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		
		try {
            //	step1 load/register driver
//			Driver driver=new Driver();
//			DriverManager.registerDriver(driver);
			//	 step 2 : create connection
//			String url="jdbc:mysql://localhost:3306/jdbc-e6";
//			String user="root";
//			String pass="Ayush@9453";
//			connection = DriverManager.getConnection(url,user,pass);
			
			connection=CreateConnectionUtil.getConnectionWithMySql();
			// create statement to send sql query
			statement=connection.createStatement();
			// step-4 execute sql query
			String displayAllStudentQuery="select * from student";
			ResultSet resultSet=statement.executeQuery(displayAllStudentQuery);
			while(resultSet.next()) {
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String email=resultSet.getString("email");
				String password=resultSet.getString("password");
				long phone=resultSet.getLong("phone");
				LocalDate dob=resultSet.getDate("dob").toLocalDate();
				int age=resultSet.getInt("age");
				String address=resultSet.getString("address");
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println(password);
				System.out.println(phone);
				System.out.println(dob);
				System.out.println(age);
				System.out.println(address);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
//			if(statement!=null) {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if(connection!=null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			
			boolean res=CreateConnectionUtil.closeConnection(connection, statement);
			System.out.println(res?"connection closed successfully":"Connection closing fail");
		}
	}
}
