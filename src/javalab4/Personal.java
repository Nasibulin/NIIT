package javalab4;

public class Personal extends Employee implements WorkTime {
    private double hourlyRate;

    public Personal(Integer id, String name, String position, Double hourlyRate) {
        super(id, name, position);
        this.hourlyRate = hourlyRate;
    }

    public Personal(Integer id, String name, String position) {
        super(id, name, position);
    }

    public double getBasicSalary(double actualHours) {
        return actualHours * hourlyRate;
    }

}