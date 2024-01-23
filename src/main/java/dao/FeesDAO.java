package dao;

import configuration.SessionFactoryUtil;
import dto.BuildingFeesApartmentAreaDTO;
import dto.ReceiptInformationDTO;
import dto.ReceiptInformationDTOBuilder;
import entity.Apartment;
import entity.Fees;
import net.bytebuddy.asm.Advice;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.PrintPaidFeesToFile;

import java.io.IOException;
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
            session.update(fees);
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

    public static void payFees(Apartment apartment, LocalDate monthToPay) throws IOException {
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
            LocalDate now = LocalDate.now();
            fees.setPaidOnDate(now);
            //TODO validation if it is not null
            PrintPaidFeesToFile.printReceiptForPayment(getReceiptInformation(apartment, monthToPay),now);
            updateFees(fees);
            transaction.commit();
        }
    }

    public static ReceiptInformationDTO getReceiptInformation(Apartment apartment, LocalDate monthToPay) {
        ReceiptInformationDTOBuilder ReceiptInformationDTOBuilder;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
                            //select new dto.ReceiptInformationDTO(c(c.id,c.name),e(e.id,e.name),b(b.id,b.numOfFloors,b.numOfApartments,b.totalArea),a(a.apartmentNumber,a.floor,a.area),f.amount) from Company c
            ReceiptInformationDTOBuilder = session.createQuery("""
                            select new dto.ReceiptInformationDTOBuilder(c.id,c.name,e.id,e.name,b.id,b.numOfFloors,b.numOfApartments,b.totalArea,a.apartmentNumber,a.floor,a.area,f.amount) from Company c
                            join c.employees e
                            join e.buildings b
                            join b.apartments a
                            join a.fees f
                            where f.apartment = :a and month(f.due) = :month
                                                        """, ReceiptInformationDTOBuilder.class)
                    .setParameter("a", apartment)
                    .setParameter("month", monthToPay.getMonthValue())
                    .getSingleResult();

            transaction.commit();
        }
        return new ReceiptInformationDTO(ReceiptInformationDTOBuilder);
    }


}
