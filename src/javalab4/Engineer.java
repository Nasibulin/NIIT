package javalab4;

public class Engineer extends Employee implements Project, WorkTime {

    private double regularHourlyRate;
    private double basicSalary;
    private double projectBonus;
    private double overtimeSalary;
    private double overtimeHours;
    private double overtimeMultiplier;
    private double projectPercent;


    public Engineer(int id, String name, String position, double regularHourlyRate, double overtimeMultiplier, double projectPercent) {
        super(id, name, position);
        this.regularHourlyRate = regularHourlyRate;
        this.overtimeMultiplier = overtimeMultiplier;
        this.projectPercent = projectPercent;
    }

    public double getProjectBonus() {
        // TODO implement here
    }

    public double getBasicSalary() {
        // TODO implement here
    }

}