package com.bikeRental.Service;

import java.util.List;

import com.bikeRental.Dao.AdminDao;
import com.bikeRental.Model.Admin;
import com.bikeRental.Model.Bike;
import com.bikeRental.Model.User;

public class AdminService {
	private AdminDao dao = new AdminDao();
	public Admin adminLogin(String email, String password) {
		return dao.adminLogin(email,password);
	}
	public List<User> showUsers() {
		return dao.showUsers();
	}
	public List<Bike> getAllBikes() {
		return dao.getAllBikes();
	}
	public Bike getBikeById(int id) {
		return dao.getBikeById(id);
	}
	public Boolean updateBike(int id, String model, String brand, String engineCc, int mileage, String fuelType, double price,
			String rentType, String available) {
		return dao.updateBike(id,model,brand,engineCc,mileage,fuelType,price,rentType,available);
	}
	public Boolean deleteBike(int id) {
		return dao.deleteBike(id);
	}
	public Bike addBike(String model, String brand, String engineCc, int mileage, String fuelType, double price,
			String rentType, String available, String inStore) {
		return dao.addBike(model,brand,engineCc,mileage,fuelType,price,rentType,available,inStore);
	}

}
