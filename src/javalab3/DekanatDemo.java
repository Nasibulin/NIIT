package javalab3;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 16.10.18
 * Time: 10:32
 * To change this template use File | Settings | File Templates.
 */
public class DekanatDemo {
    public static void main(String[] args) {
        Dekanat dek = new Dekanat();
        dek.importGroups();
        dek.importStudents();
        dek.arrangeGroups();
        dek.addRandomMarks(25);
        System.out.println(dek.getGroups().get(0));
        System.out.println(dek.getGroups().get(1));
        System.out.println(dek.getGroups().get(2));
        System.out.println(dek.getGroups().get(0).getNum());
        System.out.println(dek.getGroups().get(1).getNum());
        System.out.println(dek.getGroups().get(2).getNum());
        dek.getGroups().get(2).headElection();
        System.out.println(dek.getGroups().get(0).getStudentById(26).getMarks());
        System.out.println(dek.getGroups().get(0).getStudentById(26).getGroup());
        System.out.println(dek.getGroups().get(0).getStudentById(26));

    }
}
