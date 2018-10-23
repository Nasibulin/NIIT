package javalab4;

public class Manager extends Employee implements ProjectShare {

    private double projectBonus;
    private double projectPercent;


    public Manager(Integer id, String name, String position, Double hourlyRate) {
        super(id, name, position, hourlyRate);
        this.projectPercent = projectPercent;
    }

    public Manager(Integer id, String name, String position, Double hourlyRate, Double actualHours) {
        super(id, name, position, hourlyRate, actualHours);
    }

    public double getProjectBonus() {
        // TODO implement here
        return 0;
    }

}