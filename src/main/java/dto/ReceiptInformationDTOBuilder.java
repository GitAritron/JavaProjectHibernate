package dto;

public class ReceiptInformationDTOBuilder {

    private final long companyID;
    private final String companyName;
    private final long employeeID;
    private final String employeeName;

    private final long buildingID;
    private final int numOfFloors;
    private final int numOfApartments;
    private final double totalArea;

    private final int apartmentNumber;
    private final int floor;

    private final double area;
    private final double amount;

    public ReceiptInformationDTOBuilder(long companyID, String companyName, long employeeID, String employeeName, long buildingID, int numOfFloors, int numOfApartments, double totalArea, int apartmentNumber, int floor, double area, double amount) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.buildingID = buildingID;
        this.numOfFloors = numOfFloors;
        this.numOfApartments = numOfApartments;
        this.totalArea = totalArea;
        this.apartmentNumber = apartmentNumber;
        this.floor = floor;
        this.area = area;
        this.amount = amount;
    }

    public long getCompanyID() {
        return companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }


    public long getBuildingID() {
        return buildingID;
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

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public int getFloor() {
        return floor;
    }

    public double getArea() {
        return area;
    }

    public double getAmount() {
        return amount;
    }


    public CompanyIDNameDTO getCompanyIDNameDTO(){
        return new CompanyIDNameDTO(getCompanyID(),getCompanyName());
}

    public EmployeeIDNameDTO getEmployeeIDNameDTO(){
        return new EmployeeIDNameDTO(getEmployeeID(), getEmployeeName());
    }

    public BuildingNoFeesDTO getBuildingNoFeesDTO(){
        return new BuildingNoFeesDTO(getBuildingID(), getNumOfFloors(), getNumOfApartments(), getTotalArea());
    }
    public ApartmentDTO getApartmentDTO(){
        return  new ApartmentDTO(getApartmentNumber(),getFloor(),getArea());
    }

    @Override
    public String toString() {
        return "ReceiptInformationDTOBuilder{" +
                "companyID='" + companyID + '\'' +
                ", companyName='" + companyName + '\'' +
                ", employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", buildingID=" + buildingID +
                ", numOfFloors=" + numOfFloors +
                ", numOfApartments=" + numOfApartments +
                ", totalArea=" + totalArea +
                ", apartmentNumber=" + apartmentNumber +
                ", floor=" + floor +
                ", area=" + area +
                ", amount=" + amount +
                '}';
    }
}
