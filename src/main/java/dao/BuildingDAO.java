package dao;

import configuration.SessionFactoryUtil;
import dto.ApartmentTenantNameAgeDTO;
import entity.Building;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BuildingDAO {

    public static void createBuilding(Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(building);
            transaction.commit();
        }
    }

    public static void updateBuilding(Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(building);
            transaction.commit();
        }
    }

    public static void deleteBuilding(Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(building);
            transaction.commit();
        }
    }

    public static Building getBuildingById(long id) {
        Building building;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            building = session.get(Building.class, id); //find always searches in the db, get can return a session-associated entity instead
            transaction.commit();
        }
        return building;
    }


//filter and sort the data vvvv



    public static List<ApartmentTenantNameAgeDTO> getBuildingResidentsSortedByName(Building building) {
        List<ApartmentTenantNameAgeDTO> tenantsDTO;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            tenantsDTO = session.createQuery("""
                            select new dto.ApartmentTenantNameAgeDTO(a.apartmentNumber,t.id, t.name, t.birthdate) from Tenant t
                            join t.apartment a
                            join a.building b on b = :b
                                                    
                            order by t.name
                            """, ApartmentTenantNameAgeDTO.class)
                    .setParameter("b", building)
                    .getResultList();
            transaction.commit();
        }
        return tenantsDTO;
    }

    public static List<ApartmentTenantNameAgeDTO> getBuildingResidentsSortedByAge(Building building) {
        List<ApartmentTenantNameAgeDTO> tenantsDTO;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            tenantsDTO = session.createQuery("""
                            select new dto.ApartmentTenantNameAgeDTO(a.apartmentNumber,t.id, t.name, t.birthdate) from Tenant t
                            join t.apartment a
                            join a.building b on b = :b
                                                    
                            order by t.birthdate
                            """, ApartmentTenantNameAgeDTO.class)
                    .setParameter("b", building)
                    .getResultList();
            transaction.commit();
        }
        return tenantsDTO;
    }

}
