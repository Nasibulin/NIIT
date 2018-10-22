package javalab4;

public class Programmer extends Engineer {

    public Programmer(Integer id, String name, String position, Double regularHourlyRate, Double overtimeMultiplier,
                      Double projectPercent) {
        super(id, name, position, regularHourlyRate, overtimeMultiplier, projectPercent);
    }

    public Programmer(Integer id, String name, String position, Double regularHourlyRate) {
        super(id, name, position, regularHourlyRate);
    }

}