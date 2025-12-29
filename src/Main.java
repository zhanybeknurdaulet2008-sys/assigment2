public class Main {
    public static void main(String[] args) {

        Artist a1 = new Artist("Ed Sheeran", "UK");
        Artist a2 = new Artist("Imagine Dragons", "USA");

        MediaItem s1 = new Song("Shape of You", 240, a1);
        MediaItem s2 = new Song("Believer", 204, a2);

        Playlist playlist = new Playlist("My Favorites");

        playlist.addSong((Song) s1);
        playlist.addSong((Song) s2);

        playlist.showPlaylist();

        System.out.println("\nSorted by duration:");
        playlist.sortByDuration();
        playlist.showPlaylist();

        System.out.println("\nFilter (>=220 sec):");
        for (Song s : playlist.filterByDuration(220)) {
            System.out.println(s);
        }
    }
}

