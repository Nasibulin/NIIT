package javalab4;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Konstantin
 * Date: 20.10.18
 * Time: 12:55
 * To change this template use File | Settings | File Templates.
 */
public class StaffDemo {
    private static HashMap<String, String> jobToClass;
    private static final String PACKAGE_PREFIX = "";
    private static final String STAFF_FILE = "Staff.json";
    private static final String STAFF_PATH = System.getProperty("user.dir") + "/db/" + STAFF_FILE;
//    static StaffDemo s = new StaffDemo();
//    static String PACKAGE_PREFIX = s.getClass().getPackage().getName()+'.';
    private static String className = "javalab4.Programmer";
    private List<Employee> staff = new ArrayList<Employee>();
    private HashMap<Integer,String> pos = new HashMap<Integer,String>();
    //private List<Group> groups = new ArrayList<Group>();

    static {
        jobToClass = new HashMap<String, String>();
        jobToClass.put("Уборщица", "Cleaner");
        jobToClass.put("Водитель", "Driver");
        jobToClass.put("Инженер-программист", "Programmer");
        jobToClass.put("Ведущий программист", "TeamLeader");
        jobToClass.put("Инженер по тестированию", "Tester");
        jobToClass.put("Инженер", "Engineer");
        jobToClass.put("Менеджер", "Manager");
        jobToClass.put("Менеджер проекта", "ProjectManager");
        jobToClass.put("Руководитель направления", "SeniorManager");
    }

    public void setUpPositions(){
        pos.clear();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(STAFF_PATH));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray posArray = (JSONArray) jsonObject.get("Positions");

            Iterator<JSONArray> iterator = posArray.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                iterator.next();
                JSONObject posData = (JSONObject) posArray.get(i);
                Integer id = ((Long) posData.get("id")).intValue();
                String position = (String) posData.get("position");
                pos.put(id, position);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
    public void setUpStaff(){
        staff.clear();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(STAFF_PATH));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray staffArray = (JSONArray) jsonObject.get("Staff");

            Iterator<JSONArray> iterator = staffArray.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                iterator.next();
                JSONObject staffData = (JSONObject) staffArray.get(i);
                Integer id = ((Long) staffData.get("staff_id")).intValue();
                String fio = (String) staffData.get("fio");
                Integer position = ((Long) staffData.get("position")).intValue();
                staff.add(new Personal(id, fio, pos.get(position)));
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

    public static void main(
            String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        StaffDemo sd = new StaffDemo();
        sd.setUpPositions();
        sd.setUpStaff();
        for (Employee e:sd.staff){
            System.out.println(e.getId()+"\t"+e.getName()+"\t"+e.getPosition());
        }

    }
    public static void main_bckup(
            String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
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
        Project p1 = new Project(1, "Windows 11 project", 200000);
        t.setProject(p1);
        System.out.println(t.getSalary(176, 5, p1));

        Class<?> staff = Class.forName(className);
        //Constructor<?> ctor = staff.getConstructor();
        Constructor<?> ctor = staff.getConstructor(Integer.class, String.class, String.class);
        Object object = ctor.newInstance(new Object[]{1, "Сидоров", "Программист"});

        System.out.println(PACKAGE_PREFIX + jobToClass.get("Инженер-программист"));
    }
}

