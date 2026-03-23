package com.bikeRental.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bikeRental.Model.Bike;
import com.bikeRental.Model.Booking;
import com.bikeRental.Model.User;
import com.bikeRental.Service.Service;

@WebServlet("/conformBooking")
public class ConformBookingServlet extends HttpServlet {

	private Service service = new Service();

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String start = req.getParameter("start");
		String end = req.getParameter("end");

		LocalDate startDate = LocalDate.parse(start);
		LocalDate endDate = LocalDate.parse(end);

		long days = ChronoUnit.DAYS.between(startDate, endDate);

		if (days <= 0) {
			days = 1;
		}

		HttpSession session = req.getSession(false);

		User user = (User) session.getAttribute("user");
		Bike bike = (Bike) session.getAttribute("bookBike");

		double price = bike.getPrice();

		double totalAmount = price * days;
		LocalDateTime createdAt = LocalDateTime.now();
		String status = "Booking Success";

		Booking booking = service.confirmBooking(startDate, endDate, user, bike, totalAmount, createdAt, status,days);

		if (booking != null) {
			session.setAttribute("booking", booking);
			res.sendRedirect("bookingSuccess.jsp");
		} else {
			req.setAttribute("msg", "Booking Failed");
			req.getRequestDispatcher("UserHome.jsp").forward(req, res);
		}

	}

}