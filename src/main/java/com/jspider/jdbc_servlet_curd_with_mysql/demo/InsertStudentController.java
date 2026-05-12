package com.jspider.jdbc_servlet_curd_with_mysql.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertStudentController {
		public static void main(String[] args) {
			Connection connection=null;
			Statement statement=null;
			try {	
//       step 1: load/register the driver
//			
//				Driver driver=new Driver();
//				DriverManager.registerDriver(driver);
//				create connection with mysql by using url , username,pass
//				String url="jdbc:mysql://localhost:3306/jdbc-e6";
//				String username="root";
//				String pass="Ayush@9453";
//				connection=DriverManager.getConnection(url, username, pass);
				 connection=CreateConnectionUtil.getConnectionWithMySql();
//				create statement
				statement=connection.createStatement();
				
//				Execute query
				String insertQuery="insert into student(id,name,email,password,phone,dob,age,address) values (103,'Ayush','abc@gmail.com','asde',9868998889,'2003-01-01',23,'gkp')";
				int a=statement.executeUpdate(insertQuery);
				System.out.println(a!=0?"success":"fail");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
//				if(statement!=null) {
//					try {
//						statement.close();
//					} catch (SQLException e) {
//						
//						e.printStackTrace();
//					}
//				}
//				if(connection!=null) {
//					try {
//						connection.close();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				
				boolean res=CreateConnectionUtil.closeConnection(connection, statement);
				System.out.println(res?"Connection closed successfully":"Connection not closed successfully");
			}
			
		}
}
