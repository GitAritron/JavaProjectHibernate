package entity;


import javax.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name", length = 90)
    private String name;

    @Column(name = "species", length = 90)
    private String species;

    @Column(name = "usesSharedSpaces", nullable = false)
    private boolean usesSharedSpaces;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumns({
            @JoinColumn(name = "FK_building_id", referencedColumnName = "FK_building_id", nullable = false)//,
            @JoinColumn(name = "FK_apartmentNumber", referencedColumnName = "apartmentNumber", nullable = false)
//    })
    private Apartment apartment;

    public Pet() {
    }

    public Pet(String name, String species, boolean usesSharedSpaces, Apartment apartment) {
        this.name = name;
        this.species = species;
        this.usesSharedSpaces = usesSharedSpaces;
        this.apartment = apartment;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", usesSharedSpaces=" + usesSharedSpaces +
                ", apartment=" + apartment +
                '}';
    }
    // Getters and setters
}