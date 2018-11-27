package java8.streamfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamFilterExamples {

    public static void main(String[] args)
    {
        List<Student> studentList=createStudentList();

        // Filter all male students
        List<Student> maleStudents=studentList.stream()
                .filter(s->s.getGender().equalsIgnoreCase("M"))
                .collect(Collectors.toList());
        System.out.println("Male students are :"+maleStudents);
        // Filer based on name
        Student student=studentList.stream()
                .filter(s-> s.getName().equalsIgnoreCase("John"))
                .findAny()
                .orElse(null);
        System.out.println("Student with Name john :"+student);
    }

    public static List createStudentList()
    {
        List<Student> studentList=new ArrayList();
        Student s1=new Student(1, "Arpit", "M", 19);
        Student s2=new Student(2, "John", "M", 17);
        Student s3=new Student(3, "Mary", "F", 14);
        Student s4=new Student(4, "Martin", "M", 21);
        Student s5=new Student(5, "Monica", "F", 16);
        Student s6=new Student(6, "Ally", "F", 20);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        return studentList;
    }
}
