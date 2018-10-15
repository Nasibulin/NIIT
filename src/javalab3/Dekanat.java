package javalab3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 15.10.18
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */
public class Dekanat {
    public static final String STUDENTS_FILE = "Students.json";
    public static final String GROUPS_FILE = "Groups.json";
    public static final String GROUPS_PATH = System.getProperty("user.dir") + "/db/" + GROUPS_FILE;
    public static final String STUDENTS_PATH = System.getProperty("user.dir") + "/db/" + STUDENTS_FILE;

    private List<Student> studentStream = new ArrayList();
    private List<Group> groups = new ArrayList();

    public void importStream() {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(STUDENTS_PATH));

            JSONObject jsonObject = (JSONObject) obj;

            // loop array
            JSONArray studentArray = (JSONArray) jsonObject.get("Students");
            Iterator<JSONArray> iterator = studentArray.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                iterator.next();
                JSONObject studentData = (JSONObject) studentArray.get(i);
                Integer id = ((Long) studentData.get("ID")).intValue();
                String fio = (String) studentData.get("STUDENT");
                studentStream.add(new Student(id, fio));
                i++;

            }
            //System.out.println(studentStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        Student s1 = new Student(1, "Ivanov");
//        s1.addMark(5);
//        s1.addMark(4);
//        s1.addMark(3);
//        s1.addMark(4);
//        System.out.println(s1.avgMark());
//        Student s2 = new Student(2, "Petrov");
//        s2.addMark(5);
//        s2.addMark(5);
//        s2.addMark(4);
//        s2.addMark(5);
//        System.out.println(s2.avgMark());
//        Group g1 = new Group("First");
//        g1.addStudent(s1);
//        g1.addStudent(s2);
//        System.out.println(g1.avgScore());
//        System.out.println(g1.getHead());
//        g1.headElection();
//        System.out.println(g1.getHead());
        Dekanat dek = new Dekanat();
        dek.importStream();
    }
}
