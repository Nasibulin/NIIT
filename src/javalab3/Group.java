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
    private int id;
    private String title;
    private Student head;
    private int num;
    private List<Student> students = new ArrayList();

    public Group(int id, String title) {
        this.id = id;
        this.title = title;
    }

//    public Group(int id, String title, List<Student> students) {
//        this.id = id;
//        this.title = title;
//        this.num = students.size();
//        this.students = students;
//    }

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

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (id == student.getId()) {
                return student;
            }
        }
        return null;

    }

    public Student getStudentByFio(String fio) {
        for (Student student : students) {
            if (fio.equals(student.getFio()))
                return student;
        }
        return null;

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
        try {
            Student head = students.get(0);
            for (Student student : students) {
                head = (student.avgMark() >= head.avgMark() ? student : head);
            }
            this.head = head;
        } catch (IndexOutOfBoundsException ex) {
            //ex.printStackTrace();
            System.err.println("Группа не сформирована. Добавьте студентов.");
        }

    }

    public Student getHead() {
        return head;
    }

    public String getTitle(){
        return title;
    }

    public int getNum(){
        return num;
    }

    public String toString() {
        return title;
    }

    public void clear() {
        this.students.clear();
    }
}
