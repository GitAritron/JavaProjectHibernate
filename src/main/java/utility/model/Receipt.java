package utility.model;

import dto.ApartmentDTO;
import dto.BuildingNoFeesDTO;
import dto.CompanyIDNameDTO;
import dto.EmployeeIDNameDTO;
import entity.Apartment;
import entity.Building;
import entity.Company;
import entity.Employee;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

public class Receipt {

    private final long id;
    private final CompanyIDNameDTO company;
    private final EmployeeIDNameDTO employee;

    private final BuildingNoFeesDTO building;
    private final ApartmentDTO apartment;
    private final double amount;

    private final LocalDate paidOn;
    private static long idcounter = 0;

    public Receipt(CompanyIDNameDTO company, EmployeeIDNameDTO employee, BuildingNoFeesDTO building, ApartmentDTO apartment, double amount, LocalDate paidOn) {
        this.id = idcounter++;
        this.company = company;
        this.employee = employee;
        this.building = building;
        this.apartment = apartment;
        this.amount = amount;
        this.paidOn = paidOn;
    }

    public static long getIdcounter() {
        return idcounter;
    }

    @Override
    public String toString() {
        return "Receipt" + idcounter + "{ " +
                "Company: " + company + " ;\n" +
                "Employee: " + employee + " ;\n" +
                "Building: " + building + " ;\n" +
                "Apartment: " + apartment + " ;\n" +
                "Amount: " + amount + " ;\n" +
                "DateOfPayment: " + paidOn + " ;\n" +
                '}';
    }
}
