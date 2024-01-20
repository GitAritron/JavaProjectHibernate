package dao;

import configuration.SessionFactoryUtil;
import dto.ApartmentTenantsAbove7UseLiftDTO;
import entity.Apartment;
import entity.Tenant;
import net.bytebuddy.asm.Advice;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.time.LocalDate;

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


    public static ApartmentTenantsAbove7UseLiftDTO getApartmentTenantsAbove7UseLiftDTO(Apartment apartment) {
        ApartmentTenantsAbove7UseLiftDTO tenantsDTO = new ApartmentTenantsAbove7UseLiftDTO(0L);
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            LocalDate sevYAgo = LocalDate.now().minusYears(7L);
            Transaction transaction = session.beginTransaction();
            tenantsDTO = session.createQuery("""
                                    select new dto.ApartmentTenantsAbove7UseLiftDTO(COUNT(t.id))
                                    from Tenant t
                                    where t.apartment = :a and t.usesLift=true and t.birthdate < :sevYAgo
                                    group by t.apartment
                                                                        """,
                            ApartmentTenantsAbove7UseLiftDTO.class)
                    .setParameter("a", apartment)
                    .setParameter("sevYAgo", sevYAgo )
                    .getSingleResult();
            transaction.commit();
        } catch (NoResultException e){
            System.out.println("No entity found for query \"getApartmentTenantsAbove7UseLiftDTO\"");
        }


        return tenantsDTO;
    }
}
