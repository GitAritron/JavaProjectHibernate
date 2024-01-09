package dao;

import configuration.SessionFactoryUtil;
import entity.Apartment;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.concurrent.ConcurrentMap;

public class ApartmentDAO {

    public static void createApartment(Apartment apartment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(apartment);
            transaction.commit();
        }
    }

    public static void updateApartment(Apartment apartment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(apartment);
            transaction.commit();
        }
    }

    public static void deleteApartment(Apartment apartment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(apartment);
            transaction.commit();
        }
    }

}
