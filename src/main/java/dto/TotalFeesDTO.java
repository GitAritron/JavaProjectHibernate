package dto;

public class TotalFeesDTO {

    private double totalFees;

    public TotalFeesDTO(double totalFees) {
        this.totalFees = totalFees;
    }

    public double getTotalFees() {
        return totalFees;
    }

    @Override
    public String toString() {
        return "TotalFeesDTO{" +
                "totalFees=" + totalFees +
                '}';
    }
}
