import java.sql.*;

public class ArtistDAO {

    public void addArtist(String name, String country) {
        String sql = "INSERT INTO artist (name, country) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, name);
            ps.setString(2, country);
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                System.out.println("Artist қосылды: " + name + ", ID = " + keys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // SELECT арқылы шығару
    public void showArtists() {
        String sql = "SELECT * FROM artist";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nБарлық орындаушылар:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("artist_id") + ": " +
                                rs.getString("name") + " (" +
                                rs.getString("country") + ")"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
