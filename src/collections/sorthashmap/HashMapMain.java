package collections.sorthashmap;

import java.util.*;

public class HashMapMain {

    public static void main(String args[]) {
        // HashMap with Country name as key and capital as value
        // HashMap stores elements in key value pairs
        HashMap<String, String> countryCapitalMap = new HashMap<String, String>();

        countryCapitalMap.put("Japan", "Tokyo");
        countryCapitalMap.put("France", "Paris");
        countryCapitalMap.put("Russia", "Moscow");
        countryCapitalMap.put("India", "Delhi");

        System.out.println("-----------------------------");
        // Iterating HashMap Using keySet() and for each loop
        System.out.println("Before Sorting");
        System.out.println("-----------------------------");
        for (String countryKey : countryCapitalMap.keySet()) {
            System.out.println("Country:" + countryKey + " and  Capital:" + countryCapitalMap.get(countryKey));

        }

        Set<Map.Entry<String, String>> countryCapitalEntrySet=countryCapitalMap.entrySet();

        List<Map.Entry<String, String>> entryList=new ArrayList<Map.Entry<String, String>>(countryCapitalEntrySet);

        Collections.sort(entryList,new Comparator<Map.Entry<String,String>>() {

            @Override
            public int compare(Map.Entry<String,String> o1, Map.Entry<String,String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println("-----------------------------");

        // Using LinkedHashMop to keep entries in sorted order
        LinkedHashMap<String,String> sortedHashMap=new LinkedHashMap<String,String>();
        for (Map.Entry<String,String> entry:entryList) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println("After Sorting");
        System.out.println("-----------------------------");
        // Iterating sortedHashMap Using keySet() and for each loop

        for (String countryKey : sortedHashMap.keySet()) {
            System.out.println("Country:" + countryKey + " and  Capital:" + sortedHashMap.get(countryKey));

        }
    }
}
