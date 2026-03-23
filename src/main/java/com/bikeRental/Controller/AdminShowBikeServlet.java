package com.bikeRental.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bikeRental.Model.Bike;
import com.bikeRental.Service.AdminService;

@WebServlet("/adminShowBikes")
public class AdminShowBikeServlet extends HttpServlet {

	private AdminService service = new AdminService();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null) {

			List<Bike> bike = service.getAllBikes();

			if (bike != null) {
				session.setAttribute("showBikes", bike);
				res.sendRedirect("AdminShowBike.jsp");
			}else {
				req.setAttribute("msg", "No Bikes Found");
				req.getRequestDispatcher("AdminShowBike.jsp").forward(req, res);
			}

		}else {
			res.sendRedirect("index.jsp");
		}

	}
}
