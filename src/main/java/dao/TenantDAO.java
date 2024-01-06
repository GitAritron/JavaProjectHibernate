package dao;

import configuration.SessionFactoryUtil;
import entity.Tenant;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TenantDAO {

    public static void createTenant(Tenant tenant) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(tenant);
            transaction.commit();
        }
    }

    public static void updateTenant(Tenant tenant) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            session.saveOrUpdate(tenant);
            transaction.commit();
        }
    }

    public static void deleteTenant(Tenant tenant) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(tenant);
            transaction.commit();
        }
    }

}
