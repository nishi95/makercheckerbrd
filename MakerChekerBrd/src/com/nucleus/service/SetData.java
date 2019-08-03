package com.nucleus.service;

import java.sql.SQLException;

import com.nucleus.DAO.UserDAO;
import com.nucleus.controller.LoginServlet;
import com.nucleus.dao.UserDao;
import com.nucleus.model.UserLogin;
import com.nucleus.pojo.LoginPOJO;

public class SetData 
{
	int r;
	String user_role;
	 UserLogin userlogin=new  UserLogin();
public String set(String uname,String pass) throws SQLException
{
	UserDao dao=new UserDao();
	userlogin.setUsername(uname);
	userlogin.setPassword(pass);
	r=dao.getData(userlogin);
	System.out.println(r+" role ");
	if(r==1)
		{
			user_role="maker";
			
		}
		else if (r==2)
		{
			user_role="checker";
			
		}

	//System.out.println("role is "+user_role);
	return user_role;
	
}

}

//public String Role(int role) 
//{
//	LoginServlet s=new LoginServlet();
//	
//	String user_role=null,r;
//	int value=role;
//	if(value==1)
//	{
//		user_role="maker";
//		
//	}
//	else if (value==2)
//	{
//		user_role="checker";
//		
//	}
//	pojo.setRole(user_role);
//	r=pojo.getRole();
//	
//	return user_role;
//	
//}
//}
