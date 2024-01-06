package entity;


import javax.persistence.*;

import javax.persistence.Entity;
import java.util.Set;

@Entity
@Table(name = "apartmentOwner")
public class ApartmentOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idapartmentOwner")
    private long id;

    @Column(name = "name", nullable = false, length = 90)
    private String name;

    @OneToMany(mappedBy = "apartmentOwner")
    private Set<Apartment> apartments;

    // Getters and setters


    public ApartmentOwner() {
    }
    public ApartmentOwner(String name) {
        this.name = name;
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
                '}';
    }
}

//TODO I have to add some DTOs and other stuff