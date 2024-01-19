import configuration.SessionFactoryUtil;
import dao.BuildingDAO;
import dao.CompanyDAO;
import dao.EmployeeDAO;
import entity.Building;
import entity.Company;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Building building = BuildingDAO.getBuildingById(7L);
        Company company = CompanyDAO.getCompanyById(1L);
        System.out.println(company);
        System.out.println(building);
//        CompanyDAO.contractNewBuilding(company, building);
        System.out.println(building);

//        Employee employee = EmployeeDAO.getEmployeeById(5L);

//        System.out.println(EmployeeDAO.getNumberOfBuildingsOfEmployee(5L));
//        System.out.println(CompanyDAO.getCompanyEmployeeDTOIDOnlyBuildingsCountWithLeastBuildings(1L));



/*


        //populate DB:
        Company company1 = new Company("Company1");
        Company company2 = new Company("Company2");
        Company company3 = new Company("Company3");

        Building building1 = new Building(1,1,100);
        Building building2 = new Building(1,1,100);
        Building building3 = new Building(1,1,100);
        Building building4 = new Building(1,1,100);
        Building building5 = new Building(1,1,100);
        Building building6 = new Building(1,1,100);
        Building building7 = new Building(1,1,100);

        Employee employee1 = new Employee("Employee1", company1);
        Employee employee2 = new Employee("Employee2", company1);
        Employee employee3 = new Employee("Employee3", company2);
        Employee employee4 = new Employee("Employee4", company2);
        Employee employee5 = new Employee("Employee5", company3);
*/


    }


//TODO need Data Access Objects (DAOs) and DTOs for read-only operations
}


//Hibernate.isInitialized(orderDetailSet); is used to test if a "LazyLoad" object is loaded