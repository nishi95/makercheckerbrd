package com.nucleus.dao;

public class DaoFactory
{
	public static InterfaceDao getDAO(String type)
	{
		if(type.equalsIgnoreCase("Oracle"))
		{
	return new MakerDAO();
		}
		
		else
		{
		return null;

	}
	
}
}
