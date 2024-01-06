package entity;

//TODO write operations - use entity projection (setter) - Hibernate will handle the persistence
//TODO read operations - use DTOs - much faster, no need to use the entity since there is no change
//TODO use FetchType.LAZY - 3x the performance (don't forget to use JOIN FETCH to initialize the Lazy ones)

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "apartment")
public class Apartment implements Serializable {

    @ManyToOne
    @Id
    @JoinColumn(name = "FK_idbuilding", referencedColumnName = "idbuilding", nullable = false)
    private Building building;
    @Id
    @Column(name = "apartmentNumber", nullable = false)
    private int apartmentNumber;

    @Column(name = "floor", nullable = false)
    private int floor;

    @Column(name = "area", nullable = false)
    private double area;

    @ManyToOne
    @JoinColumn(name = "FK_idapartmentOwner", referencedColumnName = "idapartmentOwner", nullable = true)
    private ApartmentOwner apartmentOwner;

    @OneToMany(mappedBy = "apartment")
    private Set<Tenant> tenants;
    @OneToMany(mappedBy = "apartment")
    private Set<Pet> pets;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "apartment")
    private Set<Fees> fees;

    // Getters and setters


    public Apartment() {
    }

    public Apartment(Building building, int apartmentNumber, int floor, double area, ApartmentOwner apartmentOwner) {
        this.building = building;
        this.apartmentNumber = apartmentNumber;
        this.floor = floor;
        this.area = area;
        this.apartmentOwner = apartmentOwner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return apartmentNumber == apartment.apartmentNumber && building.equals(apartment.building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, apartmentNumber);
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "building=" + building +
                ", apartmentNumber=" + apartmentNumber +
                ", floor=" + floor +
                ", area=" + area +
                ", apartmentOwner=" + apartmentOwner +
                '}';
    }
}