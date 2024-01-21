package dao;

import configuration.SessionFactoryUtil;
import dto.ApartmentDTO;
import dto.ApartmentTenantNameAgeDTO;
import dto.BuildingApartmentsCountDTO;
import entity.Building;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.Select;

import javax.persistence.NoResultException;
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


    /*





     */

    public static int getBuildingApartmentsCount(Building building) {
        BuildingApartmentsCountDTO apartmentsCountDTO;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartmentsCountDTO = session.createQuery("""
                            select new dto.BuildingApartmentsCountDTO(COUNT(a.apartmentNumber)) from Building b
                            join b.apartments a
                            where b = :b
                            group by b.id
                            """, BuildingApartmentsCountDTO.class)
                    .setParameter("b", building)
                    .getSingleResult();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("No entity found for query \"getBuildingApartmentsCount\"");
            return 0;
        }
        return (int) apartmentsCountDTO.getApartmentsCount();
    }
//

    public static List<ApartmentDTO> getBuildingApartments(Building building) {
        List<ApartmentDTO> apartmentDTOs;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartmentDTOs = session.createQuery("""
                            select new dto.ApartmentDTO(a.apartmentNumber,a.floor,a.area) from Building b
                            join b.apartments a
                            where b = :b
                            """, ApartmentDTO.class)
                    .setParameter("b", building)
                    .getResultList();
            transaction.commit();
        }
        return apartmentDTOs;
    }


}

