package collections.treemap;


import java.util.TreeMap;

public class TreeMapMain {

    public static void main(String args[])
    {
        // TreeMap with Country as key and capital as value
        // TreeMap stores elements in natural ordering of keys.
        TreeMap<String,String> countryCapitalMap=new TreeMap<String,String>();
        countryCapitalMap.put("India","Delhi");
        countryCapitalMap.put("Japan","Tokyo");
        countryCapitalMap.put("France","Paris");
        countryCapitalMap.put("Russia","Moscow");

        System.out.println("-----------------------------");
        // Iterating TreeMap Using keySet() and for each loop
        System.out.println("Iterating TreeMap Using keySet() and for each loop");
        for (String countryKey:countryCapitalMap.keySet()) {
            System.out.println("Country:"+ countryKey +" and  Capital:"+countryCapitalMap.get(countryKey));

        }
        System.out.println("-----------------------------");
    }

}
