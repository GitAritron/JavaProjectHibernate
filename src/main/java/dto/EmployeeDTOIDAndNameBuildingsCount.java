package dto;
public class EmployeeDTOIDAndNameBuildingsCount {


    private long id;

    private String name;
    private long buildingCount;
    public EmployeeDTOIDAndNameBuildingsCount() {

    }

    public EmployeeDTOIDAndNameBuildingsCount(long id) {
        this.id = id;
    }

    public EmployeeDTOIDAndNameBuildingsCount(String name, long buildingCount) {
        this.name = name;
        this.buildingCount = buildingCount;
    }

    public EmployeeDTOIDAndNameBuildingsCount(long id, String name, long buildingCount) {
        this.id = id;
        this.name = name;
        this.buildingCount = buildingCount;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getBuildingCount() {
        return buildingCount;
    }

    @Override
    public String toString() {
        return "EmployeeDTOIDAndNameBuildingsCount{" +
//                "id=" + id + ", " +
                "name='" + name + '\'' +
                ", buildingCount=" + buildingCount +
                '}';
    }
}
