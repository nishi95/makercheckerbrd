package com.nucleus.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nucleus.DAO.MakerDAO;
import com.nucleus.DAO.UserDAO;
import com.nucleus.controller.LoginServlet;
import com.nucleus.controller.MakerServlet;
import com.nucleus.pojo.LoginPOJO;
import com.nucleus.pojo.NewUser;

public class Validation 
{
MakerDAO dao=new MakerDAO();

public int save(NewUser n) throws SQLException 
{
	Date date=new Date();
	SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
	String d=format.format(date);
	System.out.println(n.getCustomerCode());
	n.setCreatedDate(d.toString());
	n.setCreatedBy("Maker");
	int c=dao.saveData(n);
	return c;
}

public void delete(String code) throws SQLException 
{
	String value=code;
//	System.out.print(value);
	dao.deleteData(value);	
	
}

public int check(String code)throws SQLException
{
	String value=code;
	int val=dao.check(value);
	return val;
	
}
public NewUser update(String code)throws SQLException
{
	String c=code;
	NewUser user=new NewUser();
	user=dao.update(c);
	return user;
	
}



public ArrayList<NewUser> viewAll() throws SQLException 
{
	System.out.println("inside service");
	ArrayList <NewUser> Users=dao.viewAll();
	return Users;
	
}

public ArrayList<NewUser> viewBy(String code)throws SQLException
{
	ArrayList <NewUser> Users=dao.viewBy(code);
	return Users;
	
}

public void update(NewUser value) 
{
	try {
		dao.update(value);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public ArrayList<NewUser> viewAllChecked(ArrayList<String> ar) throws SQLException 
{
	ArrayList<NewUser> list=dao.viewAllCheckedDao(ar);
	return list;
	
}

public int check1(String code) throws SQLException {
	
	String value=code;
	int val=dao.check1(value);
	return val;
}

public NewUser update1(String code) {
	
	String c=code;
	NewUser user=new NewUser();
	user=dao.update1(c);
	return user;
}

}

