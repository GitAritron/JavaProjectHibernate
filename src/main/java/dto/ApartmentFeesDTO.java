package dto;

public class ApartmentFeesDTO {

    private long building_id;

    private int apartmentNumber;

    private double totalFees;

    public ApartmentFeesDTO(long building_id, int apartmentNumber, double totalFees) {
        this.building_id = building_id;
        this.apartmentNumber = apartmentNumber;
        this.totalFees = totalFees;
    }

    public long getBuilding_id() {
        return building_id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getTotalFees() {
        return totalFees;
    }


    @Override
    public String toString() {
        return "ApartmentFeesDTO{" +
                "building_id=" + building_id +
                ", apartmentNumber=" + apartmentNumber +
                ", totalFees=" + totalFees +
                '}';
    }
}
