package javalab4;

public class Engineer extends Employee implements ProjectShare, WorkTime {

    private double projectBonus;
    private double overtimeSalary;
    private double overtimeHours;
    private double overtimeMultiplier;
    private double projectPercent;
    private Project project;


    public Engineer(Integer id, String name, String position, Double regularHourlyRate, Integer actualHours,
                    Double overtimeMultiplier,
                    Double projectPercent) {
        super(id, name, position, regularHourlyRate, actualHours);
        this.overtimeMultiplier = overtimeMultiplier;
        this.projectPercent = projectPercent;
    }

    public Engineer(Integer id, String name, String position, Double regularHourlyRate, Integer actualHours) {
        super(id, name, position, regularHourlyRate, actualHours);

    }

    public double getProjectBonus() {
        projectBonus = ((project == null) ? 0 : project.getBudget()) * projectPercent;
        return projectBonus;

    }

    @Override
    public double getBasicSalary() {
        return super.getActualHours() * super.getHourlyRate();
    }

    @Override
    public double getOvertimeSalary() {
        overtimeSalary = overtimeHours * overtimeMultiplier * super.getHourlyRate();
        return overtimeSalary;
    }

    @Override
    public double getSalary() {
        return getBasicSalary() + getOvertimeSalary() + getProjectBonus();
    }

    public void setProject(Project project) {
        this.project = project;
    }

}