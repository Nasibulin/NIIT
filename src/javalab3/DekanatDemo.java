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
        dek.allGroupElection();
        dek.printData();
        dek.dismissStudents(3.45);
        dek.printData();
//        System.out.println(dek.getGroups().get(0).getNum());
//        System.out.println(dek.getGroups().get(1).getNum());
//        System.out.println(dek.getGroups().get(2).getNum());
//        System.out.println(dek.getGroups().get(1).getStudentById(50).getMarks());
//        System.out.println(dek.getGroups().get(1).getStudentById(50).getGroup());
//        System.out.println(dek.getGroups().get(1).getStudentById(50));
//        System.out.println(dek.getGroups().get(0).getHead());
//        System.out.println(dek.getGroups().get(1).getHead());
//        System.out.println(dek.getGroups().get(2).getHead());

    }
}
