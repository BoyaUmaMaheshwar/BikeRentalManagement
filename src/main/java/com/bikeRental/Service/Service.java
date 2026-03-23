package com.bikeRental.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.bikeRental.Dao.UserDAO;
import com.bikeRental.Model.Bike;
import com.bikeRental.Model.Booking;
import com.bikeRental.Model.User;

public class Service {
	
	private UserDAO userdao = new UserDAO();
	
	public Boolean registerUser(String name, String email, String phone, String password) {
		
		return userdao.registerUser(name,email,phone,password);
	}

	public User userLogin(String email, String password) {
		return userdao.userLogin(email,password);
	}

	public List<Bike> showBikes() {
		return userdao.showBikes();
	}

	public Bike getBikeById(int bikeId) {
		return userdao.getBikeById(bikeId);
	}

	public Booking confirmBooking(LocalDate startDate, LocalDate endDate, User user, Bike bike, double totalAmount,
			LocalDateTime createdAt, String status, long days) {
		return userdao.confirmBooking(startDate,endDate,user,bike,totalAmount,createdAt,status,days);
	}

	public List<Booking> getUserBookings(int id) {
		return userdao.getUserBookings(id);
	}

}
