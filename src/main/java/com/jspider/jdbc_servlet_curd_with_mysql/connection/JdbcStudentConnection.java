package com.jspider.jdbc_servlet_curd_with_mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JdbcStudentConnection {
       public static Connection getJdbcStudentConnection() {
    	   try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			String url="jdbc:mysql://localhost:3306/jdbc-e6";
			String user="root";
			String pass="Ayush@9453";
			Connection connection =DriverManager.getConnection(url,user,pass);
			return connection;
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		   }
       }
}
