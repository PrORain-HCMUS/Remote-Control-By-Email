package Frontend.GUI_Application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        // Thông tin kết nối
        String url = "jdbc:mysql://localhost:3306/root";
        String username = "root";
        String password = "Kingrain2210@";

        // Thiết lập kết nối
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}