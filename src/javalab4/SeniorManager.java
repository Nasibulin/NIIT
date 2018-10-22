package javalab4;

public class SeniorManager extends ProjectManager {

    public SeniorManager(Integer id, String name, String position, double projectPercent,
                         int subordinatesQty, double subordinatesRate) {
        super(id, name, position, projectPercent, subordinatesQty, subordinatesRate);
    }

    public SeniorManager(Integer id, String name, String position, Double hourlyRate) {
        super(id, name, position, hourlyRate);
    }


}