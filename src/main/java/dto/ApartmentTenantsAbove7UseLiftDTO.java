package dto;

public class ApartmentTenantsAbove7UseLiftDTO {

    private long tenantsAbove7UseLiftDTO;

    public ApartmentTenantsAbove7UseLiftDTO(long tenantsAbove7UseLiftDTO) {
        this.tenantsAbove7UseLiftDTO = tenantsAbove7UseLiftDTO;
    }

    public long getTenants() {
        return tenantsAbove7UseLiftDTO;
    }


    @Override
    public String toString() {
        return "ApartmentTenantsAbove7UseLiftDTO{" +
                "tenantsAbove7UseLiftDTO=" + tenantsAbove7UseLiftDTO +
                '}';
    }
}
