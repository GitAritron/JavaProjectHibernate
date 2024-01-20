package dao;

import configuration.SessionFactoryUtil;
import dto.ApartmentPetsThatUseSSDTO;
import dto.ApartmentTenantsAbove7UseLiftDTO;
import entity.Apartment;
import entity.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.time.LocalDate;

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
            Transaction transaction = session.beginTransaction();
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

    public static ApartmentPetsThatUseSSDTO getApartmentPets(Apartment apartment) {
        ApartmentPetsThatUseSSDTO petsDTO = new ApartmentPetsThatUseSSDTO(0L);
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            petsDTO = session.createQuery("""
                                    select new dto.ApartmentPetsThatUseSSDTO(COUNT(p.id))
                                    from Pet p
                                    where p.apartment = :a and p.usesSharedSpaces=true
                                    group by p.apartment
                                                                        """,
                            ApartmentPetsThatUseSSDTO.class)
                    .setParameter("a", apartment)
                    .getSingleResult();
            transaction.commit();
        } catch (NoResultException e){
            System.out.println("No entity found for query \"getApartmentPets\"");
        }
        return petsDTO;
    }
}
