package collections.sorthashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapCompMain1 {

    public static void main(String[] args)
    {
        Country india=new Country("India",1000);
        Country japan=new Country("Japan",10000);

        Country france=new Country("France",2000);
        Country russia=new Country("Russia",20000);

        HashMap<Country, String> countryCapitalMap=new HashMap<Country,String>();
        countryCapitalMap.put(india,"Delhi");
        countryCapitalMap.put(japan,"Tokyo");
        countryCapitalMap.put(france,"Paris");
        countryCapitalMap.put(russia,"Moscow");

        System.out.println("Sorting HashMap by passing it to TreeMap constructor");
        TreeMap<Country,String> sortedTreeMapCountryCapital=new  TreeMap<Country,String> (countryCapitalMap);
        Iterator<Country> countryCapitalIter=sortedTreeMapCountryCapital.keySet().iterator();//put debug point at this line
        while(countryCapitalIter.hasNext())
        {
            Country countryObj=countryCapitalIter.next();
            String capital=countryCapitalMap.get(countryObj);
            System.out.println(countryObj.getName()+"----"+capital);
        }
    }

}
