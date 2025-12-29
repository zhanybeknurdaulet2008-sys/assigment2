import java.util.Objects;

public class Artist {

    private String name;
    private String country;
    public Artist(String name, String country) {
        this.name = name;
        this.country = country;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name + " (" + country + ")";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;
        Artist artist = (Artist) o;
        return name.equals(artist.name) && country.equals(artist.country);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }
}