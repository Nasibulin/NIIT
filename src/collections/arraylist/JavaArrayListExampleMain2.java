package collections.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class JavaArrayListExampleMain2 {
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

        Iterator iter = employeeNameList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


    }
}
