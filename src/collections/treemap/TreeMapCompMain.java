package collections.treemap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapCompMain {

    public static void main(String[] args)
    {
        Country india=new Country("India",1000);
        Country japan=new Country("Japan",10000);

        Country france=new Country("France",2000);
        Country russia=new Country("Russia",20000);

        Comparator<Country> comparator=new Comparator<Country>() {

            @Override
            public int compare(Country o1, Country o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };

        System.out.println("Sorting TreeMap in reverse order of country name");
        TreeMap<Country, String> countryCapitalMap=new TreeMap<Country,String>(comparator);
        countryCapitalMap.put(india,"Delhi");
        countryCapitalMap.put(japan,"Tokyo");
        countryCapitalMap.put(france,"Paris");
        countryCapitalMap.put(russia,"Moscow");

        Iterator<Country> countryCapitalIter=countryCapitalMap.keySet().iterator();//put debug point at this line
        while(countryCapitalIter.hasNext())
        {
            Country countryObj=countryCapitalIter.next();
            String capital=countryCapitalMap.get(countryObj);
            System.out.println(countryObj.getName()+"----"+capital);
        }
    }

}
