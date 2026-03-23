package com.bikeRental.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bikeRental.Model.Booking;
import com.bikeRental.Model.User;
import com.bikeRental.Service.Service;

@WebServlet("/viewBookings")
public class ViewBookingHistoryServlet extends HttpServlet {

	private Service service = new Service();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");

		int id = user.getId();

		List<Booking> bookings = service.getUserBookings(id);

		if (bookings != null && session != null) {
			session.setAttribute("userBookings", bookings);
			res.sendRedirect("showUserBookings.jsp");
		} else {
			req.getRequestDispatcher("UserLogin.jsp").forward(req, res);
		}

	}

}
