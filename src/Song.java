import java.util.Objects;

public class Song extends MediaItem {

    private Artist artist;
    public Song(String title, int duration, Artist artist) {
        super(title, duration);
        this.artist = artist;
    }
    public Artist getArtist() {
        return artist;
    }
    @Override
    public String getInfo() {
        return title + " (" + duration + " sec) by " + artist.getName();
    }
    @Override
    public String toString() {
        return getInfo();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return duration == song.duration &&
                title.equals(song.title) &&
                artist.equals(song.artist);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, duration, artist);
    }
}
