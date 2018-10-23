package javalab4;

public class Engineer extends Employee implements ProjectShare, WorkTime {

    private double regularHourlyRate;
    private double actualHours;
    private double basicSalary;
    private double projectBonus;
    private double overtimeSalary;
    private double overtimeHours;
    private double overtimeMultiplier;
    private double projectPercent;
    private Project project;


    public Engineer(Integer id, String name, String position, Double regularHourlyRate, Double overtimeMultiplier,
                    Double projectPercent) {
        super(id, name, position, regularHourlyRate);
        this.regularHourlyRate = regularHourlyRate;
        this.overtimeMultiplier = overtimeMultiplier;
        this.projectPercent = projectPercent;
    }

    public Engineer(Integer id, String name, String position, Double regularHourlyRate, Double actualHours) {
        super(id, name, position, regularHourlyRate, actualHours);
        this.actualHours=actualHours;
        this.regularHourlyRate=regularHourlyRate;
    }

    public double getProjectBonus() {

        return project.getBudget() * projectPercent;

    }

    public double getBasicSalary() {
        basicSalary = actualHours * regularHourlyRate;
        return basicSalary;
    }

    public double getOvertimeSalary(double overtimeHours) {

        overtimeSalary = overtimeHours * overtimeMultiplier * regularHourlyRate;
        return overtimeSalary;
    }

    public double getOvertimeSalary() {
        return overtimeSalary;
    }

    public double getSalary(double actualHours, double overtimeHours, Project project) {
        return getBasicSalary() + getOvertimeSalary(overtimeHours) + getProjectBonus();
    }

    public double getSalary(double actualHours, double overtimeHours) {
        return getBasicSalary() + getOvertimeSalary(overtimeHours);
    }

    public double getSalary() {
        return getBasicSalary()+getOvertimeSalary();
    }

    public void setProject(Project project) {
        this.project = project;
    }

}