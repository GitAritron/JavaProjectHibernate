package dao;

import configuration.SessionFactoryUtil;
import entity.Building;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

//TODO DTO for building.tax and apartment.area
    //and ones for the other two pairs as well - in their corresponding DAOs
    //aggregated in the final one
}
