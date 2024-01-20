package entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.transaction.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id", updatable = false, nullable = false)
    private long id;

    @Column(name = "numOfFloors", nullable = false)
    private int numOfFloors;

    @Column(name = "numOfApartments", nullable = false)
    private int numOfApartments;

    @Column(name = "totalArea", nullable = false)
    private double totalArea;
    @Column(name = "liftFee", nullable = false)
    private double liftFee;
    @Column(name = "petFee", nullable = false)
    private double petFee;
    @Column(name = "squareMeterFee", nullable = false)
    private double squareMeterFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_employee_id", nullable = true)
    private Employee employee;

    @OneToMany(orphanRemoval = true, mappedBy = "building", fetch = FetchType.LAZY)
    //TODO (it works like this too tho) maybe should make a query to remove them instead (like here:https://thorben-janssen.com/best-practices-many-one-one-many-associations-mappings/#think-twice-before-using-cascadetyperemove)
    private final Set<Apartment> apartments;

    // Getters and setters

    public Building() {
        this.apartments = new HashSet<>(); //TODO for all. for hibernate add hibernate.log level=trace.
    }

    public Building(int numOfFloors, int numOfApartments, double totalArea) {
        this.numOfFloors = numOfFloors;
        this.numOfApartments = numOfApartments;
        this.totalArea = totalArea;
        this.apartments = new HashSet<>();
    }

    public Building(int numOfFloors, int numOfApartments, double totalArea, double liftFee, double petFee, double squareMeterFee, Employee employee) {
        this.numOfFloors = numOfFloors;
        this.numOfApartments = numOfApartments;
        this.totalArea = totalArea;
        this.liftFee = liftFee;
        this.petFee = petFee;
        this.squareMeterFee = squareMeterFee;
        this.employee = employee;
        this.apartments = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public void setNumOfApartments(int numOfApartments) {
        this.numOfApartments = numOfApartments;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return id == building.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", numOfFloors=" + numOfFloors +
                ", numOfApartments=" + numOfApartments +
                ", totalArea=" + totalArea +
                ", employeeID=" + ((employee!=null)?employee.getId() +
                ", employeeName=" + employee.getName():"null")  +
                '}';
    }
}