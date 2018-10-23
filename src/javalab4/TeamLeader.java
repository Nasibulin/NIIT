package javalab4;

public class TeamLeader extends Programmer implements Heading {

    private double headBonus;
    private int subordinatesQty;
    private double headRate;

    public TeamLeader(Integer id, String name, String position, Double regularHourlyRate, Integer actualHours, Double overtimeHours,
                      Double overtimeMultiplier, Double projectPercent, Integer subordinatesQty, Double headRate) {
        super(id, name, position, regularHourlyRate,actualHours,overtimeMultiplier, projectPercent);
        this.headBonus = headBonus;
        this.subordinatesQty = subordinatesQty;
        this.headRate = headRate;
    }

    public TeamLeader(Integer id, String name, String position, Double regularHourlyRate, Integer actualHours) {
        super(id, name, position, regularHourlyRate, actualHours);
    }

    public double getHeadBonus() {
        // TODO implement here
        return 0;
    }

}