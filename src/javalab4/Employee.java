package javalab4;

public class Employee {

    private int id;
    private String name;
    private String position;
    private double salary;
    private double actualHours;
    private double actualDays;
    private int businessDays;
    private int businessHours;
    private static final int WORKDAY_DURATION = 8;

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }


    public double getActualHours() {
        return actualHours;
    }

    public void setActualHours(double actualHours) {
        this.actualHours = actualHours;
        this.actualDays=actualHours/WORKDAY_DURATION;
    }

    public double getActualDays() {
        return actualDays;
    }

    public void setActualDays(double actualDays) {
        this.actualDays = actualDays;
        this.actualDays = actualHours / WORKDAY_DURATION;
    }

    public int getBusinessDays() {
        return businessDays;
    }

    public void setBusinessDays(int businessDays) {
        this.businessDays = businessDays;
        this.actualHours = businessDays * WORKDAY_DURATION;
    }

    public int getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(int businessHours) {
        this.businessHours = businessHours;
        this.businessDays = businessHours / WORKDAY_DURATION;
    }
}