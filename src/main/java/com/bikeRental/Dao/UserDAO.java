package com.bikeRental.Dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bikeRental.Model.Bike;
import com.bikeRental.Model.Booking;
import com.bikeRental.Model.User;
import com.bikeRental.Util.HibernateUtil;

public class UserDAO {
	SessionFactory factory = HibernateUtil.getFactory();

	public Boolean registerUser(String name, String email, String phone, String password) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setPassword(password);

			session.persist(user);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			session.close();
		}

	}

	public User userLogin(String email, String password) {
		Session session = factory.openSession();
		Query<User> q = session.createQuery("from User where email=:email and password=:pass", User.class);
		q.setParameter("email", email);
		q.setParameter("pass", password);
		User user = q.uniqueResult();
		session.close();
		return user;

	}

	public List<Bike> showBikes() {
		Session session = factory.openSession();
		Query<Bike> q = session.createQuery("from Bike where available='yes' ", Bike.class);
		List<Bike> bike = q.list();
		session.close();
		return bike;
	}

	public Bike getBikeById(int bikeId) {
		Session session = factory.openSession();
		Query<Bike> q = session.createQuery("from Bike where id=:id", Bike.class);
		q.setParameter("id", bikeId);
		Bike bike = q.uniqueResult();
		session.close();
		return bike;
	}

	public Booking confirmBooking(LocalDate startDate, LocalDate endDate, User user, Bike bike, double totalAmount,
			LocalDateTime createdAt, String status, long days) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Booking booking = new Booking();
			booking.setUser(user);
			booking.setBike(bike);
			booking.setTotalAmount(totalAmount);
			booking.setStatus(status);
			booking.setStartDate(startDate);
			booking.setEndDate(endDate);
			booking.setCreatedAt(createdAt);
			booking.setDays(days);
			booking.setRideStatus("pending");
			session.persist(booking);
			tx.commit();
			return booking;

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();

//			Session session2 = factory.openSession();
//			Transaction tx2 = session2.beginTransaction();
//			Booking failedBooking = new Booking();
//			failedBooking.setUser(user);
//			failedBooking.setBike(bike);
//			failedBooking.setTotalAmount(totalAmount);
//			failedBooking.setStatus("Failed");
//			failedBooking.setStartDate(startDate);
//			failedBooking.setEndDate(endDate);
//			failedBooking.setCreatedAt(createdAt);
//			session2.persist(failedBooking);
//			tx2.commit();
//			session2.close();
			return null;
		} finally {
			session.close();
		}

	}

	public List<Booking> getUserBookings(int id) {
		Session session = factory.openSession();

		Query<Booking> q = session.createQuery("from Booking where user.id=:id", Booking.class);
		q.setParameter("id", id);
		List<Booking> booking = q.list();
		session.close();
		
		return booking;
	}

}
