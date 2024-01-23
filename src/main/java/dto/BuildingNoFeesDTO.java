package dto;

public class BuildingNoFeesDTO {

    private long building_id;
    private int numOfFloors;
    private int numOfApartments;
    private double totalArea;

    public BuildingNoFeesDTO(long building_id, int numOfFloors, int numOfApartments, double totalArea) {
        this.building_id = building_id;
        this.numOfFloors = numOfFloors;
        this.numOfApartments = numOfApartments;
        this.totalArea = totalArea;
    }

    public long getBuilding_id() {
        return building_id;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }
    public int getNumOfApartments() {
        return numOfApartments;
    }

    public double getTotalArea() {
        return totalArea;
    }

    @Override
    public String toString() {
        return "BuildingNoFeesDTO{" +
                "building_id=" + building_id +
                ", numOfFloors=" + numOfFloors +
                ", numOfApartments=" + numOfApartments +
                ", totalArea=" + totalArea +
                '}';
    }
}
