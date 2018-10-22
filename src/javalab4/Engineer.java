package javalab4;

public class Engineer extends Employee implements ProjectShare, WorkTime {

    private double regularHourlyRate;
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

    public Engineer(Integer id, String name, String position, Double regularHourlyRate) {
        super(id, name, position, regularHourlyRate);
    }

    public double getProjectBonus() {

        return project.getBudget() * projectPercent;

    }

    public double getBasicSalary(double actualHours) {
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
        return getBasicSalary(actualHours) + getOvertimeSalary(overtimeHours) + getProjectBonus();
    }

    public double getSalary(double actualHours, double overtimeHours) {
        return getBasicSalary(actualHours) + getOvertimeSalary(overtimeHours);
    }

    public double getSalary(double actualHours) {
        return getBasicSalary(actualHours);
    }

    public void setProject(Project project) {
        this.project = project;
    }

}