package dto;

public class BuildingApartmentsCountDTO {
    private long apartmentsCount;

    public BuildingApartmentsCountDTO(long apartmentsCount) {
        this.apartmentsCount = apartmentsCount;
    }

    public long getApartmentsCount() {
        return apartmentsCount;
    }

    public void setApartmentsCount(long apartmentsCount) {
        this.apartmentsCount = apartmentsCount;
    }

    @Override
    public String toString() {
        return "BuildingApartmentsCountDTO{" +
                "apartmentsCount=" + apartmentsCount +
                '}';
    }
}
