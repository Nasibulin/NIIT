package javalab3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 15.10.18
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class Group {
    private String title;
    private Student head;
    private int num;
    private List<Student> students = new ArrayList();

    public Group(String title) {

        this.title = title;
    }

    public void addStudent(Student student) {
        students.add(student);
        num++;
    }
}
