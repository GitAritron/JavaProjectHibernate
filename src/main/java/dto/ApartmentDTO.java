package dto;

public class ApartmentDTO {

    private int apartmentNumber;
    private int floor;

    private double area;


    public ApartmentDTO(int apartmentNumber, int floor, double area) {
        this.apartmentNumber = apartmentNumber;
        this.floor = floor;
        this.area = area;
    }


    @Override
    public String toString() {
        return "ApartmentDTO{" +
                "apartmentNumber=" + apartmentNumber +
                ", floor=" + floor +
                ", area=" + area +
                '}';
    }
}
