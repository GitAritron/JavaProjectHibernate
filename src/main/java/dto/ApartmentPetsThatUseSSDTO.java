package dto;

public class ApartmentPetsThatUseSSDTO {

    private long petsThatUseSS;

    public ApartmentPetsThatUseSSDTO(long petsThatUseSS) {
        this.petsThatUseSS = petsThatUseSS;
    }

    public long getPets(){
        return this.petsThatUseSS;
    }

    @Override
    public String toString() {
        return "ApartmentPetsThatUseSSDTO{" +
                "petsThatUseSS=" + petsThatUseSS +
                '}';
    }
}
