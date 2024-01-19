package dto;

import javax.persistence.Column;

public class BuildingFeesApartmentAreaDTO {

    private double liftFee;
    private double petFee;
    private double squareMeterFee;

    private double apartmentArea;


    public BuildingFeesApartmentAreaDTO(double liftFee, double petFee, double squareMeterFee, double apartmentArea) {
        this.liftFee = liftFee;
        this.petFee = petFee;
        this.squareMeterFee = squareMeterFee;
        this.apartmentArea = apartmentArea;
    }

    public double getLiftFee() {
        return liftFee;
    }

    public double getPetFee() {
        return petFee;
    }

    public double getSquareMeterFee() {
        return squareMeterFee;
    }

    public double getArea() {
        return apartmentArea;
    }

    @Override
    public String toString() {
        return "BuildingFeesApartmentAreaDTO{" +
                "liftFee=" + liftFee +
                ", petFee=" + petFee +
                ", squareMeterFee=" + squareMeterFee +
                ", apartmentArea=" + apartmentArea +
                '}';
    }
}
