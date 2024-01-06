package entity;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Fees")
public class Fees implements Serializable {
    @Id
    @Column(name = "due", nullable = false)
    private LocalDate due;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "paidOnDate", nullable = true) //null is not paid
    private LocalDate paidOnDate;

    @ManyToOne
    @Id
//    @JoinColumns({
            @JoinColumn(name = "FK_building_idbuilding", referencedColumnName = "FK_idbuilding", nullable = false)//,
            @JoinColumn(name = "FK_apartmentNumber", referencedColumnName = "apartmentNumber", nullable = false)//
//    })
    private Apartment apartment;

    public Fees() {
    }

    public Fees(LocalDate due, double amount, Apartment apartment) {
        this.due = due;
        this.amount = amount;
        this.apartment = apartment;
    }



    public void setPaidOnDate(LocalDate paidOnDate) {
        this.paidOnDate = paidOnDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fees fees = (Fees) o;
        return due.equals(fees.due) && apartment.equals(fees.apartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(due, apartment);
    }

    @Override
    public String toString() {
        return "Fees{" +
                "due=" + due +
                ", amount=" + amount +
                ", paidOnDate=" + paidOnDate +
                ", apartment=" + apartment +
                '}';
    }

    // Getters and setters
}