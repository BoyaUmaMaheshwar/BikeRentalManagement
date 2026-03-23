package com.bikeRental.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bikeRental.Model.User;
import com.bikeRental.Service.AdminService;

@WebServlet("/adminShowUsers")
public class ShowUsersServlet extends HttpServlet {

	private AdminService service = new AdminService();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		System.out.println(session);
		if (session != null) {
			List<User> user = service.showUsers();

			if (user != null) {
				session.setAttribute("user", user);
				res.sendRedirect("AdminShowUser.jsp");
			} else {
				req.setAttribute("msg", "No Users Found");
				req.getRequestDispatcher("AdminShowUser.jsp").forward(req, res);
			}
		} else {
			res.sendRedirect("index.jsp");
		}

	}

}
