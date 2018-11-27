package java8.lambdaexpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorMain {

    /**
     * @author Arpit Mandliya
     */
    public static void main(String[] args) {
        Country indiaCountry = new Country(1, "India");
        Country chinaCountry = new Country(4, "China");
        Country nepalCountry = new Country(3, "Nepal");
        Country bhutanCountry = new Country(2, "Bhutan");

        List<Country> listOfCountries = new ArrayList();
        listOfCountries.add(indiaCountry);
        listOfCountries.add(chinaCountry);
        listOfCountries.add(nepalCountry);
        listOfCountries.add(bhutanCountry);

        System.out.println("Before Sort by name : ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country = (Country) listOfCountries.get(i);
            System.out.println(
                    "Country Id: " + country.getCountryId() + "||" + "Country name: " + country.getCountryName());
        }
        //Sort by countryName
        // Anonymous Comparator
        // old way
//        Collections.sort(listOfCountries, new Comparator() {
//            @Override
//            public int compare(Country o1, Country o2) {
//                return o1.getCountryName().compareTo(o2.getCountryName());
//            }
//        });
        // Using lambda expression
        Collections.sort(listOfCountries, (o1, o2) -> o1.getCountryName().compareTo(o2.getCountryName()));

        System.out.println("After Sort by name: ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country = (Country) listOfCountries.get(i);
            System.out.println(
                    "Country Id: " + country.getCountryId() + "|| " + "Country name: " + country.getCountryName());

        }
    }

}
