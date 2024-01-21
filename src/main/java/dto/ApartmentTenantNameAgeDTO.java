package dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class ApartmentTenantNameAgeDTO {

    private int apartmentNumber;
    private long id;
    private String name;
    private LocalDate birthdate;

    public ApartmentTenantNameAgeDTO(int apartmentNumber, long id, String name, LocalDate birthdate) {
        this.apartmentNumber = apartmentNumber;
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public long getApartmentNumber() {
        return apartmentNumber;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return "ApartmentTenantNameAgeDTO{" +
                "apartmentNumber=" + apartmentNumber +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}

