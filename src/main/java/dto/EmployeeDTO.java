package dto;

import entity.Company;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDTO {

    private long id;

    private String name;

    private Company company;

    private  Set<BuildingDTOIDOnly> buildings;


    public EmployeeDTO() {

    }

    public EmployeeDTO(long id, String name) {
        this.id = id;
        this.name = name;

    }

    public EmployeeDTO(long id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BuildingDTOIDOnly> getBuildings() {
        return buildings;
    }


    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyName=" + (company!=null?company.getName():"null") +
                ", buildings=" + buildings +
                '}';
    }

    // Getters and setters
}
