package collections.treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetMain {

    /**
     * @author Arpit Mandliya
     */
    public static void main(String[] args) {
        Country indiaCountry=new Country("India");
        Country chinaCountry=new Country("China");
        Country nepalCountry=new Country("Nepal");
        Country bhutanCountry=new Country("Bhutan");
        Country indiaCountry2=new Country("India");
        Country nepalCountry2=new Country("Nepal");

        TreeSet countryTreeSet = new TreeSet();
        countryTreeSet.add(indiaCountry);
        countryTreeSet.add(chinaCountry);
        countryTreeSet.add(nepalCountry);
        countryTreeSet.add(bhutanCountry);
        countryTreeSet.add(indiaCountry2);
        countryTreeSet.add(nepalCountry2);

        Iterator<Country> counIter=countryTreeSet.iterator(); // put debug point here
        while(counIter.hasNext())
        {
            System.out.println(counIter.next().countryName);
        }
    }

}
