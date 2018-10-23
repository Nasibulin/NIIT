package javalab4;

public class Manager extends Employee implements ProjectShare {

    private double projectBonus;
    private double projectPercent;
    private int actualHours;



    public Manager(Integer id, String name, String position, Double hourlyRate) {
        super(id, name, position, hourlyRate);
        this.projectPercent = projectPercent;
    }

    public Manager(Integer id, String name, String position, Double hourlyRate, Integer actualHours) {
        super(id, name, position, hourlyRate, actualHours);
        //super.setActualHours(getBusinessHours());
    }

    public double getProjectBonus() {
        // TODO implement here
        return 0;
    }

}