package com.nucleus.connection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class DataBaseConnection implements IConnection
{
	
	Connection conn=null;
	@Override
	public Connection connect() throws SQLException 
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn=DriverManager.getConnection("jdbc:oracle:thin:@10.1.50.198:1521:orcl", "sh", "sh");
		System.out.println("Sucessfully connected");
		return conn;
	}

}
