package com.bikeRental.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bikeRental.Model.Bike;
import com.bikeRental.Service.Service;

@WebServlet("/bikeBooking")
public class BookingServlet extends HttpServlet {

	private Service service = new Service();

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int bikeId = Integer.parseInt(req.getParameter("id"));

		Bike bookBike = service.getBikeById(bikeId);

		HttpSession session = req.getSession(false);

		if (bookBike != null && session != null) {
			session.setAttribute("bookBike", bookBike);
			res.sendRedirect("booking.jsp");
		} else {
			res.sendRedirect("UserLogin.jsp");
		}

	}

}
