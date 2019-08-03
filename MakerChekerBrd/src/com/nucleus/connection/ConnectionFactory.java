package com.nucleus.connection;

import oracle.jdbc.driver.OracleConnection;

public class ConnectionFactory
{
public static IConnection getFactory(String type)
{
	if(type.equalsIgnoreCase("Oracle"))
	{
return new DataBaseConnection();
	}
	else
	{
	return null;

}
}
}