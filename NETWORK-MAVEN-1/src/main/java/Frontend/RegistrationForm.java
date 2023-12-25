package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationForm extends JDialog {
    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JTextField tfAddress;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    private JPanel registerPanel;

    public RegistrationForm(JFrame parent) {
        super(parent);
        setTitle("Create a new account");

        // Khởi tạo registerPanel và cài đặt GridBagLayout
        registerPanel = new JPanel(new GridBagLayout());

        // Khởi tạo các thành phần
        tfName = new JTextField(20);
        tfEmail = new JTextField(20);
        tfPhone = new JTextField(20);
        tfAddress = new JTextField(20);
        pfPassword = new JPasswordField(20);
        pfConfirmPassword = new JPasswordField(20);
        btnRegister = new JButton("Register");
        btnCancel = new JButton("Cancel");

        // Cài đặt action listener
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Cài đặt các thành phần vào registerPanel với GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        registerPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(tfName, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        registerPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(tfEmail, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        registerPanel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(tfPhone, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        registerPanel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(tfAddress, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        registerPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(pfPassword, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        registerPanel.add(new JLabel("Confirm Password:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(pfConfirmPassword, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Đặt gridwidth để các nút chiếm toàn bộ chiều rộng của một hàng
        gbc.anchor = GridBagConstraints.CENTER; // Đặt anchor để canh giữa
        gbc.insets = new Insets(10, 0, 0, 0); // Đặt khoảng cách từ nút đến các thành phần phía trên
        registerPanel.add(btnRegister, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(5, 0, 0, 0); // Đặt lại khoảng cách cho nút Cancel
        registerPanel.add(btnCancel, gbc);

        setContentPane(registerPanel);
        pack(); // Tự động điều chỉnh kích thước cửa sổ dựa trên nội dung
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void registerUser() {
        String name = tfName.getText();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String address = tfAddress.getText();
        String password = new String(pfPassword.getPassword());
        String confirmPassword = new String(pfConfirmPassword.getPassword());

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Confirm Password does not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean registrationSuccessful = addUserToDatabase(name, email, phone, address, password);

        if (registrationSuccessful) {
            JOptionPane.showMessageDialog(this, "Registration successful!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to register new user", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean addUserToDatabase(String name, String email, String phone, String address, String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/default", "dmmH2", "test123")) {
            String sql = "INSERT INTO users (name, email, phone, address, password) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, phone);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, password);

                int addedRows = preparedStatement.executeUpdate();
                return addedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationForm myForm = new RegistrationForm(null);
            myForm.setVisible(true);
        });
    }
}
