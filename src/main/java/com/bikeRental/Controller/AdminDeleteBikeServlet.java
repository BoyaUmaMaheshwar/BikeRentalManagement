package com.bikeRental.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bikeRental.Service.AdminService;

@WebServlet("/deleteBike")
public class AdminDeleteBikeServlet extends HttpServlet {
	
	private AdminService service = new AdminService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		HttpSession session = req.getSession(false);

		if (session != null) {
			Boolean success = service.deleteBike(id);
			
			if(success) {
				req.setAttribute("msg", "Bike Deleted Successfully");
				req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
			}else {
				req.setAttribute("msg", "Bike Deleted Failed");
				req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
			}
			
		}

	}
}
