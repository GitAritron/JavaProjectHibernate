package dao;

import configuration.SessionFactoryUtil;
import entity.Building;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {

    public static void createEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    public static void updateEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    public static void deleteEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
public static void fireEmployee(Employee employee) { //this method is so that we don't delete the employee, in order not to lose data pointlessly
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            //TODO here - transfer managed buildings to other employees of the company
            employee.setCompany(null); //AND remove the FK for company (not tested)
            transaction.commit();
        }
    }

    public static Employee getEmployeeById(long id) {
        Employee employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id); //find always searches in the db, get can return a session-associated entity instead
            transaction.commit();
        }
        return employee;
    }

//    public static Employee getEmployeeWithLeastBuildings(long id) { //TODO should this be a DTO instead? :think:
//        Employee employee;
//        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            employee = session.get(Employee.class, id); //find always searches in the db, get can return a session-associated entity instead
//            transaction.commit();
//        }
//        return employee;
//    }
    //TODO This should be a DTO!! Employee + buildings fields


}
