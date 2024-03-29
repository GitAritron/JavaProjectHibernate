package entity;


import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 90)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_company_id", nullable = true)
    private Company company;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private final Set<Building> buildings;

    public Employee() {
        this.buildings = new HashSet<>();
    }

    public Employee(String name) {
        this.name=name;
        this.buildings = new HashSet<>();
    }
    public Employee(String name, Company company) {
        this.name = name;
        this.company = company;
        this.buildings = new HashSet<>();
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

    public Set<Building> getBuildings() {
        return buildings;
    }


    public void setCompany(Company company) {
        this.company = company;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyName=" + (company!=null?company.getName():"null") +
//                ", buildings=" + buildings +
                '}';
    }

    // Getters and setters
}
