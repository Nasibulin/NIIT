package java8.foreach;

import java.util.ArrayList;

public class IteratingArrayListMain {

    public static void main(String[] args) {
        ArrayList nameList=new ArrayList();//creating arraylist
        nameList.add("Arpit");//adding object in arraylist
        nameList.add("John");
        nameList.add("Martin");
        nameList.add("Adam");
        // Iterating list using foreach method
        nameList.forEach(n->System.out.print(n+" "));
    }
}
