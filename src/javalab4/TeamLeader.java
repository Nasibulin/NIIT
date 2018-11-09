package javalab4;

public class TeamLeader extends Programmer implements Heading {

    private static int HEAD_RATE = 1000;
    private double headBonus;
    private int subordinatesQty;
    private double headRate;

    public TeamLeader(Integer id, String name, String position, Double regularHourlyRate, Integer actualHours,
                      Double overtimeHours,
                      Double overtimeMultiplier, Double projectPercent, Integer subordinatesQty, Double headRate) {
        super(id, name, position, regularHourlyRate, actualHours, overtimeMultiplier, projectPercent);
        this.headBonus = headBonus;
        this.subordinatesQty = subordinatesQty;
        this.headRate = headRate;
    }

    public TeamLeader(Integer id, String name, String position, Double regularHourlyRate, Integer actualHours) {
        super(id, name, position, regularHourlyRate, actualHours);
    }

    public double getHeadBonus() {
        headBonus = HEAD_RATE * (Engineer.count - 1);
        return headBonus;
    }

}