/*
 * Created by JFormDesigner on Tue Nov 07 05:18:51 ICT 2023
 */

package Frontend.GUI_Application.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import org.apwj.bearburger.dao.UserDao;
import org.apwj.bearburger.domain.User;
import org.apwj.bearburger.view.RegistrationPanel;
import org.apwj.bearburger.view.admin.AdminPanel;
import org.apwj.bearburger.view.customer.BrowseFoodsPanel;
import org.apwj.bearburger.view.customer.HomePanel;
import org.apwj.bearburger.view.customer.RecoveryPanel;
import Frontend.GUI_Application.data.User_SQL;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import static org.apwj.bearburger.App.mainFrame;
import static org.apwj.bearburger.view.DialogueBox.dialogueBox;
import static org.apwj.bearburger.view.customer.HomePanel.subHomePanel;
import Frontend.GUI_Application.test.Test_UI;

/**
 * @author Admin
 */
public class Login_GUI extends JPanel {


    public static JFrame recoveryFrame = new JFrame(String.valueOf(FlatOneDarkIJTheme.setup()));
    // cái này để set theme FlatOneDarkIJTheme cho màn hình giao diện

    //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    //User_SQL userSQL = applicationContext.getBean("userDao", User_SQL.class);

    public Login_GUI() {
        initComponents();
    }



