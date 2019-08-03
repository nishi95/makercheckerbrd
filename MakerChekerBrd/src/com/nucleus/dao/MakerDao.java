package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nucleus.connection.ConnectionI;
import com.nucleus.connection.Factory;
import com.nucleus.model.NewUser;
import com.nucleus.validation.ValidateData;

public class MakerDao implements InterfaceDao {
	ValidateData valid = new ValidateData();
	Factory f = new Factory();
	ConnectionI cn = Factory.getFactory("Oracle");
	Connection conn = null;
	PreparedStatement pstmt = null;

	/*------------------------------------SAVE--------------------------------------------------*/

	public int saveData(NewUser data) throws SQLException {
		int count = 0;
		// Checking_the_validation_part
		if (valid.checkCode(data.getCustomerCode()) && valid.checkName(data.getCustomerName())
				&& valid.checkAddress(data.getCustomerAddress1()) && valid.checkPincode(data.getPincode())
				&& valid.checkEmail(data.getEmail()) && valid.checkContact(data.getContact())
				&& valid.checkPrimarycp(data.getPrimaryContactPerson()) && valid.checkRecord(data.getStatus())
				&& valid.checkFlag(data.getFlag()) && valid.checkCreatedDate(data.getCreatedDate())
				&& valid.checkCreatedBy(data.getCreatedBy())) {
			conn = cn.connect();
			String s = data.getCustomerCode();
			System.out.println(s);
			pstmt = conn.prepareStatement("Select * from cust_master_pm where customer_code=?");
			pstmt.setString(1, data.getCustomerCode());
			ResultSet result = pstmt.executeQuery();
			boolean a = result.next();
			System.out.println(a);
			if (a == true) {
				System.out.println("data already exist");
			} else if (a == false) {
				try {
					pstmt = conn.prepareStatement(
							"insert into cust_master_pm values(sequence_pm.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1, data.getCustomerCode());
					pstmt.setString(2, data.getCustomerName());
					pstmt.setString(3, data.getCustomerAddress1());
					pstmt.setString(4, data.getCustomerAddress2());
					pstmt.setString(5, data.getPincode());
					pstmt.setString(6, data.getEmail());
					pstmt.setString(7, data.getContact());
					pstmt.setString(8, data.getPrimaryContactPerson());
					pstmt.setString(9, data.getStatus());
					pstmt.setString(10, data.getFlag());
					pstmt.setString(11, data.getCreatedDate());
					pstmt.setString(12, data.getCreatedBy());
					pstmt.setString(13, data.getModifiedDate());
					pstmt.setString(14, data.getModifiedBy());
					pstmt.setString(15, data.getAuthorizedDate());
					pstmt.setString(16, data.getAuthorizedBy());

					System.out.println("Data saved");
					count = pstmt.executeUpdate();
					conn.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} // database

		} // validation
		else {
			System.out.println("Error found, Please enter valid data");
		} // validation
		return count;
	}

	/*------------------------------------DELETE--------------------------------------------------*/

	public void deleteData(String s) throws SQLException {
		conn = cn.connect();
		String code = s;
		// System.out.println(code);
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from cust_master_pm where customer_name=?");
			pstmt.setString(1, code);
			int count = pstmt.executeUpdate();
			System.out.println("deleted");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		conn.close();
	}// deleteData

	/*------------------------------------CHECKINGDATABSE--------------------------------------------------*/

	public int check(String value) throws SQLException {
		conn = cn.connect();
		PreparedStatement pstmt = null;
		String code = value;
		int count = 0;
		pstmt = conn.prepareStatement("Select * from cust_master_pm where customer_name=?");
		pstmt.setString(1, code);
		ResultSet result = pstmt.executeQuery();
		while (result.next()) {
			count = result.getRow();
		}

		conn.close();
		return count;

	}

	/*------------------------------------DATA TO BE UPDATED--------------------------------------------------*/

	public NewUser update(String c) {
		PreparedStatement stmt = null;
		NewUser users = new NewUser();
		Connection conn = null;
		try {

			String code = c;
			conn = cn.connect();
			// System.out.println("dao"+code);
			stmt = conn.prepareStatement("Select * from cust_master_pm where customer_name=?");
			stmt.setString(1, code);
			ResultSet res = stmt.executeQuery();
			boolean set = res.next();
			// System.out.println("before: "+set);
			// System.out.println("result"+res.getString(2));
			if (set == true) {
				users.setCustomerCode(res.getString(2));
				users.setCustomerName(res.getString(3));
				// System.out.println(res.getString(2));
				// System.out.println(res.getString(3));
				users.setCustomerAddress1(res.getString(4));
				users.setCustomerAddress2(res.getString(5));
				users.setPincode(res.getString(6));
				users.setEmail(res.getString(7));
				users.setContact(res.getString(8));
				users.setPrimaryContactPerson(res.getString(9));
				users.setStatus(res.getString(10));
				users.setFlag(res.getString(11));
				users.setCreatedDate(res.getString(12));
				users.setCreatedBy(res.getString(13));
				users.setModifiedDate(res.getString(14));
				users.setModifiedBy(res.getString(15));
				users.setAuthorizedBy(res.getString(16));
				users.setAuthorizedBy(res.getString(17));
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(users.getCustomerAddress1());
		return users;

	}

	/*------------------------------------VIEW   ALL--------------------------------------------------*/

	public ArrayList<NewUser> viewAll() throws SQLException {

		// System.out.println("inside dao");
		ArrayList<NewUser> Users = new ArrayList<NewUser>();
		conn = cn.connect();
		pstmt = conn.prepareStatement("select * from cust_master_pm");
		ResultSet result = pstmt.executeQuery();
		while (result.next()) {
			NewUser user = new NewUser();
			user.setCustomerId(result.getString(1));
			user.setCustomerCode(result.getString(2));
			user.setCustomerName(result.getString(3));
			user.setCustomerAddress1(result.getString(4));
			user.setCustomerAddress2(result.getString(5));
			user.setPincode(result.getString(6));
			user.setEmail(result.getString(7));
			user.setContact(result.getString(8));
			user.setPrimaryContactPerson(result.getString(9));
			user.setStatus(result.getString(10));
			user.setFlag(result.getString(11));
			user.setCreatedDate(result.getString(12));
			user.setCreatedBy(result.getString(13));
			user.setModifiedDate(result.getString(14));
			user.setModifiedBy(result.getString(15));
			user.setAuthorizedBy(result.getString(16));
			user.setAuthorizedBy(result.getString(17));
			// System.out.println("Hello oracle dao view");
			Users.add(user);
			// System.out.println(Users);

		}
		conn.close();
		return Users;

	}

	/*------------------------------------VIEW BY ID--------------------------------------------------*/

	public ArrayList<NewUser> viewBy(String c) throws SQLException {
		NewUser user = new NewUser();
		String code = c;
		ArrayList<NewUser> Users = new ArrayList<NewUser>();
		conn = cn.connect();
		pstmt = conn.prepareStatement("select * from cust_master_pm where customer_name=?");
		pstmt.setString(1, code);
		ResultSet result = pstmt.executeQuery();
		while (result.next()) {
			user.setCustomerId(result.getString(1));
			user.setCustomerCode(result.getString(2));
			user.setCustomerName(result.getString(3));
			user.setCustomerAddress1(result.getString(4));
			user.setCustomerAddress2(result.getString(5));
			user.setPincode(result.getString(6));
			user.setEmail(result.getString(7));
			user.setContact(result.getString(8));
			user.setPrimaryContactPerson(result.getString(9));
			user.setStatus(result.getString(10));
			user.setFlag(result.getString(11));
			user.setCreatedDate(result.getString(12));
			user.setCreatedBy(result.getString(13));
			user.setModifiedDate(result.getString(14));
			user.setModifiedBy(result.getString(15));
			user.setAuthorizedBy(result.getString(16));
			user.setAuthorizedBy(result.getString(17));
			// System.out.println("Hello oracle dao view");
			Users.add(user);
			System.out.println(Users);
		}
		conn.close();
		return Users;

	}

	/*------------------------------------UPDATING DATA--------------------------------------------------*/

	public void update(NewUser value) throws SQLException {
		PreparedStatement ustmt = null;
		conn = cn.connect();
		try {
			// System.out.println("updating "+value.getCustomerAddress1());
			if (valid.checkName(value.getCustomerName()) && valid.checkAddress(value.getCustomerAddress1())
					&& valid.checkPincode(value.getPincode()) && valid.checkEmail(value.getEmail())
					&& valid.checkContact(value.getContact())
					&& valid.checkPrimarycp(value.getPrimaryContactPerson())) {
				ustmt = conn.prepareStatement(
						"update cust_master_pm set customer_name=?,customer_address1=?,customer_address2=?,customer_pin=?,email_address=?,contact_number=?,primary_contact_person=?,record_status=?,active_inactive_flag=? where customer_code=?");
				ustmt.setString(1, value.getCustomerName());
				ustmt.setString(2, value.getCustomerAddress1());
				ustmt.setString(3, value.getCustomerAddress2());
				ustmt.setString(4, value.getPincode());
				ustmt.setString(5, value.getEmail());
				ustmt.setString(6, value.getContact());
				ustmt.setString(7, value.getPrimaryContactPerson());
				ustmt.setString(8, value.getStatus());
				ustmt.setString(9, value.getFlag());
				ustmt.setString(10, value.getCustomerCode());

				int count = ustmt.executeUpdate();
				System.out.println("String Updated");
				System.out.println("count : " + count);
			} else {
				System.out.println("Error in Entered Data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();

	}

	public ArrayList<NewUser> viewAllCheckedDao(ArrayList<String> ar) throws SQLException {
		conn = cn.connect();
		ArrayList<NewUser> list = new ArrayList<NewUser>();
		int i = 0;
		int size = ar.size();

		while (size != 0) {

			pstmt = conn.prepareStatement("Select * from cust_master_pm where customer_code=?");
			System.out.println("In customer dao" + ar.get(i));
			pstmt.setString(1, (String) ar.get(i));
			i++;
			size--;
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				NewUser user = new NewUser();
				user.setCustomerId(rs.getString(1));
				user.setCustomerCode(rs.getString(2));
				user.setCustomerName(rs.getString(3));
				user.setCustomerAddress1(rs.getString(4));
				user.setCustomerAddress2(rs.getString(5));
				user.setPincode(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setContact(rs.getString(8));
				user.setPrimaryContactPerson(rs.getString(9));
				user.setStatus(rs.getString(10));
				user.setFlag(rs.getString(11));
				user.setCreatedDate(rs.getString(12));
				user.setCreatedBy(rs.getString(13));
				user.setModifiedDate(rs.getString(14));
				user.setModifiedBy(rs.getString(15));
				user.setAuthorizedBy(rs.getString(16));
				user.setAuthorizedBy(rs.getString(17));
				// System.out.println("Hello oracle dao view");
				list.add(user);
				System.out.println(list);
			}
		}
		conn.close();
		return list;

	}

	public int check1(String value) throws SQLException {
		conn = cn.connect();
		PreparedStatement pstmt = null;
		String code = value;
		int count = 0;
		pstmt = conn.prepareStatement("Select * from cust_master_pm where customer_code=?");
		pstmt.setString(1, code);
		ResultSet result = pstmt.executeQuery();
		while (result.next()) {
			count = result.getRow();
		}
		conn.close();
		return count;
	}

	public NewUser update1(String c) {
		PreparedStatement stmt = null;
		NewUser users = new NewUser();
		Connection conn = null;
		try {

			String code = c;
			conn = cn.connect();
			// System.out.println("dao"+code);
			stmt = conn.prepareStatement("Select * from cust_master_pm where customer_code=?");
			stmt.setString(1, code);
			ResultSet res = stmt.executeQuery();
			boolean set = res.next();
			// System.out.println("before: "+set);
			// System.out.println("result"+res.getString(2));
			if (set == true) {
				users.setCustomerCode(res.getString(2));
				users.setCustomerName(res.getString(3));
				// System.out.println(res.getString(2));
				// System.out.println(res.getString(3));
				users.setCustomerAddress1(res.getString(4));
				users.setCustomerAddress2(res.getString(5));
				users.setPincode(res.getString(6));
				users.setEmail(res.getString(7));
				users.setContact(res.getString(8));
				users.setPrimaryContactPerson(res.getString(9));
				users.setStatus(res.getString(10));
				users.setFlag(res.getString(11));
				users.setCreatedDate(res.getString(12));
				users.setCreatedBy(res.getString(13));
				users.setModifiedDate(res.getString(14));
				users.setModifiedBy(res.getString(15));
				users.setAuthorizedBy(res.getString(16));
				users.setAuthorizedBy(res.getString(17));
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(users.getCustomerAddress1());
		return users;

	}

}
