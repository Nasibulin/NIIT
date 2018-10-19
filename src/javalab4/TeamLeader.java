package javalab4;

public class TeamLeader extends Programmer implements Heading {

    private double headBonus;
    private int subordinatesQty;
    private double headRate;

    public TeamLeader(int id, String name, String position, double regularHourlyRate, double overtimeHours,
                      double overtimeMultiplier, double projectPercent, int subordinatesQty, double headRate) {
        super(id, name, position, regularHourlyRate, overtimeMultiplier, projectPercent);
        this.headBonus = headBonus;
        this.subordinatesQty = subordinatesQty;
        this.headRate = headRate;
    }

    public double getHeadBonus() {
        // TODO implement here
        return 0;
    }

}