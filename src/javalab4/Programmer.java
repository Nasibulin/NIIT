package javalab4;

public class Programmer extends Engineer {

    public Programmer(int id, String name, String position, double regularHourlyRate, double overtimeMultiplier, double projectPercent) {
        super(id, name, position, regularHourlyRate, overtimeMultiplier, projectPercent);
    }

    public double getBasicSalary(){

        Programmer p = new Programmer(1,"Ivanov","Developer",10,1.5,0.1);
        double basicSalary=super.getBasicSalary();
        return basicSalary+;
    }


}