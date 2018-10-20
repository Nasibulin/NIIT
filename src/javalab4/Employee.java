package javalab4;

public class Employee {

    private int id;
    private String name;
    private String position;
    private double salary;
    private double actualHours;
    private double actualDays;
    private static int businessDays;
    private static int businessHours;
    private static final int WORKDAY_DURATION = 8;

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }


    public double getActualHours() {
        return actualHours;
    }

    public void setActualHours(double actualHours) {
        this.actualHours = actualHours;
        this.actualDays = actualHours / WORKDAY_DURATION;
    }

    public double getActualDays() {
        return actualDays;
    }

    public void setActualDays(double actualDays) {
        this.actualDays = actualDays;
        this.actualDays = actualHours / WORKDAY_DURATION;
    }

    public static int getBusinessDays() {
        return businessDays;
    }

    public static void setBusinessDays(int bd) {
        businessDays = bd;
        businessHours = bd * WORKDAY_DURATION;
    }

    public static int getBusinessHours() {
        return businessHours;
    }

    public static void setBusinessHours(int bh) {
        businessHours = bh;
        businessDays = businessHours / WORKDAY_DURATION;
    }

    public String toString() {
        return name;
    }
}