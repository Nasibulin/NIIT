package javalab3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 15.10.18
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    private int id;
    private String fio;
    public Group group;
    private List<Integer> marks = new ArrayList<Integer>();
    public int num;

    public Student(int id, String fio) {
        this.id = id;
        this.fio = fio;
    }

    public void addMark(int mark) {
        marks.add(mark);
        num++;
    }

    public double avgMark() {
        double avgMark = 0;
        try {
            avgMark = marks.stream().mapToInt(e -> e).average().getAsDouble();
        } catch (NoSuchElementException ex) {
            //ex.printStackTrace();
            System.err.println("� �������� ��� ��� ������.");
        }
        return avgMark;
    }

    public void setGroup(Group group) {
        this.group=group;
    }

    public String getFio() {
        return fio;
    }

    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public Group getGroup(){
        return group;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public String toString() {
        return fio;
    }

}
