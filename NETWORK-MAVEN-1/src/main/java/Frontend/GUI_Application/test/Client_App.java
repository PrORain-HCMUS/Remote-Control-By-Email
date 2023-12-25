/*
 * Created by JFormDesigner on Thu Nov 23 14:51:14 ICT 2023
 */

package Frontend.GUI_Application.test;

import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;

import Functions.*;
//import net.miginfocom.swing.*;

import static org.apwj.bearburger.App.mainFrame;
import static org.apwj.bearburger.view.LoginPanel.recoveryFrame;
import java.io.File;


import Functions.Client_Service.*;
import Functions.SendFile.*;
import Functions.KeyLog.*;
import Functions.RunningApplications.*;

import Frontend.GUI_Application.test.Test_UI.*;
/**
 * @author Administrator
 */
public class Client_App extends JPanel {
    public Client_App() {
        initComponents();
    }

    public static String removeSpecialCharacters(String input) {
        // Sử dụng regular expression để xóa các ký tự số, khoảng trắng và ký tự đặc biệt
        String regex = "[^a-zA-Z]";
        String result = input.replaceAll(regex, "");
        return result;
    }

    public static String getParentDirectory(String filePath) {
        Path path = Paths.get(filePath);
        Path parent = path.getParent();
        if (parent != null) {
            return parent.toString();
        } else {
            return null; // Nếu không có thư mục cha (đang ở ổ đĩa gốc chẳng hạn)
        }
    }

    public static String getFileName(String filePath) {
        Path path = Paths.get(filePath);
        return path.getFileName().toString();
    }

    public static String keepFirstNCharacters(String input, int n) {
        if (input == null || input.length() <= n) {
            return input;
        }

        return input.substring(0, n);
    }

    private void implement_button_Clicked(ActionEvent e) {
        String server_email = textField2.getText();
        String app_Password = textField3.getText();

        // Gửi email nếu đủ thông tin
        if (!server_email.isEmpty() && !app_Password.isEmpty()) {
            String content = Client_Service.receiveLatestEmail(server_email, app_Password);
            String task = Client_Service.Task(keepFirstNCharacters(content,14));
            //

            int task_num = Integer.parseInt(keepFirstNCharacters(task,1));
            String task_dir = Client_Service.receiveLatestFor6(server_email, app_Password);

            final String default_Directory = "C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\NETWORK-MAVEN-1\\src\\main\\java\\resources\\Pictures";
            //final String clientEmail = "maytinhmang060@gmail.com";
            final String serverEmail = textField2.getText();
            final String default_subject = " ";
            final String default_body = "Test has been successfully done";
            final String client_appPassword = "lrtg ecbq ahxs abza";
            final String server_appPassword = textField3.getText(); //"ggat sxwp mrvx tlof"
            final String default_keylog_directory = "C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\NETWORK-MAVEN-1\\src\\main\\java\\resources\\KeyLog\\";
            //final String default_folder = "C:\\\\Users\\Administrator\\Desktop\\New folder";
            final String clientEmail = Test_UI.getClientContent();



            switch(task_num){
                case 1:
                    // This case ensures performing shutdown function after 10 mins
                    SystemControl.performShutdown(3600);
                    JOptionPane.showMessageDialog(null, "Task 1 has been successfully done!");
                    // done
                    break;
                case 2:
                    // This case ensures performing restart function after 10 mins
                    SystemControl.performRestart(3600);
                    JOptionPane.showMessageDialog(null, "Task 2 has been successfully done!");
                    // done
                    break;
                case 3:
                    // This case ensures cancelling both tasks above
                    SystemControl.cancelShutdown();
                    JOptionPane.showMessageDialog(null, "Task 3 has been successfully done!");
                    // done
                    break;
                case 4:
                    // This case ensures checking keylog
                    KeyLog keyLogger = new KeyLog();
                    keyLogger.setSize(300, 200);
                    keyLogger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    // Thiết lập một callback để thực thi sau khi keylogger hoàn thành việc ghi log
                    keyLogger.setCallback(() -> {
                        // Mã để gửi email với tệp đính kèm
                        SendFile.sendEmailWithAttachment(serverEmail, clientEmail, default_subject, default_body, default_keylog_directory, "keylog.txt", serverEmail, server_appPassword);
                        JOptionPane.showMessageDialog(null, "Task 4 has been successfully done!");
                    });

                    keyLogger.setVisible(true);
                    keyLogger.startLogging();

                    // done
                    break;
                case 5:
                    // This case ensures Screenshot - Capturing and sending via email
                    Screenshot.captureScreen(default_Directory, "screenshot");
                    SendFile.sendEmailWithAttachment(serverEmail, clientEmail, default_subject, default_body, default_Directory, "screenshot", serverEmail, server_appPassword);
                    JOptionPane.showMessageDialog(null, "Task 5 has been successfully done!");


                    // done
                    break;
                case 6:
                    // This case ensures sending currently-running applications of server
                    //RunningApplications.getRunningApplications();
                    String app_list_directory =  RunningApplications.getFilePathFromUser();
                    String app_list_file = RunningApplications.getFileNameFromPath(app_list_directory);
                    JOptionPane.showMessageDialog(null, "Task 6 has been successfully done!");
                    SendFile.sendEmailWithAttachment(serverEmail, clientEmail, default_subject, default_body, "C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\NETWORK-MAVEN-1\\src\\main\\java\\resources\\App List", "running_applications.txt", serverEmail, server_appPassword);
                    System.out.println(getParentDirectory(app_list_file));
                    System.out.println(getFileName(app_list_file));


                    // done
                    break;

                case 7:
                    // This case ensures only Sending Files via email
                    System.out.println(content);
                    System.out.println(task);
                    System.out.println(task_dir);


                    // Loại bỏ khoảng trắng ở đầu và cuối đường dẫn
                    task_dir = task_dir.trim();

                    SendFile.sendEmailWithAttachment(
                            serverEmail,
                            clientEmail,
                            default_subject,
                            default_body,
                            getParentDirectory(task_dir),
                            getFileName(task_dir),
                            serverEmail,
                            server_appPassword
                    );

                    break;

                    // done


            }


        } else {
            JOptionPane.showMessageDialog(Client_App.this, "Vui lòng nhập đủ thông tin trước khi thực hiện.");
        }
    }

