package dto;

public class CompanyIncomeDTO {

    private long id;
    private String name;

    private double income;

    public CompanyIncomeDTO(long id, double income) {
        this.id = id;
        this.income = income;
    }

    public CompanyIncomeDTO(long id, String name, double income) {
        this.id = id;
        this.name = name;
        this.income = income;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "CompanyIncomeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", income=" + income +
                '}';
    }
}
