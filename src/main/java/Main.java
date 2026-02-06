import configuration.SessionFactoryUtil;
import dao.*;
import dto.ApartmentDTO;
import dto.EmployeeDTOIDAndNameBuildingsCount;
import entity.Apartment;
import entity.Building;
import entity.Company;
import entity.Employee;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world!");
//        Building building = BuildingDAO.getBuildingById(7L);
//        Company company = CompanyDAO.getCompanyById(1L);
//        System.out.println(company);
//        System.out.println(building);
//        CompanyDAO.contractNewBuilding(company, building);
//        System.out.println(building);
//        Apartment apartment = new Apartment(BuildingDAO.getBuildingById(7L),1,1,10000);
//        Employee employee = EmployeeDAO.getEmployeeById(5L);

//        System.out.println(EmployeeDAO.getNumberOfBuildingsOfEmployee(5L));
//        System.out.println(CompanyDAO.getCompanyEmployeeDTOIDOnlyBuildingsCountWithLeastBuildings(1L));

//        System.out.println(TenantDAO.getApartmentTenantsAbove7UseLiftDTO(apartment));
//        System.out.println(PetDAO.getApartmentPets(apartment));
//        System.out.println(ApartmentDAO.getBuildingFeesAndApartmentArea(apartment));
//        System.out.println(ApartmentDAO.getBuildingFeesAndApartmentArea(1,1L));
//        System.out.println(FeesDAO.calculateMonthFees(apartment));
//        FeesDAO.addFeesToBePaid(apartment);
//        FeesDAO.payFees(apartment, LocalDate.now());


//        System.out.println(CompanyDAO.getCompanyEmployeesSortedByName(1L));
//        System.out.println(CompanyDAO.getCompanyEmployeesSortedByBuildingsCount(1L));
        System.out.println(CompanyDAO.getCompaniesSortedByIncome());
//        System.out.println(BuildingDAO.getBuildingResidentsSortedByAge(BuildingDAO.getBuildingById(1L)));
//        System.out.println(BuildingDAO.getBuildingResidentsSortedByAge(BuildingDAO.getBuildingById(7L)));

//        System.out.println(BuildingDAO.getBuildingApartmentsCount(BuildingDAO.getBuildingById(1L)));
//        System.out.println(BuildingDAO.getBuildingApartmentsCount(BuildingDAO.getBuildingById(2L)));
//        System.out.println(BuildingDAO.getBuildingApartmentsCount(BuildingDAO.getBuildingById(7L)));

//        System.out.println(BuildingDAO.getBuildingApartments(BuildingDAO.getBuildingById(1L)));
//        System.out.println(BuildingDAO.getBuildingApartments(BuildingDAO.getBuildingById(2L)));
//        System.out.println(BuildingDAO.getBuildingApartments(BuildingDAO.getBuildingById(7L)));

//        System.out.println(BuildingDAO.getBuildingTenantsCount(BuildingDAO.getBuildingById(1L)));
//        System.out.println(BuildingDAO.getBuildingTenantsCount(BuildingDAO.getBuildingById(2L)));
//        System.out.println(BuildingDAO.getBuildingTenantsCount(BuildingDAO.getBuildingById(7L)));


        //DTO apartment(b.id,aNum,toPay)
        //Fees for Building
//        System.out.println(BuildingDAO.getBuildingFeesToPay(BuildingDAO.getBuildingById(1L)));
//        System.out.println(BuildingDAO.getBuildingFeesToPay(BuildingDAO.getBuildingById(2L)));
//        System.out.println(BuildingDAO.getBuildingFeesToPay(BuildingDAO.getBuildingById(7L)));

        //Total Fees for Building
//        System.out.println(BuildingDAO.getTotalSumBuildingFeesToPay(BuildingDAO.getBuildingById(1L)));
//        System.out.println(BuildingDAO.getTotalSumBuildingFeesToPay(BuildingDAO.getBuildingById(2L)));
//        System.out.println(BuildingDAO.getTotalSumBuildingFeesToPay(BuildingDAO.getBuildingById(7L)));

        //Fees for Employee
//        System.out.println(EmployeeDAO.getEmployeeFeesToPay(EmployeeDAO.getEmployeeById(4L)));
//        System.out.println(EmployeeDAO.getEmployeeFeesToPay(EmployeeDAO.getEmployeeById(5L)));
//        System.out.println(EmployeeDAO.getEmployeeFeesToPay(EmployeeDAO.getEmployeeById(7L)));


        //Total Fees for Employee
//        System.out.println(EmployeeDAO.getTotalSumEmployeeFeesToPay(EmployeeDAO.getEmployeeById(4L)));
//        System.out.println(EmployeeDAO.getTotalSumEmployeeFeesToPay(EmployeeDAO.getEmployeeById(5L)));
//        System.out.println(EmployeeDAO.getTotalSumEmployeeFeesToPay(EmployeeDAO.getEmployeeById(7L)));


        //Fees for Company