    private void registerMouseClicked(MouseEvent e) {
        test2 registrationPanel = new test2();
        mainFrame.setContentPane(registrationPanel.panel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private String getAccountPassword(String username, String email) {
        String csvFile = "C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\NETWORK-MAVEN-1\\src\\main\\java\\Frontend\\GUI_Application\\databaseusers.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String storedUsername = data[0].replaceAll("^\"|\"$", ""); // Loại bỏ dấu ngoặc kép nếu có
                String storedEmail = data[1].replaceAll("^\"|\"$", ""); // Loại bỏ dấu ngoặc kép nếu có
                String storedPassword = data[2].replaceAll("^\"|\"$", ""); // Loại bỏ dấu ngoặc kép nếu có

                // Kiểm tra thông tin đăng nhập
                if (username.equals(storedUsername) && email.equals(storedEmail)) {
                    return storedPassword; // Trả về mật khẩu nếu tìm thấy thông tin đúng
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null; // Trả về null nếu không tìm thấy thông tin tài khoản hoặc email không khớp
    }

    private void forgotPasswordMouseClicked(MouseEvent e) {

//        dialogueBox("Quên mật khẩu rồi thì tạo tài khoản khác dùng nhé!"
//        + "Xin lỗi vì sự bất tiện");
//

        // Hiển thị hộp thoại để nhập thông tin
        String username = JOptionPane.showInputDialog(this, "Nhập tên tài khoản:");
        String email = JOptionPane.showInputDialog(this, "Nhập địa chỉ email:");

        if (username != null && email != null) {
            // Lấy mật khẩu từ file
            String password = getAccountPassword(username, email);

            if (password != null) {
                dialogueBox("Mật khẩu của bạn là: " + password);
            } else {
                dialogueBox("Không tìm thấy thông tin tài khoản hoặc email không khớp");
            }
        }
    }



    private boolean checkAccountInfo(String username, String email) {
        String csvFile = "C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\NETWORK-MAVEN-1\\src\\main\\java\\Frontend\\GUI_Application\\databaseusers.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String storedUsername = data[0].replaceAll("^\"|\"$", ""); // Loại bỏ dấu ngoặc kép nếu có
                String storedEmail = data[1].replaceAll("^\"|\"$", ""); // Loại bỏ dấu ngoặc kép nếu có

                // Kiểm tra thông tin đăng nhập
                if (username.equals(storedUsername) && email.equals(storedEmail)) {
                    return true; // Đúng thông tin đăng nhập
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false; // Sai thông tin đăng nhập
    }



    private void loginButton(ActionEvent e) {
        String username = usernameTF.getText().trim();
        String password = String.valueOf(passwordTF.getPassword());

        if (!username.isEmpty() && !password.isEmpty()) {
            // Kiểm tra thông tin đăng nhập
            if (checkLogin(username, password)) {
                dialogueBox("Chào mừng đăng nhập vào APP Remote Control PC, " + username.toUpperCase());

                // Chuyển sang màn hình Main_GUI và ẩn màn hình Login_GUI
                Test_UI Main_GUI = new Test_UI();
                mainFrame.setContentPane(Main_GUI);
                mainFrame.pack();
                mainFrame.setVisible(true);

                // Ẩn màn hình Login_GUI
                setVisible(false);
            } else {
                dialogueBox("Thông tin đăng nhập không đúng");
            }
        } else {
            dialogueBox("Điền đẩy đủ thông tin giùm cái");
        }
    }


    public boolean checkLogin(String username, String password) {
        String csvFile = "C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\NETWORK-MAVEN-1\\src\\main\\java\\Frontend\\GUI_Application\\databaseusers.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String storedUsername = data[0].replaceAll("^\"|\"$", ""); // Loại bỏ dấu ngoặc kép nếu có
                String storedPassword = data[2].replaceAll("^\"|\"$", ""); // Loại bỏ dấu ngoặc kép nếu có

                // In ra giá trị storedUsername và storedPassword để kiểm tra
                System.out.println("Stored Username: " + storedUsername);
                System.out.println("Stored Password: " + storedPassword);

                // Kiểm tra thông tin đăng nhập
                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return true; // Đúng thông tin đăng nhập
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Sai thông tin đăng nhập
    }






    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Vu Le Hoang
        panel = new JPanel();
        usernameTF = new JTextField();
        label1 = new JLabel();
        loginButton = new JButton();
        register = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        forgotPassword = new JLabel();
        label5 = new JLabel();
        passwordTF = new JPasswordField();
        label4 = new JLabel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
        .EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax
        .swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,
        12),java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans
        .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.
        getPropertyName()))throw new RuntimeException();}});

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGap(0, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGap(0, 510, Short.MAX_VALUE)
        );

        //======== panel ========
        {
            panel.setMaximumSize(new Dimension(1025, 575));
            panel.setMinimumSize(new Dimension(1025, 575));
            panel.setPreferredSize(new Dimension(1025, 575));
            panel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font
            .BOLD,12),java.awt.Color.red),panel. getBorder()));panel. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r"
            .equals(e.getPropertyName()))throw new RuntimeException();}});

            //---- usernameTF ----
            usernameTF.setFont(new Font("Segoe UI", Font.PLAIN, 20));

            //---- label1 ----
            label1.setText("Welcome!");
            label1.setFont(new Font("Segoe UI", Font.BOLD, 45));

            //---- loginButton ----
            loginButton.setText("Login");
            loginButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
            loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            loginButton.addActionListener(e -> loginButton(e));

            //---- register ----
            register.setText("Create an Account");
            register.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
            register.setForeground(new Color(0x3875ed));
            register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            register.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    registerMouseClicked(e);
                }
            });

            //---- label2 ----
            label2.setText(" Username");
            label2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));

            //---- label3 ----
            label3.setText(" Password");
            label3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));

            //---- forgotPassword ----
            forgotPassword.setText(" Forgot your password?");
            forgotPassword.setForeground(new Color(0x3875ed));
            forgotPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
            forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            forgotPassword.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    forgotPasswordMouseClicked(e);
                }
            });

            //---- label5 ----
            label5.setText("New here?");
            label5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));

            //---- passwordTF ----
            passwordTF.setFont(new Font("Segoe UI", Font.PLAIN, 20));

            //---- label4 ----
            label4.setIcon(new ImageIcon("C:\\Users\\Phuon\\OneDrive\\M\u00e1y t\u00ednh\\Maven-Network-1\\NETWORK-MAVEN-1\\logokhtn1.png"));

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createParallelGroup()
                                .addComponent(loginButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(register)))
                            .addComponent(label3)
                            .addComponent(forgotPassword)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(panelLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup()
                                        .addComponent(usernameTF, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addComponent(label1)
                                        .addGap(47, 47, 47))))
                            .addComponent(passwordTF, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112))
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(label1)
                                .addGap(35, 35, 35)
                                .addComponent(label2)
                                .addGap(3, 3, 3)
                                .addComponent(usernameTF, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(forgotPassword)
                                .addGap(56, 56, 56)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(register)
                                    .addComponent(label5)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(46, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Vu Le Hoang
    public JPanel panel;
    private JTextField usernameTF;
    private JLabel label1;
    private JButton loginButton;
    private JLabel register;
    private JLabel label2;
    private JLabel label3;
    private JLabel forgotPassword;
    private JLabel label5;
    private JPasswordField passwordTF;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
