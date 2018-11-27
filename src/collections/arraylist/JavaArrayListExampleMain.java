package collections.arraylist;

import java.util.ArrayList;

public class JavaArrayListExampleMain {
    /*
     * @author : Arpit Mandliya
     */
    public static void main(String[] args) {
        ArrayList<String> employeeNameList = new ArrayList();
        employeeNameList.add("John");
        employeeNameList.add("Ankit");
        employeeNameList.add("Rohan");
        employeeNameList.add("Amit");

        System.out.println("Employee list:");

        for (String empName : employeeNameList) {

            System.out.println(empName);

        }

    }
}
