package javalab3;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 15.10.18
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */
public class Dekanat {
    public static void main(String[] args) {
        Student student=new Student(1,"Ivanov");
        //student.addMark(5);
        //student.addMark(4);
        //student.addMark(3);
        //student.addMark(4);
        double avg = student.avgMark();
        //System.out.println(student.avgMark());
    }
}
