package com.bikeRental.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bikeRental.Model.User;
import com.bikeRental.Service.Service;

@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	private Service service = new Service();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = service.userLogin(email, password);

		if (user != null) {
			HttpSession old = req.getSession(false);
			if (old != null) {
				old.invalidate();
			}
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			res.sendRedirect("UserHome.jsp");
		} else {
			req.setAttribute("msg", "Account not found");
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
			rd.forward(req, res);
		}

	}
}