package entity;


import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompany", updatable = false, nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

/*    @Column(name = "BULSTAT", nullable = false, length = 45)
    private String bulstat;*/

    @OneToMany(mappedBy = "company")
    private final Set<Employee> employees;

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
/*                ", bulstat='" + bulstat + '\'' +*/
                '}';
    }

// Getters and setters
}
