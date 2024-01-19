package dto;
public class EmployeeDTOIDOnlyBuildingsCount {


    private long id;

    private long buildingCount;
    public EmployeeDTOIDOnlyBuildingsCount() {

    }
    public EmployeeDTOIDOnlyBuildingsCount(long id, long buildingCount) {
        this.id = id;
        this.buildingCount = buildingCount;
    }

    public EmployeeDTOIDOnlyBuildingsCount(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getBuildingCount() {
        return buildingCount;
    }

    @Override
    public String toString() {
        return "EmployeeDTOIDOnlyBuildingsCount{" +
                "id=" + id +
                ", buildingCount=" + buildingCount +
                '}';
    }
}
