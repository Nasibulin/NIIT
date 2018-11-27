package collections.linkedhashset;

import java.util.LinkedHashSet;

public class LinkedHashSetMain {

    public static void main(String args[])
    {
        // LinkedHashSet with Country
        // LinkedHashSet maintains insertion order
        LinkedHashSet<String> countryHashSet=new LinkedHashSet<String>();
        countryHashSet.add("India");
        countryHashSet.add("Japan");
        countryHashSet.add("France");
        countryHashSet.add("Russia");
        countryHashSet.add("India");
        countryHashSet.add("France");
        countryHashSet.add("United Kingdom");

        System.out.println("-----------------------------");

        System.out.println("Iterating LinkedHashSet");
        System.out.println("-----------------------------");
        for (String country:countryHashSet) {
            System.out.println(country);

        }
        System.out.println("-----------------------------");
    }

}
