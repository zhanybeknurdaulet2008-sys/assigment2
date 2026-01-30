import java.sql.*;

public class SongDAO {

    public void addSong(String title, int duration, int artistId) {
        String sql = "INSERT INTO song (title, duration, artist_id) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setInt(2, duration);
            ps.setInt(3, artistId);
            ps.executeUpdate();

            System.out.println("Song DB-ға сақталды");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showSongs() {
        String sql = "SELECT title, duration FROM song";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getString("title") + " - " +
                                rs.getInt("duration") + " sec"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

