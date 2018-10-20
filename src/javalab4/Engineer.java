package javalab4;

public class Engineer extends Employee implements ProjectShare, WorkTime {

    private double regularHourlyRate;
    private double basicSalary;
    private double projectBonus;
    private double overtimeSalary;
    private double overtimeHours;
    private double overtimeMultiplier;
    private double projectPercent;


    public Engineer(int id, String name, String position, double regularHourlyRate, double overtimeMultiplier,
                    double projectPercent) {
        super(id, name, position);
        this.regularHourlyRate = regularHourlyRate;
        this.overtimeMultiplier = overtimeMultiplier;
        this.projectPercent = projectPercent;
    }

    public double getProjectBonus() {
        // TODO implement here
    return 0;}

    public double getBasicSalary(double actualHours) {

        basicSalary=actualHours/getBusinessHours()*regularHourlyRate;

    return basicSalary;
    }

    public double getOvertimeSalary(double overtimeHours){

        overtimeSalary=overtimeHours*overtimeMultiplier*regularHourlyRate;
        return overtimeSalary;
    }

    public double getOvertimeSalary(){
        return overtimeSalary;
    }

    public double getSalary(double actualHours,double overtimeHours) {
        return getBasicSalary(actualHours)+getOvertimeSalary(overtimeHours);
    }

}