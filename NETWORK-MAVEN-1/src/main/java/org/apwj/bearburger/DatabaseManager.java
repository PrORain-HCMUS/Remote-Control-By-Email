package STOLEN;

import java.sql.*;

public class DatabaseManager {
    private Connection connection;
    public Connection getConnection() {
        return this.connection;
    }

    private static final String DB_URL = "jdbc:h2:tcp://localhost:9092/default";
    private static final String USER = "user-test-1";
    private static final String PASSWORD = "test123";

    public DatabaseManager() {
        connect();
        createTable(); // Gọi phương thức tạo bảng ngay sau khi kết nối
    }

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void createTable() {
        try (Statement stmt = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(255) NOT NULL UNIQUE," +
                    "password VARCHAR(255) NOT NULL)";
            stmt.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean registerUser(String username, String password) {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO users(username, password) VALUES (?, ?)")) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Kiểm tra lỗi để xác định liệu lỗi là do tên người dùng đã tồn tại hay không
            if (e.getErrorCode() == 1062) {
                System.out.println("Tên người dùng đã tồn tại!");
            } else {
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean authenticateUser(String username, String password) {
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            return resultSet.next(); // Nếu có kết quả, xác thực thành công
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Các phương thức khác tùy thuộc vào yêu cầu cụ thể
}