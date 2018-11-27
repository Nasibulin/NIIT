package collections.hashset;

import java.util.HashSet;

public class HashSetCountryMain {

    public static void main(String[] args)
    {
        HashSet countrySet=new HashSet();
        Country india1=new Country();
        india1.setName("India");

        Country india2=new Country();
        india2.setName("India");

        countrySet.add(india1);
        countrySet.add(india2);

        System.out.println("size of nameSet="+countrySet.size());
        System.out.println(countrySet);

    }
}
