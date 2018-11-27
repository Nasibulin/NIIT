package collections.hashmap2arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapToArrayListConversionMain {

    public static void main(String args[])
    {
        // HashMap with Country as key and capital as value
        HashMap<String,String> countryCapitalMap=new HashMap<String,String>();
        countryCapitalMap.put("India","Delhi");
        countryCapitalMap.put("Japan","Tokyo");
        countryCapitalMap.put("France","Paris");
        countryCapitalMap.put("Russia","Moscow");


        System.out.println("-----------------------------");

        // Creating  ArrayList from Keys

        ArrayList<String> keysArrayList=new ArrayList(countryCapitalMap.keySet());
        System.out.println("Keys are: ");
        for (String country:keysArrayList) {
            System.out.println(country);
        }

        System.out.println("-----------------------------");

        //Creating  ArrayList from Values
        ArrayList<String> valuesArrayList=new ArrayList(countryCapitalMap.values());
        System.out.println("Values are: ");
        for (String capital:valuesArrayList) {
            System.out.println(capital);
        }
        System.out.println("-----------------------------");

        //Creating  ArrayList from Entry set
        ArrayList<Map.Entry<String,String>> entryArrayList=new ArrayList<Map.Entry<String,String>>(countryCapitalMap.entrySet());
        for (Map.Entry<String,String> entry:entryArrayList) {
            System.out.println("Country:"+ entry.getKey() +" and  Capital:"+entry.getValue());

        }

        System.out.println("-----------------------------");

    }

}