//        System.out.println(CompanyDAO.getCompanyFeesToPay(CompanyDAO.getCompanyById(1L)));
//        System.out.println(CompanyDAO.getCompanyFeesToPay(CompanyDAO.getCompanyById(2L)));
//        System.out.println(CompanyDAO.getCompanyFeesToPay(CompanyDAO.getCompanyById(3L)));


//        Total Fees for Company
//        System.out.println(CompanyDAO.getTotalSumCompanyFeesToPay(CompanyDAO.getCompanyById(2L)));
//        System.out.println(CompanyDAO.getTotalSumCompanyFeesToPay(CompanyDAO.getCompanyById(1L)));
//        System.out.println(CompanyDAO.getTotalSumCompanyFeesToPay(CompanyDAO.getCompanyById(3L)));

//        Paid fees
//        Fees for Building
//        System.out.println(BuildingDAO.getBuildingFeesPaid(BuildingDAO.getBuildingById(1L)));
//        System.out.println(BuildingDAO.getBuildingFeesPaid(BuildingDAO.getBuildingById(2L)));
//        System.out.println(BuildingDAO.getBuildingFeesPaid(BuildingDAO.getBuildingById(7L)));
//
////        Total Fees for Building
//        System.out.println(BuildingDAO.getTotalSumBuildingFeesPaid(BuildingDAO.getBuildingById(1L)));
//        System.out.println(BuildingDAO.getTotalSumBuildingFeesPaid(BuildingDAO.getBuildingById(2L)));
//        System.out.println(BuildingDAO.getTotalSumBuildingFeesPaid(BuildingDAO.getBuildingById(7L)));
//
////        Fees for Employee
//        System.out.println(EmployeeDAO.getEmployeeFeesPaid(EmployeeDAO.getEmployeeById(4L)));
//        System.out.println(EmployeeDAO.getEmployeeFeesPaid(EmployeeDAO.getEmployeeById(5L)));
//        System.out.println(EmployeeDAO.getEmployeeFeesPaid(EmployeeDAO.getEmployeeById(7L)));
//
//
////        Total Fees for Employee
//        System.out.println(EmployeeDAO.getTotalSumEmployeeFeesPaid(EmployeeDAO.getEmployeeById(4L)));
//        System.out.println(EmployeeDAO.getTotalSumEmployeeFeesPaid(EmployeeDAO.getEmployeeById(5L)));
//        System.out.println(EmployeeDAO.getTotalSumEmployeeFeesPaid(EmployeeDAO.getEmployeeById(7L)));
//
//
////        Fees for Company
//        System.out.println(CompanyDAO.getCompanyFeesPaid(CompanyDAO.getCompanyById(1L)));
//        System.out.println(CompanyDAO.getCompanyFeesPaid(CompanyDAO.getCompanyById(2L)));
//        System.out.println(CompanyDAO.getCompanyFeesPaid(CompanyDAO.getCompanyById(3L)));
//
//
////        Total Fees for Company
//        System.out.println(CompanyDAO.getTotalSumCompanyFeesPaid(CompanyDAO.getCompanyById(2L)));
//        System.out.println(CompanyDAO.getTotalSumCompanyFeesPaid(CompanyDAO.getCompanyById(1L)));
//        System.out.println(CompanyDAO.getTotalSumCompanyFeesPaid(CompanyDAO.getCompanyById(3L)));

        //Company Employee Building Count
//        System.out.println(CompanyDAO.getCompanyEmployeesBuildingCount(CompanyDAO.getCompanyById(1L)));
//        System.out.println(CompanyDAO.getCompanyEmployeesBuildingCount(CompanyDAO.getCompanyById(2L)));
//        System.out.println(CompanyDAO.getCompanyEmployeesBuildingCount(CompanyDAO.getCompanyById(3L)));

        //Employee Buildings Details
//        System.out.println(EmployeeDAO.getEmployeeBuildings(EmployeeDAO.getEmployeeById(4L)));
//        System.out.println(EmployeeDAO.getEmployeeBuildings(EmployeeDAO.getEmployeeById(5L)));
//        System.out.println(EmployeeDAO.getEmployeeBuildings(EmployeeDAO.getEmployeeById(7L)));
//        System.out.println(EmployeeDAO.getEmployeeBuildings(EmployeeDAO.getEmployeeById(8L)));



        /*Apartment apartment = new Apartment(BuildingDAO.getBuildingById(7L),1,1,10000);
        try {
            FeesDAO.payFees(apartment,LocalDate.now());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
//
//        EmployeeDAO.fireEmployee(EmployeeDAO.getEmployeeById(4L));
//        System.out.println(EmployeeDAO.getEmployeeBuildings(EmployeeDAO.getEmployeeById(4L)));



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


}


//Hibernate.isInitialized(orderDetailSet); is used to test if a "LazyLoad" object is loaded