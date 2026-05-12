package com.jspider.jdbc_servlet_curd_with_mysql.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateConnectionUtil {
	public static Connection getConnectionWithMySql() {
		Connection connection=null;
		try {
			Driver	driver = new Driver();
			DriverManager.registerDriver(driver);
			
			
			String url="jdbc:mysql://localhost:3306/jdbc-e6";
			String username="root";
			String pass="Ayush@9453";
			connection=DriverManager.getConnection(url,username,pass);
			return connection;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return connection;
		}
		}
	
	public static boolean closeConnection(Connection connection,Statement statement) {
		if(connection!=null) {
			try {
			if(statement!=null) {
				try {
					statement.close();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
				connection.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		return true;
	}
}
