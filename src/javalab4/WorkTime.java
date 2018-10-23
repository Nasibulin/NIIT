package javalab4;

public interface WorkTime {

    public default double getBasicSalary(){
        return 0;
    };
    public default double getOvertimeSalary(){
        return 0;
    }


}