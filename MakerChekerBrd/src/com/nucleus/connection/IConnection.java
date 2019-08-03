package com.nucleus.connection;


import java.sql.Connection;
import java.sql.SQLException;
public interface IConnection
{
	
public Connection connect()throws SQLException;

}
