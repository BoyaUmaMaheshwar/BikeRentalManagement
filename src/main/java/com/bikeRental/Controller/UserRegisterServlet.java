package com.bikeRental.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikeRental.Service.Service;

@WebServlet("/userRegister")
public class UserRegisterServlet extends HttpServlet {

	private Service service = new Service();

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");

		Boolean success = service.registerUser(name, email, phone, password);

		if (success) {
			res.sendRedirect("UserLogin.jsp");
		} else {
			req.setAttribute("msg", "Email or Phone number already exists");
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
			rd.forward(req, res);
		}

	}

}
