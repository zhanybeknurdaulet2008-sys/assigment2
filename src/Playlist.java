import java.util.*;

public class Playlist {

    private String name;
    private List<Song> songs = new ArrayList<>();

    public Playlist(String name) {
        this.name = name;
    }
    public void addSong(Song song) {
        songs.add(song);
    }
    public List<Song> filterByDuration(int minDuration) {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getDuration() >= minDuration) {
                result.add(song);
            }
        }
        return result;
    }
    public Song searchByTitle(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }
    public void sortByDuration() {
        songs.sort(Comparator.comparingInt(Song::getDuration));
    }
    public void showPlaylist() {
        System.out.println("Playlist: " + name);
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}
