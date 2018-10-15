package javalab3;

import java.util.ArrayList;
import java.util.Iterator;
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

    public Group(String title, List<Student> students) {
        this.title = title;
        this.num = students.size();
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
        num++;
    }

    public double avgScore() {
        double avgScore = 0;
        for (Student student : students) {
            avgScore += student.avgMark();
        }
        return avgScore / students.size();

    }

    public boolean searchStudentById(int id) {
        boolean result = false;
        for (Student student : students) {
            if (id == student.getId()) {
                result = true;
            }
        }
        return result;

    }

    public boolean searchStudentByFio(String fio) {
        boolean result = false;
        for (Student student : students) {
            if (fio.equals(student.getFio()))
                result = true;
        }
        return result;

    }

    protected void removeStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
            }
        }

    }

    protected void headElection() {
        Student head = students.get(0);
        for (Student student : students) {
            head = (student.avgMark() >= head.avgMark() ? student : head);
        }
        this.head = head;

    }
    public Student getHead(){
        return head;
    }

    public String toString(){
        return title;
    }
}
