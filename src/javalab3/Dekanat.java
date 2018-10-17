package javalab3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 15.10.18
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */
public class Dekanat {
    private static final String STUDENTS_FILE = "Students.json";
    private static final String GROUPS_FILE = "Groups.json";
    private static final String GROUPS_PATH = System.getProperty("user.dir") + "/db/" + GROUPS_FILE;
    private static final String STUDENTS_PATH = System.getProperty("user.dir") + "/db/" + STUDENTS_FILE;

    private List<Student> students = new ArrayList<Student>();
    private List<Group> groups = new ArrayList<Group>();


    void importGroups() {

        groups.clear();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(GROUPS_PATH));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray groupArray = (JSONArray) jsonObject.get("Groups");

            Iterator<JSONArray> iterator = groupArray.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                iterator.next();
                JSONObject groupData = (JSONObject) groupArray.get(i);
                int id = ((Long) groupData.get("GROUP_ID")).intValue();
                String title = (String) groupData.get("GROUP");
                groups.add(new Group(id, title));
                i++;
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    void importStudents() {

        students.clear();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(STUDENTS_PATH));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray studentArray = (JSONArray) jsonObject.get("Students");

            Iterator<JSONArray> iterator = studentArray.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                iterator.next();
                JSONObject studentData = (JSONObject) studentArray.get(i);
                int id = ((Long) studentData.get("ID")).intValue();
                String fio = (String) studentData.get("STUDENT");
                students.add(new Student(id, fio));
                i++;
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    void arrangeGroups() {

        Iterator<Student> iterator = students.iterator();
        for (Group group : groups) {
            group.clear();
            for (int i = 0; i < students.size() / groups.size(); i++) {
                if (!iterator.hasNext())
                    return;
                Student s = iterator.next();
                group.addStudent(s);
                s.setGroup(group);
                //System.out.println(group);
            }
        }
    }

    void addRandomMarks(int count) {
        Random rand = new Random();
        for (Student student : students) {
            for (int i = 0; i < count; i++)
                student.addMark(rand.nextInt(4) + 2);
        }
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    private Group searchGroup(String title) {
        for (Group group : groups) {
            if (group.getTitle().equals(title))
                return group;
        }
        return null;
    }

    private Student searchStudent(int id) {

        for (Student student : students) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    public static void main(String[] args) {
        Dekanat d = new Dekanat();
        Group g1 = new Group(1, "First group");
        d.groups.add(g1);
        Student s1 = new Student(1, "Petrov");
        s1.setGroup(g1);
        g1.addStudent(s1);
        System.out.println(d.getGroups().get(0).getStudentById(1).getGroup().avgScore());
        System.out.println(d.getGroups().get(0).getStudentById(1).avgMark());
    }

}
