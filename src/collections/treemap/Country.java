package collections.treemap;

public class Country implements Comparable {

    String name;
    long population;

    public Country(String name, long population) {
        super();
        this.name = name;
        this.population = population;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }
    @Override
    public int compareTo(Object o) {
        Country country=(Country) o;
        return this.getName().compareTo(country.getName());
    }

}
