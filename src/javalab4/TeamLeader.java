package javalab4;

public class TeamLeader extends Programmer implements Heading {

    private double headBonus;
    private int subordinatesQty;
    private double headRate;

    public TeamLeader(int id, String name, String position, double regularHourlyRate, double basicSalary, double projectBonus, double overtimeSalary, double overtimeHours, double overtimeMultiplier, double projectPercent, double headBonus, int subordinatesQty, double headRate) {
        super(id, name, position, regularHourlyRate, basicSalary, projectBonus, overtimeSalary, overtimeHours, overtimeMultiplier, projectPercent);
        this.headBonus = headBonus;
        this.subordinatesQty = subordinatesQty;
        this.headRate = headRate;
    }

    public void getHeadBonus() {
        // TODO implement here
    }

}