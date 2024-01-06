package dao;

import configuration.SessionFactoryUtil;
import entity.Fees;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FeesDAO {

    public static void createFees(Fees fees) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(fees);
            transaction.commit();
        }
    }

    public static void updateFees(Fees fees) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            session.saveOrUpdate(fees);
            transaction.commit();
        }
    }

    public static void deleteFees(Fees fees) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(fees);
            transaction.commit();
        }
    }

}
