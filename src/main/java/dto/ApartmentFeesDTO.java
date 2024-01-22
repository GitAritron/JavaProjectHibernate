package dto;

public class ApartmentFeesDTO {

    private long building_id;

    private int apartmentNumber;

    private double totalFeesToPay;

    public ApartmentFeesDTO(long building_id, int apartmentNumber, double totalFeesToPay) {
        this.building_id = building_id;
        this.apartmentNumber = apartmentNumber;
        this.totalFeesToPay = totalFeesToPay;
    }

    public long getBuilding_id() {
        return building_id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getTotalFeesToPay() {
        return totalFeesToPay;
    }


    @Override
    public String toString() {
        return "ApartmentFeesDTO{" +
                "building_id=" + building_id +
                ", apartmentNumber=" + apartmentNumber +
                ", totalFeesToPay=" + totalFeesToPay +
                '}';
    }
}
