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

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

}