package entity;


import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", updatable = false, nullable = false)
    public long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

/*    @Column(name = "BULSTAT", nullable = false, length = 45)
    private String bulstat;*/
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private final Set<Employee> employees;

    public Set<Employee> getEmployees() { //it is FetchType.LAZY - when I load the query into the entity I can use it from here.
        return employees;
    }


    public Company() {
        this.employees = new HashSet<>();
    }
    public Company(String name/*, String bulstat*/) {
        this.name = name;
        /*this.bulstat = bulstat;*/
        this.employees = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", employees=" + employees +
                '}';
    }

    // Getters and setters
}
