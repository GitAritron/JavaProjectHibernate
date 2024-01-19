package dao;

import configuration.SessionFactoryUtil;
import dto.BuildingFeesApartmentAreaDTO;
import entity.Apartment;
import entity.Employee;
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



    public static BuildingFeesApartmentAreaDTO getBuildingFeesAndApartmentArea(Apartment apartment) {
        BuildingFeesApartmentAreaDTO DTO;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            DTO = session.createQuery("""
                                    select new dto.BuildingFeesApartmentAreaDTO(b.liftFee,b.petFee,b.squareMeterFee,a.area)
                                    from Apartment a
                                    join a.building b
                                    where a= :a
                                    """,
                            BuildingFeesApartmentAreaDTO.class)
                    .setParameter("a", apartment)
                    .getSingleResult();
            transaction.commit();
        }
        return DTO;
    }
    public static BuildingFeesApartmentAreaDTO getBuildingFeesAndApartmentArea(int apNum, long buildingID) {
        BuildingFeesApartmentAreaDTO DTO;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            DTO = session.createQuery("""
                                    select new dto.BuildingFeesApartmentAreaDTO(b.liftFee,b.petFee,b.squareMeterFee,a.area)
                                    from Apartment a
                                    join a.building b
                                    where a.apartmentNumber= :apNum and a.building.id = :buildingId
                                    """,
                            BuildingFeesApartmentAreaDTO.class)
                    .setParameter("apNum", apNum)
                    .setParameter("buildingId", buildingID)
                    .getSingleResult();
            transaction.commit();
        }
        return DTO;
    }
}
