package dao;

import configuration.SessionFactoryUtil;
import entity.Building;
import entity.Company;
import entity.Employee;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.concurrent.ConcurrentMap;

public class CompanyDAO {

    public static void createCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }

    public static void updateCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    public static void deleteCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }

    public static Company getCompanyById(long id) {
        Company company;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(Company.class, id); //find always searches in the db, get can return a session-associated entity instead
            transaction.commit();
        }
        return company;
    }
    public static void contractNewBuilding(Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            //what employee has the least buildings?
            Employee employee = session.find(Employee.class, 7L);
            employee.getBuildings().add(building);
            session.saveOrUpdate(employee);
            building.setEmployee(employee);

            transaction.commit();
        }
    }
    //TODO a method to contract new buildings and add them to the least busy employee
}
