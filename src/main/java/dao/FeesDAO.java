package dao;

import configuration.SessionFactoryUtil;
import dto.BuildingFeesApartmentAreaDTO;
import entity.Apartment;
import entity.Fees;
import net.bytebuddy.asm.Advice;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

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
            Transaction transaction = session.beginTransaction();
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

    public static Fees calculateMonthFees(Apartment apartment) {
        Fees fees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            BuildingFeesApartmentAreaDTO bFeesAndArea = ApartmentDAO.getBuildingFeesAndApartmentArea(apartment);
            double feesAmount = bFeesAndArea.getArea() * bFeesAndArea.getSquareMeterFee() + TenantDAO.getApartmentTenantsAbove7UseLiftDTO(apartment).getTenants() * bFeesAndArea.getLiftFee() + PetDAO.getApartmentPets(apartment).getPets() * bFeesAndArea.getPetFee();
            fees = new Fees(LocalDate.now(), feesAmount, apartment);
            //(apartment area * x) + each tenant that uses lift&&>7 * y + each pet that uses shared spaces * z
            //separate transactions in separate methods
            transaction.commit();
        }
        return fees;
    }
    //each entity performs the queries related to it in its DAO and then the final one in FEES agreagates them

    public static void addFeesToBePaid(Apartment apartment) {
        Fees fees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            createFees(calculateMonthFees(apartment));
            transaction.commit();
        }
    }

    public static void payFees(Apartment apartment, LocalDate monthToPay) {
        Fees fees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            fees = session.createQuery("""
                            select f from Fees f
                            where f.apartment = :a and month(f.due) = :month
                                                        """, Fees.class)
                    .setParameter("a", apartment)
                    .setParameter("month", monthToPay.getMonthValue())
                    .getSingleResult();
            fees.setPaidOnDate(LocalDate.now());
            //TODO validation if it is not null
            updateFees(calculateMonthFees(apartment));
            transaction.commit();
        }
    }


}
