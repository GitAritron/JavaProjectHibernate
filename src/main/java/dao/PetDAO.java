package dao;

import configuration.SessionFactoryUtil;
import entity.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PetDAO {

    public static void createPet(Pet pet) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pet);
            transaction.commit();
        }
    }

    public static void updatePet(Pet pet) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            session.saveOrUpdate(pet);
            transaction.commit();
        }
    }

    public static void deletePet(Pet pet) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(pet);
            transaction.commit();
        }
    }

    public static Pet getPetById(long id) {
        Pet pet;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            pet = session.get(Pet.class, id); //find always searches in the db, get can return a session-associated entity instead
            transaction.commit();
        }
        return pet;
    }
}
