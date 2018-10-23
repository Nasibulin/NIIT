package javalab4;

public class Personal extends Employee implements WorkTime {
    private double hourlyRate;
    private double actualHours;

    public Personal(Integer id, String name, String position, Double hourlyRate, Double actualHours) {
        super(id, name, position, hourlyRate, actualHours);
        this.hourlyRate = hourlyRate;
        this.actualHours = actualHours;
    }


    public double getBasicSalary() {
        return actualHours * hourlyRate;
    }

    public double getSalary() {
        return getBasicSalary();
    }

}