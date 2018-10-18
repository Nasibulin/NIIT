package javalab4;

public class Manager extends Employee implements Project {

    private double projectBonus;
    private double projectPercent;


    public Manager(int id, String name, String position, double projectBonus, double projectPercent) {
        super(id, name, position);
        this.projectBonus = projectBonus;
        this.projectPercent = projectPercent;
    }

    public void getProjectBonus() {
        // TODO implement here
    }

}