package dao;

import configuration.SessionFactoryUtil;
import dto.*;
import entity.Building;
import entity.Company;
import entity.Employee;
import org.hibernate.Transaction;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.List;

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


    /*public static List<Company> companiesFindByInitialCapitalBetween(double bottom, double top) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);

            cr.select(root).where(cb.between(root.get("initialCapital"), bottom, top));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    } //REFERENCE MATERIAL
*/
    /*public static List<Employee> companyEmployeeWithLeastBuildings(long id) {
        List<Employee> employees; //explanation - what I am getting is (employeeId, buildings_count) which IS NOT EMPLOYEE.
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            System.out.println(session.createQuery(
                            "select e.id, COUNT(b.id) as building_count from Employee e " +
                                    "left join Building b on e = b.employee " +
                                    "where e.company = :id " +
                                    "group by e.id " +
                                    "order by building_count ASC ",// +
//                                    "limit 1",
                            Employee.class)
                    .setParameter("id", id)
                    .setMaxResults(5)
                    .getResultList());
            transaction.commit();
            //System.out.println("employees: " + employees);
    return new ArrayList<Employee>();
        }//TODO LAST I need to find the buildings associated with each employee projection
//THIS is DTO way with jdbc or something
    } //TODO the problem is that entity has no COUNT column... probably*/
    //with dto
    /*public static EmployeeDTOIDOnlyBuildingsCount companyEmployeeWithLeastBuildings(long id) { //old and doesn't work
        EmployeeDTOIDOnlyBuildingsCount employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.createQuery(
                            "select new dto.EmployeeDTOIDOnlyBuildingsCount(e.id, COUNT(b.id))  from Employee e " +
                                    "left join fetch Building b on e = b.employee " +
//                                    "join e.company c " +
                                    "where e.company = :id " +
                                    "group by e.id " +
                                    "order by COUNT(b.id) ASC ", //+
//                                    "LIMIT 1", //LIMIT isn't supported by Hibernate
                            EmployeeDTOIDOnlyBuildingsCount.class)
                    .setParameter("id", id)
                    .setMaxResults(1)
                    .getSingleResult();
            transaction.commit();
    return employee;
        }//TODO LAST I need to find the buildings associated with each employee projection
//THIS is DTO way with jpql or something
    }*/
    /*public static Employee companyEmployeeWithLeastBuildings(long id) {
        List<EmployeeDTO> employees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery(
                            "select new EmployeeDTO(e.id, e.name) from Employee e" +
                                    " join e.company c " +
                                    "where c.id = :id",
                            EmployeeDTO.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }//TODO LAST I need to find the buildings associated with each employee projection

//THIS is DTO way with jdbc or something
        }
    }*/
    //What do I have to get in order to have the employee with the least amount of buildings?
    /*I need to know:
     the company ID
     then I need to find the employees
        I need to find the buildings for every employee
        get the buildings count
     find which employee has the least buildings -> return employee -> assign building


     If there are more than one building to be assigned update the count from the last step and iterate through the buildings

     */
        /*public static Employee companyEmployeeWithLeastBuildings(long id) {
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
                Root<Employee> root = cq.from(Employee.class);

                cq.select(root).where()


            }
        }*/ //How does one even build these....

    public static List<EmployeeDTOIDOnlyBuildingsCount> getCompanyEmployeesDTOIDOnlyBuildingsCount(long id) {
        List<EmployeeDTOIDOnlyBuildingsCount> employees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery(
                            "select new dto.EmployeeDTOIDOnlyBuildingsCount(e.id, COUNT(b.id)) from Employee e" +
                                    " left join fetch Building b on b.employee = e" +
                                    " join e.company c" +
                                    " where c.id = :id" +
                                    " group by e.id" +
                                    " order by COUNT(b.id) asc",
                            EmployeeDTOIDOnlyBuildingsCount.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }

    public static EmployeeDTOIDOnlyBuildingsCount getCompanyEmployeeDTOIDOnlyBuildingsCountWithLeastBuildings(long id) {
        EmployeeDTOIDOnlyBuildingsCount employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.createQuery(
                            "select new dto.EmployeeDTOIDOnlyBuildingsCount(e.id, COUNT(b.id)) from Employee e" +
                                    " left join Building b on b.employee = e" +
                                    " join e.company c" +
                                    " where c.id = :id" +
                                    " group by e.id" +
                                    " order by COUNT(b.id) asc",
                            EmployeeDTOIDOnlyBuildingsCount.class)
                    .setParameter("id", id)
                    .setMaxResults(1)
                    .getSingleResult();
            transaction.commit();
        }
        return employee;
    }

    public static void contractNewBuilding(Company company, Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            //todo what employee has the least buildings? Company -> employees.buildings.count
//            Employee employee = session.find(Employee.class, 8L); //example

            EmployeeDTOIDOnlyBuildingsCount employee = getCompanyEmployeeDTOIDOnlyBuildingsCountWithLeastBuildings(company.getId());
            System.out.println(employee);
//            employee.getBuildings().add(building); //no need to update the collection for the employee since it's used only here
//            building.setEmployee(session.find(Employee.class,employee.getId())); //it's already gotten right?
//            building.setEmployee(employee); //it is DTO
            building.setEmployee(EmployeeDAO.getEmployeeById(employee.getId()));
//            session.saveOrUpdate(employee);
            session.saveOrUpdate(building);
            transaction.commit();
//            System.out.println(employee);
        }
    }
    //TODO a method to contract new buildings and add them to the least busy employee


    //test
    public static List<Employee> getCompanyEmployees(long id) {
        List<Employee> employees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery(
                            "select e from Employee e" +
                                    " join e.company c" +
                                    " where c.id = :id",
                            Employee.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }


//filter and sort the data vvvv

    public static List<EmployeeDTOIDAndNameBuildingsCount> getCompanyEmployeesSortedByName(long id) {
        List<EmployeeDTOIDAndNameBuildingsCount> employees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery(""" 
                                    select new dto.EmployeeDTOIDAndNameBuildingsCount(e.name, COUNT(b.id)) 
                                    from Employee e
                                    left join fetch Building b on b.employee = e
                                    join e.company c
                                    where c.id = :id
                                    group by e.name
                                    order by e.name asc
                                                                        """,
                            EmployeeDTOIDAndNameBuildingsCount.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }

    public static List<EmployeeDTOIDAndNameBuildingsCount> getCompanyEmployeesSortedByBuildingsCount(long id) {
        List<EmployeeDTOIDAndNameBuildingsCount> employees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery(""" 
                                    select new dto.EmployeeDTOIDAndNameBuildingsCount(e.name, COUNT(b.id)) 
                                    from Employee e
                                    left join fetch Building b on b.employee = e
                                    join e.company c
                                    where c.id = :id
                                    group by e.name
                                    order by COUNT(b.id) desc, e.name 
                                                                        """,
                            EmployeeDTOIDAndNameBuildingsCount.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }


    public static List<CompanyIncomeDTO> getCompaniesSortedByIncome() {
        List<CompanyIncomeDTO> companies;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companies = session.createQuery("""
                            select new dto.CompanyIncomeDTO(c.id,c.name,COALESCE(SUM(f.amount), 0)) from Company c
                            left join c.employees e
                            left join e.buildings b
                            left join b.apartments a
                            left join a.fees f
                                                        
                            group by c.id, c.name
                            order by SUM(f.amount) desc

                            """, CompanyIncomeDTO.class)
                    .getResultList();
            transaction.commit();
        }
            return companies;
    }

    public static List<EmployeeDTOIDAndNameBuildingsCount> getCompanyEmployeesBuildingCount(Company company){
        List<EmployeeDTOIDAndNameBuildingsCount> employeesBuildingCounts;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employeesBuildingCounts = session.createQuery("""
                            select new dto.EmployeeDTOIDAndNameBuildingsCount(e.id,e.name,COUNT(b.id)) from Company c
                            join c.employees e
                            join e.buildings b
                            where c = :c
                            group by e.id
                            """, EmployeeDTOIDAndNameBuildingsCount.class)
                    .setParameter("c", company)
                    .getResultList();

            transaction.commit();
        }
        return employeesBuildingCounts;
    }
//

    public static List<EmployeeDTOIDAndNameBuildingsCount> getCompanyBuildingCount(Company company){
        List<EmployeeDTOIDAndNameBuildingsCount> employeesBuildingCounts;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employeesBuildingCounts = session.createQuery("""
                            select new dto.EmployeeDTOIDAndNameBuildingsCount(e.id,e.name,COUNT(b.id)) from Company c
                            join c.employees e
                            join e.buildings b
                            where c = :c
                            group by e.id
                            """, EmployeeDTOIDAndNameBuildingsCount.class)
                    .setParameter("c", company)
                    .getResultList();

            transaction.commit();
        }
        return employeesBuildingCounts;
    }



    public static List<ApartmentFeesDTO> getCompanyFeesToPay(Company company) {
        List<ApartmentFeesDTO> apartmentDTOs;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartmentDTOs = session.createQuery("""
                            select new dto.ApartmentFeesDTO(b.id,a.apartmentNumber,f.amount) from Company c
                            join c.employees e
                            join e.buildings b
                            join b.apartments a
                            join a.fees f
                            where c = :c
                            """, ApartmentFeesDTO.class)
                    .setParameter("c", company)
                    .getResultList();
            transaction.commit();
        }
        return apartmentDTOs;
    }


    public static double getTotalSumCompanyFeesToPay(Company company) {
        TotalFeesDTO totalFeesDTO;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            totalFeesDTO = session.createQuery("""
                            select new dto.TotalFeesDTO(SUM(f.amount)) from Company c
                            join c.employees e
                            join e.buildings b
                            join b.apartments a
                            join a.fees f
                            where c = :c
                            group by c.id
                            """, TotalFeesDTO.class)
                    .setParameter("c", company)
                    .getSingleResult();
            transaction.commit();
        } catch(NoResultException e){
            System.out.println("No entity found for query \"getTotalSumCompanyFeesToPay\"");
            return 0;
        }
        return totalFeesDTO.getTotalFees();
    }

    public static List<ApartmentFeesDTO> getCompanyFeesPaid(Company company) {
        List<ApartmentFeesDTO> apartmentDTOs;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartmentDTOs = session.createQuery("""
                            select new dto.ApartmentFeesDTO(b.id,a.apartmentNumber,f.amount) from Company c
                            join c.employees e
                            join e.buildings b
                            join b.apartments a
                            join a.fees f
                            where c = :c AND f.paidOnDate is not null
                            """, ApartmentFeesDTO.class)
                    .setParameter("c", company)
                    .getResultList();
            transaction.commit();
        }
        return apartmentDTOs;
    }


    public static double getTotalSumCompanyFeesPaid(Company company) {
        TotalFeesDTO totalFeesDTO;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            totalFeesDTO = session.createQuery("""
                            select new dto.TotalFeesDTO(SUM(f.amount)) from Company c
                            join c.employees e
                            join e.buildings b
                            join b.apartments a
                            join a.fees f
                            where c = :c AND f.paidOnDate is not null
                            group by c.id
                            """, TotalFeesDTO.class)
                    .setParameter("c", company)
                    .getSingleResult();
            transaction.commit();
        } catch(NoResultException e){
            System.out.println("No entity found for query \"getTotalSumCompanyFeesPaid\"");
            return 0;
        }
        return totalFeesDTO.getTotalFees();
    }


}
