package com.bikeRental.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bikeRental.Model.Admin;
import com.bikeRental.Model.Bike;
import com.bikeRental.Model.User;
import com.bikeRental.Util.HibernateUtil;

public class AdminDao {

	SessionFactory factory = HibernateUtil.getFactory();

	public Admin adminLogin(String email, String password) {

		Session session = factory.openSession();
		Query<Admin> q = session.createQuery("from Admin where email=:email and password=:pass", Admin.class);
		q.setParameter("email", email);
		q.setParameter("pass", password);
		Admin admin = q.uniqueResult();
		session.close();
		return admin;
	}

	public List<User> showUsers() {

		Session session = factory.openSession();
		Query<User> q = session.createQuery("from User", User.class);
		List<User> user = q.list();
		return user;
	}

	public List<Bike> getAllBikes() {
		Session session = factory.openSession();
		Query<Bike> q = session.createQuery("from Bike", Bike.class);
		List<Bike> bike = q.list();
		session.close();
		return bike;
	}

	public Bike getBikeById(int id) {
		Session session = factory.openSession();
		Bike bike = session.get(Bike.class, id);
		session.close();
		return bike;
	}

	public Boolean updateBike(int id, String model, String brand, String engineCc, int mileage, String fuelType, double price,
			String rentType, String available) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Bike bike = session.get(Bike.class, id);
			if (bike != null) {
				bike.setModel(model);
				bike.setBrand(brand);
				bike.setEngineCc(engineCc);
				bike.setMileage(mileage);
				bike.setFuelType(fuelType);
				bike.setPrice(price);
				bike.setRentType(rentType);
				bike.setAvailable(available);
				tx.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException("Error in updateStudent()" + e);
		} finally {
			session.close();
		}

	}

	public Boolean deleteBike(int id) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			Bike bike = session.get(Bike.class, id);
			if (bike != null) {
				bike.setAvailable("no");
				bike.setInStore("Bike Deleted");
				tx.commit();
				return true;
			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
		return false;
	}

	public Bike addBike(String model, String brand, String engineCc, int mileage, String fuelType, double price,
			String rentType, String available, String inStore) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			Bike bike = new Bike();
			bike.setModel(model);
			bike.setBrand(brand);
			bike.setEngineCc(engineCc);
			bike.setMileage(mileage);
			bike.setFuelType(fuelType);
			bike.setPrice(price);
			bike.setRentType(rentType);
			bike.setAvailable(available);
			bike.setInStore(inStore);
			session.persist(bike);
			tx.commit();
			return bike;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
