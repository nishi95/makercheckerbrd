package com.nucleus.dao;
import java.sql.SQLException;
import com.nucleus.model.NewUser;


public interface InterfaceDao
{
	public int saveData(NewUser data) throws SQLException;
}
