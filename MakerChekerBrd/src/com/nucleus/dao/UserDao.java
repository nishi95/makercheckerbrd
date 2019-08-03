package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nucleus.connection.ConnectionI;
import com.nucleus.connection.Factory;
import com.nucleus.model.UserLogin;
import com.nucleus.pojo.LoginPOJO;
import com.nucleus.service.SetData;
import com.nucleus.service.Validation;

public class UserDao 
{
public int getData(UserLogin userlogin) throws SQLException
{
	SetData sd=new SetData();
	Validation v=new Validation();
	String username,password;
	int role = 0;
	Factory f=new Factory();
	ConnectionI cn=Factory.getFactory("Oracle");
	Connection conn=cn.connect();
	PreparedStatement pstmt=null;

	username=userlogin.getUsername();
	password=userlogin.getPassword();
	
	try
	{
		pstmt=conn.prepareStatement("Select * from user_pm where username=?");
		pstmt.setString(1, username);
		ResultSet result=pstmt.executeQuery();
		while(result.next())
		{
			
		
		if(result.getString(1).equalsIgnoreCase(username)&&result.getString(2).equalsIgnoreCase(password))
		{
			role=result.getInt(3);
			if(role==1)
			role=1;
			
			
		}
		else if(result.getString(1).equalsIgnoreCase(username)&&result.getString(2).equalsIgnoreCase(password))
		{
			role=result.getInt(3);
		if(role==2)
			role=2;
			
		}
		else
		{
			System.out.println("Authentication problem");
		}
	}
	}
	catch(Exception e)
	{
		//e.printStackTrace();
	}
	conn.close();
	return role;
	}
}

