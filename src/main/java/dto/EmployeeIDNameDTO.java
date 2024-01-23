package dto;

import entity.Employee;

public class EmployeeIDNameDTO {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EmployeeIDNameDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
    }
    public EmployeeIDNameDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeIDNameDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
