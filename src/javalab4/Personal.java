package javalab4;

public class Personal extends Employee implements WorkTime {
    public Personal(int id, String name, String position, double hourlyRate) {
        super(id, name, position);
        this.hourlyRate = hourlyRate;
    }

    private double hourlyRate;

    public double getBasicSalary(double actualHours) {
        return actualHours * hourlyRate;
    }

}