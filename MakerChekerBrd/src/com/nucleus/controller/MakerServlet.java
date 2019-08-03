package com.nucleus.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.pojo.NewUser;
import com.nucleus.service.Validation;

/**
 * Servlet implementation class MakerServlet
 */
@WebServlet("/MakerServlet")

public class MakerServlet extends HttpServlet {
	private List<String> list;
	private static final long serialVersionUID = 1L;

	public MakerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		RequestDispatcher rd = null;
		if (session.getAttribute("username") == null) {
			rd = request.getRequestDispatcher("Index.jsp");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String code;
		RequestDispatcher rd = null;
		Validation v = new Validation();
		NewUser user = new NewUser();
		String save, delete, update, view, viewBy, update_data, logout, btsub, updatecode;
		save = request.getParameter("save");
		delete = request.getParameter("delete");
		update = request.getParameter("update");
		update_data = request.getParameter("update_data");
		view = request.getParameter("view");
		viewBy = request.getParameter("viewBy");
		logout = request.getParameter("logout");
		btsub = request.getParameter("datatable");
		updatecode = request.getParameter("updatecode");

		if (session.getAttribute("username") == null) {
			rd = request.getRequestDispatcher("Index.jsp");
			rd.include(request, response);
		} else {
			if (save != null) {
				int c = 0;
				NewUser value = setData(request, response, user);
				try {
					c = v.save(value);
					// response.sendRedirect("Maker.jsp");
					request.setAttribute("flag", "No of Record Inserted:" + c);
					RequestDispatcher rd5 = request.getRequestDispatcher("Maker.jsp");
					rd5.include(request, response);
				}

				catch (SQLException e) {
					e.printStackTrace();
				}
			} // save
			else if (delete != null) {
				System.out.println("inside delete");
				code = request.getParameter("customerCode");

				// System.out.println(code);
				try {
					v.delete(code);
					response.sendRedirect("Maker.jsp");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // delete

			else if (update != null) {
				System.out.println("inside update");
				code = request.getParameter("Customername");
				System.out.println(code);
				try {
					int val = v.check(code);
					if (val == 1) {
						NewUser value = v.update(code);
						request.setAttribute("value", value);
						RequestDispatcher rd3 = request.getRequestDispatcher("update.jsp");
						rd3.include(request, response);
					} else if (val > 1) {
						RequestDispatcher rd4 = request.getRequestDispatcher("updatecode.jsp");
						rd4.include(request, response);
					} else if (val == 0) {
						request.setAttribute("flag", "Value doesn't exist in database");
						rd = request.getRequestDispatcher("/Maker.jsp");
						rd.include(request, response);
					} // if
				} // try
				catch (SQLException e) {

					e.printStackTrace();
				} // catch
			} // update
			else if (updatecode != null) {
				System.out.println("inside update");
				code = request.getParameter("CustomerCode");
				System.out.println(code);
				try {
					int val = v.check1(code);
					if (val == 1) {
						NewUser value = v.update1(code);
						request.setAttribute("value", value);
						RequestDispatcher rd9 = request.getRequestDispatcher("update.jsp");
						rd9.include(request, response);
					} else {
						request.setAttribute("alertMsg", "Value doesn't exist in database");
						rd = request.getRequestDispatcher("/Maker.jsp");
						rd.include(request, response);
					} // if
				} // try
				catch (SQLException e) {

					e.printStackTrace();
				} // catch
			} else if (update_data != null) {
				NewUser value = setData(request, response, user);
				try {
					v.update(value);
					response.sendRedirect("Maker.jsp");
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			} else if (view != null) {
				Validation v1 = new Validation();
				System.out.println("inside view post");
				try {
					ArrayList<NewUser> Users = v1.viewAll();
					request.setAttribute("Users", Users);
					RequestDispatcher rd1 = request.getRequestDispatcher("viewAll.jsp");
					rd1.forward(request, response);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // viewAll

			else if (viewBy != null) {
				System.out.println("inside viewBy");
				code = request.getParameter("CustomerCode");
				System.out.println(code);
				try {
					int val = v.check(code);
					if (val == 1) {
						System.out.println("true");
						ArrayList<NewUser> Users = v.viewBy(code);
						request.setAttribute("Users", Users);
						RequestDispatcher rd2 = request.getRequestDispatcher("viewAll.jsp");
						rd2.forward(request, response);
					} else {

					} // if
				} // try
				catch (Exception e) {
					e.printStackTrace();
				}
			} // viewBy
			else if (logout != null) {
				session.invalidate();
				rd = request.getRequestDispatcher("Index.jsp");
				rd.include(request, response);
			} else if (btsub != null) {

				ArrayList<String> ar = new ArrayList<String>();
				String Checked[] = {};
				Checked = request.getParameterValues("check");
				request.getParameterValues("check");

				for (String s : Checked) {
					ar.add(s);
					System.out.println(" " + s);
				}
				System.out.println("hello");
				ArrayList<NewUser> Users = null;
				try {
					Users = v.viewAllChecked(ar);
					request.setAttribute("Users", Users);
					RequestDispatcher rd2 = request.getRequestDispatcher("viewAll.jsp");
					rd2.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println(list.get(2).getCustID());
				// System.out.println(list.get(1).getCustCode());

			}
		}
	}// doPost

	public NewUser setData(HttpServletRequest request, HttpServletResponse response, NewUser user) {
		user.setCustomerCode(request.getParameter("customerCode"));
		user.setCustomerName(request.getParameter("customerName"));
		user.setCustomerAddress1(request.getParameter("address1"));
		user.setCustomerAddress2(request.getParameter("address2"));
		user.setPincode(request.getParameter("pincode"));
		user.setEmail(request.getParameter("email"));
		user.setContact(request.getParameter("contact"));
		user.setPrimaryContactPerson(request.getParameter("primaryContactPerson"));
		user.setStatus(request.getParameter("status"));
		user.setFlag(request.getParameter("flag"));

		return user;
	}// setData
}// class
