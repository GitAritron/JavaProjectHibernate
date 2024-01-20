package entity;

//TODO write operations - use entity projection (setter) - Hibernate will handle the persistence
//TODO read operations - use DTOs - much faster, no need to use the entity since there is no change
//TODO use FetchType.LAZY - 3x the performance (don't forget to use JOIN FETCH to initialize the Lazy ones)

import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "apartment")
public class Apartment implements Serializable {

    @ManyToOne
    @Id
    @JoinColumn(name = "FK_building_id", referencedColumnName = "building_id", updatable = false, nullable = false)
    private Building building;
    @Id
    @Column(name = "apartmentNumber", updatable = false, nullable = false)
    private int apartmentNumber;

    @Column(name = "floor", nullable = false)
    private int floor;

    @Column(name = "area", nullable = false)
    private double area;

    @ManyToOne
    @JoinColumn(name = "FK_apartmentOwner_id", referencedColumnName = "apartmentOwner_id", nullable = true)
    private ApartmentOwner apartmentOwner;

    @OneToMany(mappedBy = "apartment")
    private final Set<Tenant> tenants;
    @OneToMany(mappedBy = "apartment")
    private final Set<Pet> pets;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "apartment")
    private final Set<Fees> fees;

    // Getters and setters


    public Apartment() {
        this.tenants = new HashSet<>();
        this.pets = new HashSet<>();
        this.fees = new HashSet<>();
    }


    public Apartment(Building building, int apartmentNumber, int floor, double area) {
        this.building = building;
        this.apartmentNumber = apartmentNumber;
        this.floor = floor;
        this.area = area;
        this.tenants = new HashSet<>();
        this.pets = new HashSet<>();
        this.fees = new HashSet<>();
    }


    public Apartment(Building building, int apartmentNumber, int floor, double area, ApartmentOwner apartmentOwner) {
        this.building = building;
        this.apartmentNumber = apartmentNumber;
        this.floor = floor;
        this.area = area;
        this.apartmentOwner = apartmentOwner;
        this.tenants = new HashSet<>();
        this.pets = new HashSet<>();
        this.fees = new HashSet<>();
    }

    public Building getBuilding() {
        return building;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getArea() {
        return area;
    }
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return apartmentNumber == apartment.apartmentNumber && building.equals(apartment.building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, apartmentNumber);
    }*/

    /*
    https://jpa-buddy.com/blog/hopefully-the-final-article-about-equals-and-hashcode-for-jpa-entities-with-db-generated-ids/
    */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Apartment apartment = (Apartment) o;
        return getBuilding() != null && getApartmentNumber() != 0 && Objects.equals(getBuilding(), apartment.getBuilding()) && Objects.equals(getApartmentNumber(), apartment.getApartmentNumber());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "building=" + building +
                ", apartmentNumber=" + apartmentNumber +
                ", floor=" + floor +
                ", area=" + area +
                ", apartmentOwner=" + apartmentOwner +
                ", tenants=" + tenants +
                ", pets=" + pets +
                ", fees=" + fees +
                '}';
    }
}