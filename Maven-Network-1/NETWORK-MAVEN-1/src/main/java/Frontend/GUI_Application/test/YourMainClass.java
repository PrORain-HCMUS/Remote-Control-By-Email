package Frontend.GUI_Application.test;

import javax.swing.*;
import java.awt.*;

public class YourMainClass {
    public static void main(String[] args) {
        // Khởi tạo và hiển thị GUI
        JFrame frame = new JFrame("App TEST 1");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Thêm panel vào frame
        frame.getContentPane().add(new test2().panel);

        // Cài đặt kích thước và hiển thị frame
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null); // Đặt frame ở giữa màn hình
        frame.setVisible(true);
        // Đặt màu nền
        // panel.setBackground(Color.BLACK);  // hoặc sử dụng màu khác nếu bạn muốn
    }
}