package collections.linkedhashmap;

import java.util.LinkedHashMap;

public class LinkedHashMapMain {

    public static void main(String args[])
    {
        // LinkedHashMap with Country as key and capital as value
        // LinkedHashMap maintains insertion order
        LinkedHashMap<String,String> countryCapitalMap=new LinkedHashMap<String,String>();
        countryCapitalMap.put("India","Delhi");
        countryCapitalMap.put("Japan","Tokyo");
        countryCapitalMap.put("France","Paris");
        countryCapitalMap.put("Russia","Moscow");

        System.out.println("-----------------------------");
        // Iterating Using keySet() and for each loop
        System.out.println("Iterating Using keySet() and for each loop");
        for (String countryKey:countryCapitalMap.keySet()) {
            System.out.println("Country:"+ countryKey +" and  Capital:"+countryCapitalMap.get(countryKey));

        }
        System.out.println("-----------------------------");
    }

}
