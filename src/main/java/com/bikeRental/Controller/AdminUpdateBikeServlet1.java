package com.bikeRental.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bikeRental.Model.Bike;
import com.bikeRental.Service.AdminService;

@WebServlet("/updateBike")
public class AdminUpdateBikeServlet1 extends HttpServlet {

	private AdminService service = new AdminService();

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		Bike bikeById = service.getBikeById(id);

		HttpSession session = req.getSession(false);

		if (session != null) {
			session.setAttribute("bikeById", bikeById);
			res.sendRedirect("AdminUpdateBike.jsp");
		} else {
			res.sendRedirect("index.jsp");
		}

	}
}
