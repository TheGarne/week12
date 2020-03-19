public class Country {
    private String countryName;
    private int rank;
    private String population;

    public Country(String countryName, int year, String population) {
        this.countryName = countryName;
        this.rank = year;
        this.population = population;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getRank() {
        return rank;
    }

    public String getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + countryName + '\'' +
                ", Rank=" + rank +
                ", Population=" + population +
                '}';
    }
}
