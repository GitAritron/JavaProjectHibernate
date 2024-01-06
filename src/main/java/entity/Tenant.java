package entity;


import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtenant")
    private long id;

    @Column(name = "name", nullable = false, length = 90)
    private String name;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "usesLift", nullable = false)
    private boolean usesLift;

    @ManyToOne
//    @JoinColumns({
            @JoinColumn(name = "FK_building_idbuilding", referencedColumnName = "FK_idbuilding", nullable = false)//,
            @JoinColumn(name = "FK_apartmentNumber", referencedColumnName = "apartmentNumber", nullable = false)
//    })
    private Apartment apartment;

    public Tenant() {
    }

    public Tenant(String name, LocalDate birthdate, boolean usesLift, Apartment apartment) {
        this.name = name;
        this.birthdate = birthdate;
        this.usesLift = usesLift;
        this.apartment = apartment;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setUsesLift(boolean usesLift) {
        this.usesLift = usesLift;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", usesLift=" + usesLift +
                ", apartment=" + apartment +
                '}';
    }
    // Getters and setters
}
