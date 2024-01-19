package entity;


import javax.persistence.*;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "apartmentOwner")
public class ApartmentOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartmentOwner_id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 90)
    private String name;

    @OneToMany(mappedBy = "apartmentOwner", fetch = FetchType.LAZY)
    private final Set<Apartment> apartments;

    // Getters and setters


    public ApartmentOwner() {
        this.apartments = new HashSet<>();
    }

    public ApartmentOwner(String name) {
        this.name = name;
        this.apartments = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ApartmentOwner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apartments=" + apartments +
                '}';
    }
}

//TODO I have to add some DTOs and other stuff