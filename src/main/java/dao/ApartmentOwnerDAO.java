package dao;

import configuration.SessionFactoryUtil;
import entity.ApartmentOwner;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApartmentOwnerDAO {

    public static void createApartmentOwner(ApartmentOwner apartmentOwner) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(apartmentOwner);
            transaction.commit();
        }
    }

    public static void updateApartmentOwner(ApartmentOwner apartmentOwner) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            session.saveOrUpdate(apartmentOwner);
            transaction.commit();
        }
    }

    public static void deleteApartmentOwner(ApartmentOwner apartmentOwner) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(apartmentOwner);
            transaction.commit();
        }
    }

    public static ApartmentOwner getApartmentOwnerById(long id) {
        ApartmentOwner apartmentOwner;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartmentOwner = session.get(ApartmentOwner.class, id); //find always searches in the db, get can return a session-associated entity instead
            transaction.commit();
        }
        return apartmentOwner;
    }
}
