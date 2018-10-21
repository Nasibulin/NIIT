package javalab4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: Konstantin
 * Date: 20.10.18
 * Time: 12:55
 * To change this template use File | Settings | File Templates.
 */
public class StaffDemo {

    private static String className="javalab4.Programmer";

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //Employee e = new Employee(1, "Иванов", "Инженер");
        Employee.setBusinessDays(22);
        //Personal p = new Personal(1, "Петров", "Водитель", 100);
        //Programmer prog = new Programmer(1, "Сидоров", "Программист", 500, 1.5, 0.1);
        //System.out.println(p);
        //System.out.println(p.getBusinessHours());
        //System.out.println(e);
        //System.out.println(e.getBusinessDays());
        //System.out.println(prog.getSalary(176, 5));
        //System.out.println(prog.getSalary(176));

        Tester t = new Tester(3, "Васечкин", "Тестер", 350, 1.5, 0.1);
        System.out.println(t.getSalary(176, 5));
        Project p1 = new Project(1,"Windows 11 project",200000);
        t.setProject(p1);
        System.out.println(t.getSalary(176,5,p1));

        Class<?> staff = Class.forName(className);
        Constructor<?> ctor = staff.getConstructor(Integer.class, String.class, String.class,Double.class,Double.class,Double.class);
        //Constructor<?> ctor = staff.getConstructor(Integer.class, String.class, String.class, Double.class);
        Object object = ctor.newInstance(new Object[]{1,"Сидоров","Программист",500.0,1.5,0.1});
        System.out.println(object);
        System.out.println(object.getClass());

    }

}
