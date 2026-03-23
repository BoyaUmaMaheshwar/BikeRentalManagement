package com.bikeRental.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikeRental.Service.AdminService;

@WebServlet("/updateSuccess")
public class AdminUpdateBikeServlet2 extends HttpServlet {

	private AdminService service = new AdminService();

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String model = req.getParameter("model");
		String brand = req.getParameter("brand");
		String engineCc = req.getParameter("engineCc");
		int mileage = Integer.parseInt(req.getParameter("mileage"));
		String fuelType = req.getParameter("fuelType");
		double price = Double.parseDouble(req.getParameter("price"));
		String rentType = req.getParameter("rentType");
		String available = req.getParameter("available");

		Boolean success = service.updateBike(id, model, brand, engineCc, mileage, fuelType, price, rentType, available);

		if (success) {
			req.setAttribute("msg", "Update Successful");
			req.getRequestDispatcher("AdminHome.jsp").forward(req, res);

		} else {
			req.setAttribute("msg", "Update Unsuccessful");
			req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
		}

	}
}
