package javalab4;

public class ProjectManager extends Manager implements Heading {


    private double headBonus;
    private int subordinatesQty;
    private double subordinatesRate;

    public ProjectManager(int id, String name, String position, double projectBonus, double projectPercent, double headBonus, int subordinatesQty, double subordinatesRate) {
        super(id, name, position, projectBonus, projectPercent);
        this.headBonus = headBonus;
        this.subordinatesQty = subordinatesQty;
        this.subordinatesRate = subordinatesRate;
    }

    public void getHeadBonus() {
        // TODO implement here
    }

}