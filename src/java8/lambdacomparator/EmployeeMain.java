package java8.lambdacomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeMain {

    public static void main(String[] args)
    {
        List employeeList=getEmployees();
        System.out.println("Before Sorting: ");
        System.out.println(employeeList);
        // using lambda expression
        Collections.sort(employeeList,
                         (Employee e1, Employee e2) -> e1.getEmployeeName().compareTo(e2.getEmployeeName()));
        System.out.println("After Sorting: ");
        System.out.println(employeeList);
    }

    public static List getEmployees()
    {
        List employeesList=new ArrayList();
        Employee e1=new Employee("John", 35);
        Employee e2=new Employee("Adam", 22);
        Employee e3=new Employee("Arpit", 28);
        Employee e4=new Employee("John", 30);
        Employee e5=new Employee("Grace", 38);
        Employee e6=new Employee("Arpit", 25);
        employeesList.add(e1);
        employeesList.add(e2);
        employeesList.add(e3);
        employeesList.add(e4);
        employeesList.add(e5);
        employeesList.add(e6);
        return employeesList;

    }
}
