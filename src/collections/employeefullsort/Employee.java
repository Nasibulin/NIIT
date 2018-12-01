package collections.employeefullsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee {
    public String name;
    public int age;

    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public static void main(String args[]) {

        List<Employee> employees= new ArrayList();
        Employee emp1= new Employee("John",26);
        Employee emp2= new Employee("Martin",23);
        Employee emp3= new Employee("John",20);
        Employee emp4= new Employee("Martin",19);
        Employee emp5= new Employee("Arpit",27);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        System.out.println("List before sorting : ");
        for(Employee e: employees)
        {
            System.out.println(e.name+" - "+e.age);
        }

        Collections.sort(employees, new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                // TODO Auto-generated method stub
                if (o1.name.compareTo(o2.name) == 0) {
                    return o1.age - o2.age;
                } else {
                    return o1.name.compareTo(o2.name);
                }
            }
        });
        System.out.println("--------------------------");
        System.out.println("List after sorting : ");
        for(Employee e: employees)
        {
            System.out.println(e.name+" - "+e.age);
        }
    }
}
