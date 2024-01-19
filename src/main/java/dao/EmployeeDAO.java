package dao;

import configuration.SessionFactoryUtil;
import dto.EmployeeDTOIDOnlyBuildingsCount;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
            employee.setCompany(null); //remove the FK for company (not tested)
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

    public static int getNumberOfBuildingsOfEmployee(long id) {
        Employee employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.createQuery(
                            /*"select e from Employee e " +
                                    "join fetch e.buildings b " +
                                    "where b.employee = :id",*/
                            "SELECT e " +
                                    "FROM Employee e " +
                                    "JOIN FETCH e.buildings b " +
                                    "WHERE e.id = :id",
                            Employee.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return employee.getBuildings().size();
    } //THIS DOESN'T WORK FROM RELATIONAL POV, BUT OOP POV!!! THAT'S WHY!


}
