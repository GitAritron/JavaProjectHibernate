package dto;

import entity.Company;
import entity.Employee;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

public class ReceiptInformationDTO {

    private final CompanyIDNameDTO companyIDNameDTO;
    private final EmployeeIDNameDTO employeeIDNameDTO;

    private final BuildingNoFeesDTO buildingNoFeesDTO;
    private final ApartmentDTO apartmentDTO;
    private final double amount;


    public ReceiptInformationDTO(ReceiptInformationDTOBuilder builder) {
        this.companyIDNameDTO = builder.getCompanyIDNameDTO();
        this.employeeIDNameDTO = builder.getEmployeeIDNameDTO();
        this.buildingNoFeesDTO = builder.getBuildingNoFeesDTO();
        this.apartmentDTO = builder.getApartmentDTO();
        this.amount = builder.getAmount();
    }

    public CompanyIDNameDTO getCompanyIDNameDTO() {
        return companyIDNameDTO;
    }

    public EmployeeIDNameDTO getEmployeeIDNameDTO() {
        return employeeIDNameDTO;
    }

    public BuildingNoFeesDTO getBuildingNoFeesDTO() {
        return buildingNoFeesDTO;
    }

    public ApartmentDTO getApartmentDTO() {
        return apartmentDTO;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ReceiptInformationDTO{" +
                "companyIDNameDTO=" + companyIDNameDTO +
                ", employeeIDNameDTO=" + employeeIDNameDTO +
                ", buildingNoFeesDTO=" + buildingNoFeesDTO +
                ", apartmentDTO=" + apartmentDTO +
                ", amount=" + amount +
                '}';
    }
}
