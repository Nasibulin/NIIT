package javalab4;

public class ProjectManager extends Manager implements Heading {


    private double headBonus;
    private int subordinatesQty;
    private double subordinatesRate;

//    public ProjectManager(Integer id, String name, String position, Double projectPercent,
//                          Integer subordinatesQty, Double subordinatesRate) {
//        super(id, name, position, projectPercent);
//        this.subordinatesQty = subordinatesQty;
//        this.subordinatesRate = subordinatesRate;
//    }

    public ProjectManager(Integer id, String name, String position, Double hourlyRate, Integer actualHours) {
        super(id, name, position, hourlyRate, actualHours);
    }

    public double getHeadBonus() {
        // TODO implement here
        return 0;
    }

}