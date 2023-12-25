/*
 * Created by JFormDesigner on Mon Nov 06 05:06:55 ICT 2023
 */

package Frontend.GUI_Application.test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.exceptions.CsvValidationException;
import org.apwj.bearburger.dao.UserDao;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import Frontend.GUI_Application.data.User_SQL;
//import org.apwj.bearburger.view.LoginPanel;
import Frontend.GUI_Application.test.Login_GUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import static org.apwj.bearburger.App.mainFrame;
import static org.apwj.bearburger.view.DialogueBox.dialogueBox;

/**
 * @author Admin
 */
public class test2 extends JPanel {

    public static JFrame recoveryFrame = new JFrame(String.valueOf(FlatOneDarkIJTheme.setup()));
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
    //User_SQL userSql = applicationContext.getBean("userDao", User_SQL.class);
    private String selectedGender = null;
    public test2() {

        initComponents();

        ButtonGroup genders = new ButtonGroup();
        genders.add(maleRadioButton);
        genders.add(femaleRadioButton);
        genders.add(otherRadioButton);

        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedGender = maleRadioButton.getText();
            }
        });

        femaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedGender = femaleRadioButton.getText();
            }
        });

        otherRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedGender = otherRadioButton.getText();
            }
        });

    }

    private void loginLabelMouseClicked(MouseEvent e) {
        // Đoạn này nghĩa là khi LoginLabel được nhận diện có nhấp chuột vào, sẽ chuyển màn hình giao diện sang LoginPanel mới
        Login_GUI loginPanel = new Login_GUI();

        // Ẩn màn hình hiện tại
        recoveryFrame.setVisible(false);

        // Thiết lập nội dung của cửa sổ chính thành panel của Login_GUI và hiển thị cửa sổ mới
        mainFrame.setContentPane(loginPanel.panel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private boolean isEmailValid(String email) {
        // Kiểm tra định dạng của email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private boolean isUserExists(String username, String email) {
        // Đường dẫn thư mục lưu file CSV
        String directoryPath = "C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\NETWORK-MAVEN-1\\src\\main\\java\\Frontend\\GUI_Application\\database";

        try (CSVReader reader = new CSVReader(new FileReader(directoryPath + "users.csv"))) {
            String[] nextLine;
            while (true) {
                try {
                    if ((nextLine = reader.readNext()) == null) {
                        break;
                    }
                } catch (CsvValidationException e) {
                    e.printStackTrace();
                    System.err.println("Error validating CSV file: " + e.getMessage());
                    // Xử lý lỗi khi đọc CSV
                    return false;
                }

                if (nextLine.length > 1 && (nextLine[0].equals(username) || nextLine[1].equals(email))) {
                    return true; // Người dùng hoặc email đã tồn tại
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        return false; // Người dùng không tồn tại
    }

    private void register(ActionEvent e) {
        String username = usernameTF.getText().trim();
        String email = emailTF.getText().trim();
        String password = String.valueOf(passwordTF.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordTF.getPassword());

        if (!username.isEmpty() && !email.isEmpty() && isEmailValid(email) && password.equals(confirmPassword)) {
            if (!isUserExists(username, email)) {
                // Đường dẫn thư mục lưu file CSV
                String directoryPath = "C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\NETWORK-MAVEN-1\\src\\main\\java\\Frontend\\GUI_Application\\database";

                // Ghi thông tin người dùng vào file CSV
                try (CSVWriter writer = new CSVWriter(new FileWriter(directoryPath + "users.csv", true))) {
                    String[] record = {username, email, password, selectedGender};
                    writer.writeNext(record);
                    writer.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.err.println("Error writing to CSV file: " + ex.getMessage());
                }

                // Hiển thị thông báo và reset các trường dữ liệu
                dialogueBox("Registration Successful");
                resetFields();
            } else {
                // Hiển thị thông báo nếu người dùng hoặc email đã tồn tại
                dialogueBox("User or email already exists.");
            }
        } else {
            // Hiển thị thông báo nếu dữ liệu không hợp lệ
            dialogueBox("Fill out all the fields properly.");
        }
    }

    // Hàm để reset các trường dữ liệu sau khi đăng ký thành công
    private void resetFields() {
        usernameTF.setText("");
        emailTF.setText("");
        passwordTF.setText("");
        confirmPasswordTF.setText("");
        selectedGender = null;
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
        otherRadioButton.setSelected(false);
    }


    private void registerMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Vu Le Hoang
        panel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        usernameTF = new JTextField();
        label3 = new JLabel();
        passwordTF = new JPasswordField();
        registerButton = new JButton();
        label5 = new JLabel();
        loginLabel = new JLabel();
        label4 = new JLabel();
        label6 = new JLabel();
        emailTF = new JTextField();
        confirmPasswordTF = new JPasswordField();
        label8 = new JLabel();
        label7 = new JLabel();
        maleRadioButton = new JRadioButton();
        femaleRadioButton = new JRadioButton();
        otherRadioButton = new JRadioButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
        javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax
        . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
        . awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .
        PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .
        equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGap(0, 300, Short.MAX_VALUE)
        );

        //======== panel ========
        {
            panel.setMaximumSize(new Dimension(1025, 575));
            panel.setPreferredSize(new Dimension(1025, 575));
            panel.setMinimumSize(new Dimension(1025, 575));
            panel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel. getBorder
            ( )) ); panel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );

            //---- label1 ----
            label1.setText("Create an Account");
            label1.setFont(new Font("Segoe UI", Font.BOLD, 45));

            //---- label2 ----
            label2.setText("Username");
            label2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- usernameTF ----
            usernameTF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- label3 ----
            label3.setText("Password");
            label3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- passwordTF ----
            passwordTF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- registerButton ----
            registerButton.setText("Register");
            registerButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
            registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            registerButton.addActionListener(e -> register(e));

            //---- label5 ----
            label5.setText("Already have an account?");
            label5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));

            //---- loginLabel ----
            loginLabel.setText("Login");
            loginLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
            loginLabel.setForeground(new Color(0x3875ed));
            loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            loginLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    registerMouseClicked(e);
                    loginLabelMouseClicked(e);
                }
            });

            //---- label4 ----
            label4.setText("Email");
            label4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- label6 ----
            label6.setText("Confirm Password");
            label6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- emailTF ----
            emailTF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- confirmPasswordTF ----
            confirmPasswordTF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- label8 ----
            label8.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\logokhtn1.png"));

            //---- label7 ----
            label7.setText("Gender");
            label7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- maleRadioButton ----
            maleRadioButton.setText("Male");
            maleRadioButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- femaleRadioButton ----
            femaleRadioButton.setText("Female");
            femaleRadioButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- otherRadioButton ----
            otherRadioButton.setText("Other");
            otherRadioButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(label1)
                                .addGap(106, 106, 106))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup()
                                            .addComponent(label4)
                                            .addComponent(label2)
                                            .addComponent(label3)
                                            .addComponent(label6))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelLayout.createParallelGroup()
                                            .addComponent(emailTF)
                                            .addComponent(passwordTF)
                                            .addComponent(usernameTF, GroupLayout.Alignment.TRAILING)
                                            .addComponent(confirmPasswordTF)))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(label7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(maleRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(femaleRadioButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(otherRadioButton))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(panelLayout.createParallelGroup()
                                            .addComponent(registerButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(label5)
                                                .addGap(6, 6, 6)
                                                .addComponent(loginLabel)
                                                .addGap(109, 109, 109)))))
                                .addContainerGap())))
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(label1)
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(usernameTF))
                                .addGap(6, 6, 6)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailTF)
                                    .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmPasswordTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(otherRadioButton)
                                    .addComponent(femaleRadioButton)
                                    .addComponent(maleRadioButton)
                                    .addComponent(label7))
                                .addGap(32, 32, 32)
                                .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panelLayout.createParallelGroup()
                            .addComponent(label5)
                            .addComponent(loginLabel))
                        .addContainerGap(61, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Vu Le Hoang
    public JPanel panel;
    private JLabel label1;
    private JLabel label2;
    private JTextField usernameTF;
    private JLabel label3;
    private JPasswordField passwordTF;
    private JButton registerButton;
    private JLabel label5;
    private JLabel loginLabel;
    private JLabel label4;
    private JLabel label6;
    private JTextField emailTF;
    private JPasswordField confirmPasswordTF;
    private JLabel label8;
    private JLabel label7;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton otherRadioButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
