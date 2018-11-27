package collections.comparator;

import java.util.Comparator;

public class EmployeeSortByIdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getEmpId()-e2.getEmpId();
    }
}
