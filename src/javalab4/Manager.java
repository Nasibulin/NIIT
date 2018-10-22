package javalab4;

public class Manager extends Employee implements ProjectShare {

    private double projectBonus;
    private double projectPercent;


    public Manager(Integer id, String name, String position, double projectPercent) {
        super(id, name, position);
        this.projectPercent = projectPercent;
    }

    public Manager(Integer id, String name, String position) {
        super(id, name, position);
    }

    public double getProjectBonus() {
        // TODO implement here
        return 0;
    }

}