    private void Server_button_Clicked(ActionEvent e) {
        // Main_GUI Server_screen = new Main_GUI();
            Test_UI Server_screen = new Test_UI();
        recoveryFrame.setVisible(false);

        // Thiết lập nội dung của cửa sổ chính thành panel của Server và hiển thị cửa sổ mới
        mainFrame.setContentPane(Server_screen);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void toggleButton2(ActionEvent e) {
        // TODO add your code here
        if (toggleButton2.isSelected()) {
            // Dark Mode
            setDarkMode();
        } else {
            // Light Mode
            setLightMode();
        }
    }

    private void checkBox2ActionPerformed(ActionEvent e) {
        // Xác định trạng thái của checkBox1
        boolean isChecked = checkBox2.isSelected();

        // Nếu checkBox1 được tích, tự động điền thông tin vào textField1 và textField2
        if (isChecked) {
            textField4.setText("127.0.0.1:55142");  // Thay bằng địa chỉ email mặc định của bạn
            textField2.setText("maytinhmang447@gmail.com");
            textField3.setText("ggat sxwp mrvx tlof");// Thay bằng mật khẩu mặc định của bạn
            textField5.setText(Test_UI.getFileDemandedName());
        } else {
            textField4.setText("");  // Nếu không tích, có thể đặt lại giá trị thành rỗng hoặc giá trị khác tùy vào yêu cầu
            textField2.setText("");
            textField3.setText("");
            textField5.setText("");


        }
    }

    private void comboBox1(ActionEvent e) {
        // TODO add your code here
    }

    private void setDarkMode() {
        // Set dark mode styling similar to FlatOneDarkIJTheme
        Color background = new Color(43, 43, 43);  // Dark gray background
        Color foreground = new Color(187, 187, 187);  // Light gray foreground
        Color accentColor = new Color(104, 151, 187);  // Accent color

        this.setBackground(background);
        label2.setForeground(foreground);

        label6.setForeground(foreground);
        label7.setForeground(foreground);
        label8.setForeground(foreground);
        label9.setForeground(foreground);

        textField2.setBackground(background);
        textField2.setForeground(foreground);
        textField3.setBackground(background);
        textField3.setForeground(foreground);
        textField4.setBackground(background);
        textField4.setForeground(foreground);
        textField5.setBackground(background);
        textField5.setForeground(foreground);

        button1.setBackground(background);
        button1.setForeground(foreground);
        button2.setBackground(background);
        button2.setForeground(foreground);

        checkBox1.setBackground(background);
        checkBox1.setForeground(foreground);
        checkBox2.setBackground(background);
        checkBox2.setForeground(foreground);

        toggleButton1.setBackground(accentColor);
        toggleButton1.setForeground(background);
    }


    private void setLightMode() {
        // TODO: Implement light mode styling
        this.setBackground(Color.WHITE);
        label2.setForeground(Color.BLACK);

        label6.setForeground(Color.BLACK);
        label7.setForeground(Color.BLACK);
        label8.setForeground(Color.BLACK);
        label9.setForeground(Color.BLACK);

        textField2.setBackground(Color.WHITE);
        textField2.setForeground(Color.BLACK);
        textField3.setBackground(Color.WHITE);
        textField3.setForeground(Color.BLACK);
        textField4.setBackground(Color.WHITE);
        textField4.setForeground(Color.BLACK);
        textField5.setBackground(Color.WHITE);
        textField5.setForeground(Color.BLACK);

        button1.setBackground(Color.WHITE);
        button1.setForeground(Color.BLACK);
        button2.setBackground(Color.WHITE);
        button2.setForeground(Color.BLACK);

        checkBox1.setBackground(Color.WHITE);
        checkBox1.setForeground(Color.BLACK);
        checkBox2.setBackground(Color.WHITE);
        checkBox2.setForeground(Color.BLACK);

        toggleButton1.setBackground(new Color(0xffff33));
        toggleButton1.setForeground(Color.BLACK);
    }

    // Thêm sự kiện cho button2
    private void button2(ActionEvent e) {
        button2ActionPerformed(e);
    }

    private void button2ActionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        // Thiết lập chỉ chọn file, không chọn thư mục
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Hiển thị hộp thoại chọn file và kiểm tra nếu người dùng đã chọn file
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn của file được chọn
            File selectedFile = fileChooser.getSelectedFile();

            // Hiển thị đường dẫn file trên textField5
            textField5.setText(selectedFile.getAbsolutePath());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Vu Le Hoang
        label2 = new JLabel();
        label6 = new JLabel();
        textField2 = new JTextField();
        label7 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();
        label15 = new JLabel();
        label16 = new JLabel();
        toggleButton1 = new JToggleButton();
        checkBox1 = new JCheckBox();
        toggleButton2 = new JToggleButton();
        label8 = new JLabel();
        textField4 = new JTextField();
        checkBox2 = new JCheckBox();
        button2 = new JButton();
        label9 = new JLabel();
        textField5 = new JTextField();

        //======== this ========
        setForeground(new Color(0xcccccc));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label2 ----
        label2.setText("  REMOTE CONTROL");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 36));

        //---- label6 ----
        label6.setText("Server's Recipient Email:");
        label6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        //---- label7 ----
        label7.setText("App password:");
        label7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        //---- button1 ----
        button1.setText("IMPLEMENT");
        button1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        button1.addActionListener(e -> implement_button_Clicked(e));

        //---- label15 ----
        label15.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive - VNU-HCMUS\\Desktop\\NOBGKHTN.png"));

        //---- label16 ----
        label16.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive - VNU-HCMUS\\Desktop\\NOBGKHTN.png"));

        //---- toggleButton1 ----
        toggleButton1.setText("CLIENT");
        toggleButton1.setForeground(Color.black);
        toggleButton1.setBackground(new Color(0x00cccc));
        toggleButton1.addActionListener(e -> Server_button_Clicked(e));

        //---- checkBox1 ----
        checkBox1.setText("Accept Client's accessment to services");

        //---- toggleButton2 ----
        toggleButton2.setText("Dark Mode");
        toggleButton2.setForeground(Color.black);
        toggleButton2.setBackground(new Color(0x33ffcc));
        toggleButton2.addActionListener(e -> toggleButton2(e));

        //---- label8 ----
        label8.setText("Server's IP and port connected:");
        label8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        //---- checkBox2 ----
        checkBox2.setText("Auto-fill Server's informations");
        checkBox2.addActionListener(e -> checkBox2ActionPerformed(e));

        //---- button2 ----
        button2.setText("BROWSE FILE");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- label9 ----
        label9.setText("   File demanded:");
        label9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label15, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addComponent(label9, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addComponent(textField5, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(toggleButton2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
                                            .addGap(120, 120, 120)
                                            .addComponent(label16, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                            .addGap(43, 43, 43)
                                            .addComponent(toggleButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(checkBox1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addGap(20, 20, 20))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(checkBox2, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label15, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label16, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(toggleButton2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(checkBox2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Vu Le Hoang
    private JLabel label2;
    private JLabel label6;
    private JTextField textField2;
    private JLabel label7;
    private JTextField textField3;
    private JButton button1;
    private JLabel label15;
    private JLabel label16;
    private JToggleButton toggleButton1;
    private JCheckBox checkBox1;
    private JToggleButton toggleButton2;
    private JLabel label8;
    private JTextField textField4;
    private JCheckBox checkBox2;
    private JButton button2;
    private JLabel label9;
    private JTextField textField5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
