package com.bikeRental.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.bikeRental.Model.Admin;
import com.bikeRental.Model.Bike;
import com.bikeRental.Model.Booking;
import com.bikeRental.Model.User;

public class HibernateUtil {

    private static SessionFactory factory;

    static {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .loadProperties("hibernate.properties")
                    .build();

            Metadata metadata = new MetadataSources(serviceRegistry)
                    .addAnnotatedClass(Bike.class)
                    .addAnnotatedClass(Booking.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Admin.class)
                    .buildMetadata();

            factory = metadata.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
