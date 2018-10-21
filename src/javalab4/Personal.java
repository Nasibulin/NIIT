package javalab4;

public class Personal extends Employee implements WorkTime {
    public Personal(Integer id, String name, String position, Double hourlyRate) {
        super(id, name, position);
        this.hourlyRate = hourlyRate;
    }

    private double hourlyRate;

    public double getBasicSalary(double actualHours) {
        return actualHours * hourlyRate;
    }

}