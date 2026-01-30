import java.sql.*;

public class MainDB {
    public static void main(String[] args) {
        try {

            Connection conn = DBConnection.getConnection();
            System.out.println("✅ Подключение к БД успешно!");


            String insertSQL = "INSERT INTO artist (name, country) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, "Coldplay");
            pstmt.setString(2, "UK");
            pstmt.executeUpdate();
            System.out.println("✅ Данные добавлены");


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM artist");
            System.out.println("\n📋 Список артистов:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("artist_id") +
                        ", Name: " + rs.getString("name") +
                        ", Country: " + rs.getString("country"));
            }


            String updateSQL = "UPDATE artist SET country = ? WHERE name = ?";
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, "United Kingdom");
            pstmt.setString(2, "Coldplay");
            pstmt.executeUpdate();
            System.out.println("\n✅ Данные обновлены");


            conn.close();

        } catch (SQLException e) {
            System.out.println("❌ Ошибка подключения: " + e.getMessage());
        }
    }
}

