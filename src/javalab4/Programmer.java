package javalab4;

public class Programmer extends Engineer {

    public Programmer(int id, String name, String position, double regularHourlyRate, double overtimeMultiplier,
                      double projectPercent) {
        super(id, name, position, regularHourlyRate, overtimeMultiplier, projectPercent);
    }

    public double getBasicSalary() {

        double basicSalary = super.getBasicSalary();
        return basicSalary;
    }


}