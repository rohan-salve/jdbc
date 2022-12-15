package com.example.jdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	private JdbcUtil() {
		// TODO Auto-generated constructor stub
				
	}
	public static Connection getConnection() throws SQLException
	{
		//jdbc connection object
		Connection connection = null;
		
		//connection requirements
		String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
		String username = "root";
		String password = "Folio@9480m";
		
		//establishing connection via DriverManager
		connection = DriverManager.getConnection(url,username,password);
			
		return connection;
	}
	
	public static void closeConnection(ResultSet resultSet , Statement statement, Connection connection) throws Exception
	{
		if(resultSet != null)
		{
			resultSet.close();
		}
		
		if(statement != null)
		{
			statement.close();
		}
		if(connection != null)
		{ connection.close();
		}
	}
}