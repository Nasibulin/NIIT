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
    private static final String PACKAGE_PREFIX = "javalab4.";
    private static final String STAFF_FILE = "Staff.json";
    private static final String STAFF_PATH = System.getProperty("user.dir") + "/db/" + STAFF_FILE;
//    static StaffDemo s = new StaffDemo();
//    static String PACKAGE_PREFIX = s.getClass().getPackage().getName()+'.';
    private List<Employee> staff = new ArrayList<Employee>();
    private HashMap<Integer,String> pos = new HashMap<Integer,String>();

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

                Class<?> localstaff = Class.forName(PACKAGE_PREFIX+jobToClass.get(pos.get(position)));
                Constructor<?> ctor = localstaff.getConstructor(Integer.class, String.class, String.class);
                Object object = ctor.newInstance(new Object[]{id,fio,pos.get(position)});
                staff.add((Employee)object);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

    public static void main(
            String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        StaffDemo sd = new StaffDemo();
        sd.setUpPositions();
        sd.setUpStaff();
        for (Employee e:sd.staff){
            System.out.println(e.getClass().getTypeName()+" "+e.getId()+"\t"+e.getName()+"\t"+e.getPosition());
        }

    }
}

