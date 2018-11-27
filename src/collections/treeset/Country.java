package collections.treeset;

public class Country implements Comparable{

    String countryName;

    public Country(String countryName) {
        super();
        this.countryName = countryName;
    }

    @Override
    public int compareTo(Object arg0) {
        Country country=(Country) arg0;

        return (this.countryName.compareTo(country.countryName) ) ;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}
