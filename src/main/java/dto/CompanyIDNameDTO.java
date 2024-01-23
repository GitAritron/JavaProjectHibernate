package dto;

import entity.Company;

public class CompanyIDNameDTO {
    private long id;
    private String name;


    public CompanyIDNameDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public CompanyIDNameDTO(Company company) {
        this.id = company.getId();
        this.name = company.getName();
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CompanyIDNameDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
