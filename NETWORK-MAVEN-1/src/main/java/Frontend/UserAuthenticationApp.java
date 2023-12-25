package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAuthenticationApp {
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/default";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255), password VARCHAR(255))";
    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password) VALUES (?, ?)";

    public static void main(String[] args) {
        // Kết nối đến cơ sở dữ liệu và tạo bảng nếu chưa tồn tại
        try (Connection connection = DriverManager.getConnection(JDBC_URL, "user-test-1", "test123")) {
            connection.createStatement().executeUpdate(CREATE_TABLE_SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Tạo giao diện người dùng
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("User Authentication App");
            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2));

            JTextField usernameField = new JTextField();
            JPasswordField passwordField = new JPasswordField();
            JButton registerButton = new JButton("Register");
            JButton loginButton = new JButton("Login");

            // Xử lý sự kiện nút Register
            registerButton.addActionListener(e -> {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Thực hiện đăng ký người dùng vào cơ sở dữ liệu
                registerUser(username, password);
            });

            // Xử lý sự kiện nút Login
            loginButton.addActionListener(e -> {
                // Thực hiện xác thực người dùng (chưa implement trong ví dụ này)
                authenticateUser(usernameField.getText(), new String(passwordField.getPassword()));
            });

            // Thêm các thành phần vào panel
            panel.add(new JLabel("Username:"));
            panel.add(usernameField);
            panel.add(new JLabel("Password:"));
            panel.add(passwordField);
            panel.add(registerButton);
            panel.add(loginButton);

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    private static void registerUser(String username, String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, "user-test-1", "test123");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            preparedStatement.executeUpdate();
            System.out.println("User registered successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void authenticateUser(String username, String password) {
        // Thực hiện xác thực người dùng (có thể kiểm tra từ cơ sở dữ liệu)
        // Chưa được triển khai trong ví dụ này
        System.out.println("Authenticate user: " + username);
    }
}
