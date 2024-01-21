package dto;

public class BuildingTenantsCountDTO {

    private long tenantsCount;

    public BuildingTenantsCountDTO(long tenantsCount) {
        this.tenantsCount = tenantsCount;
    }

    public long getTenantsCount() {
        return tenantsCount;
    }

    @Override
    public String toString() {
        return "BuildingTenantsCountDTO{" +
                "tenantsCount=" + tenantsCount +
                '}';
    }
}
