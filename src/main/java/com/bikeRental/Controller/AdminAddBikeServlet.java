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

@WebServlet("/adminAddBike")
public class AdminAddBikeServlet extends HttpServlet {

	private AdminService service = new AdminService();

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String model = req.getParameter("model");
		String brand = req.getParameter("brand");
		String engineCc = req.getParameter("engineCc");
		int mileage = Integer.parseInt(req.getParameter("mileage"));
		String fuelType = req.getParameter("fuelType");
		double price = Double.parseDouble(req.getParameter("price"));
		String rentType = req.getParameter("rentType");
		String available = req.getParameter("available");
		String inStore = req.getParameter("inStore");

		Bike bike = service.addBike(model, brand, engineCc, mileage, fuelType, price, rentType, available, inStore);

		HttpSession session = req.getSession(false);

		if (session != null && bike != null) {
			req.setAttribute("msg", "Bike Added Successfully");
			req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "Failed");
			req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
		}

	}
}
