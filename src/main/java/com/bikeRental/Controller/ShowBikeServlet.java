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
import com.bikeRental.Service.Service;

@WebServlet("/showBikes")
public class ShowBikeServlet extends HttpServlet {

	private Service service = new Service();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<Bike> bike = service.showBikes();

		if (bike != null) {
			HttpSession session = req.getSession(false);
			session.setAttribute("showBikes", bike);
			res.sendRedirect("showBikes.jsp");
		} else {
			res.sendRedirect("UserLogin.jsp");
		}
	}

}
