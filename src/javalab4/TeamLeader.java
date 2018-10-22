package javalab4;

public class TeamLeader extends Programmer implements Heading {

    private double headBonus;
    private int subordinatesQty;
    private double headRate;

    public TeamLeader(Integer id, String name, String position, Double regularHourlyRate, Double overtimeHours,
                      Double overtimeMultiplier, Double projectPercent, Integer subordinatesQty, Double headRate) {
        super(id, name, position, regularHourlyRate, overtimeMultiplier, projectPercent);
        this.headBonus = headBonus;
        this.subordinatesQty = subordinatesQty;
        this.headRate = headRate;
    }

    public TeamLeader(Integer id, String name, String position) {
        super(id, name, position);
    }

    public double getHeadBonus() {
        // TODO implement here
        return 0;
    }

}