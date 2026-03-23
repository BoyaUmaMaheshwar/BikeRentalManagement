package com.bikeRental.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bikeRental.Model.Admin;
import com.bikeRental.Service.AdminService;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

	private AdminService service = new AdminService();

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Admin admin = service.adminLogin(email, password);

		if (admin != null) {
			HttpSession old = req.getSession(false);
			if (old != null) {
				old.invalidate();
			}
			HttpSession session = req.getSession();

			session.setAttribute("admin", admin);
			res.sendRedirect("AdminHome.jsp");

		} else {
			req.setAttribute("msg", "Invalid Credentials");
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
		}

	}

}
