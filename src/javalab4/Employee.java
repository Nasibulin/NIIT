package javalab4;

public class Employee implements Comparable<Employee> {

    private static final int WORKDAY_DURATION = 8;
    private static int businessDays;
    private static int businessHours;
    private int id;
    private String name;
    private String position;
    private double salary;
    private double hourlyRate;
    private double actualHours;
    private double actualDays;

    public Employee(Integer id, String name, String position, Double hourlyRate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.hourlyRate = hourlyRate;
    }

    public Employee(Integer id, String name, String position, Double hourlyRate, Double actualHours) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.actualHours = actualHours;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public double getSalary() {
        return hourlyRate * actualHours;
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

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.getId() < o.getId()) {
            return -1;
        } else {
            return 1;
        }
    }
}