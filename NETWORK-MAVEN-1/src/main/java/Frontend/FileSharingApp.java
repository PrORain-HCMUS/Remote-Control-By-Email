package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class FileSharingApp {
    private Map<String, String> users = new HashMap<>(); // Lưu trữ người dùng và mật khẩu

    private boolean isServer = false; // Biến để xác định vai trò máy chủ

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FileSharingApp().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("File Sharing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Tên người dùng:");
        JTextField nameField = new JTextField();
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Đăng nhập");
        JButton registerButton = new JButton("Đăng ký");

        JCheckBox serverCheckBox = new JCheckBox("Đóng vai trò máy chủ");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(serverCheckBox);
        panel.add(new JLabel()); // Dòng trống
        panel.add(loginButton);
        panel.add(registerButton);

        frame.add(panel);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameField.getText();
                char[] password = passwordField.getPassword();

                if (registerUser(username, new String(password))) {
                    JOptionPane.showMessageDialog(frame, "Đăng ký thành công!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Tên người dùng đã tồn tại!");
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameField.getText();
                char[] password = passwordField.getPassword();
                isServer = serverCheckBox.isSelected();

                if (authenticateUser(username, new String(password))) {
                    if (isServer) {
                        startServerFunctionality();
                    } else {
                        startClientFunctionality();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Xác thực thất bại!");
                }
            }
        });

        frame.setVisible(true);
    }

    private boolean registerUser(String username, String password) {
        // Kiểm tra xem tên người dùng đã tồn tại chưa
        if (!users.containsKey(username)) {
            // Lưu tên người dùng và mật khẩu
            users.put(username, password);
            return true;
        }
        return false;
    }

    private boolean authenticateUser(String username, String password) {
        // Xác thực người dùng
        if (users.containsKey(username)) {
            String storedPassword = users.get(username);
            return storedPassword.equals(password);
        }
        return false;
    }

    private void startServerFunctionality() {
        // Thực hiện chức năng máy chủ
        JOptionPane.showMessageDialog(null, "Đã đăng nhập với vai trò máy chủ!");
    }

    private void startClientFunctionality() {
        // Thực hiện chức năng máy khách
        JOptionPane.showMessageDialog(null, "Đã đăng nhập với vai trò máy khách!");
    }
}
