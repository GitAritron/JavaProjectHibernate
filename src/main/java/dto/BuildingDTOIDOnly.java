package dto;

public class BuildingDTOIDOnly {
    private long id;

    public BuildingDTOIDOnly() {
    }

    public BuildingDTOIDOnly(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "BuildingDTOIDOnly{" +
                "id=" + id +
                '}';
    }
}
