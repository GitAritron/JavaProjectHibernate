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
            Transaction transaction = session.beginTransaction();
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

    public static Tenant getTenantById(long id) {
        Tenant tenant;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            tenant = session.get(Tenant.class, id); //find always searches in the db, get can return a session-associated entity instead
            transaction.commit();
        }
        return tenant;
    }
}
