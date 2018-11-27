package java8.foreach;

import java.util.HashMap;

public class HashMapIterationMap {

    public static void main(String args[])
    {
        // HashMap with Country as key and capital as value
        HashMap<String,String> countryCapitalMap=new HashMap<String,String>();
        countryCapitalMap.put("India","Delhi");
        countryCapitalMap.put("Japan","Tokyo");
        countryCapitalMap.put("France","Paris");
        countryCapitalMap.put("Russia","Moscow");


        // Iterating Using Java 8
        System.out.println("Iterating Using Java 8");
        System.out.println("-----------------------------");

        countryCapitalMap.forEach((k,v)->System.out.println("Country:" + k + " Capital : " + v));

        System.out.println("-----------------------------");
    }

}
