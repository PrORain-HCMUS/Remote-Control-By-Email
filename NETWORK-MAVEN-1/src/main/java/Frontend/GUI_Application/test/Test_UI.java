/*
 * Created by JFormDesigner on Fri Nov 24 15:31:10 ICT 2023
 */

package Frontend.GUI_Application.test;

import Functions.SendReceiveMail;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

import static org.apwj.bearburger.App.mainFrame;
import static org.apwj.bearburger.view.LoginPanel.recoveryFrame;
//import net.miginfocom.swing.*;

/**
 * @author Administrator
 */
public class Test_UI extends JPanel {
    public Test_UI() {
        initComponents();
    }

    private void implement_button_Clicked(ActionEvent e) {
        String senderEmail = textField1.getText();
        String appPassword = textField2.getText();
        String recipientEmail = textField3.getText();
        String orderTask = textField4.getText();
        String File = textField5.getText();

        // Gửi email nếu đủ thông tin
        if (!senderEmail.isEmpty() && !appPassword.isEmpty() && !recipientEmail.isEmpty() && !orderTask.isEmpty()) {
            if(Integer.parseInt(orderTask) != 7)
                SendReceiveMail.sendAndReceiveMail(senderEmail, appPassword, recipientEmail, orderTask);
            else if(Integer.parseInt(orderTask) == 7)
                SendReceiveMail.sendAndReceiveMail(senderEmail, appPassword, recipientEmail, "7 " + File);

        } else {
            JOptionPane.showMessageDialog(Test_UI.this, "Vui lòng nhập đủ thông tin trước khi thực hiện.");
        }
    }

    private void Client_button_Clicked(ActionEvent e) {
        Client_App client_screen = new Client_App();
        // Ẩn màn hình hiện tại
        recoveryFrame.setVisible(false);

        // Thiết lập nội dung của cửa sổ chính thành panel của Login_GUI và hiển thị cửa sổ mới
        mainFrame.setContentPane(client_screen);
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

    private void setDarkMode() {
        // Set dark mode styling similar to FlatOneDarkIJTheme
        Color background = new Color(43, 43, 43);  // Dark gray background
        Color foreground = new Color(187, 187, 187);  // Light gray foreground
        Color accentColor = new Color(104, 151, 187);  // Accent color

        this.setBackground(background);
        label2.setForeground(foreground);
        label5.setForeground(foreground);
        label6.setForeground(foreground);
        label7.setForeground(foreground);
        label8.setForeground(foreground);
        label9.setForeground(foreground);
        textField1.setBackground(background);
        textField1.setForeground(foreground);
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
        comboBox1.setBackground(background);
        comboBox1.setForeground(foreground);
        toggleButton1.setBackground(accentColor);
        toggleButton1.setForeground(background);
        toggleButton2.setBackground(accentColor);
        toggleButton2.setForeground(background);
        checkBox1.setBackground(background);
        checkBox1.setForeground(foreground);
    }

    private void setLightMode() {
        // TODO: Implement light mode styling
        this.setBackground(Color.WHITE);
        label2.setForeground(Color.BLACK);
        label5.setForeground(Color.BLACK);
        label6.setForeground(Color.BLACK);
        label7.setForeground(Color.BLACK);
        label8.setForeground(Color.BLACK);
        label9.setForeground(Color.BLACK);
        textField1.setBackground(Color.WHITE);
        textField1.setForeground(Color.BLACK);
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
        comboBox1.setBackground(Color.WHITE);
        comboBox1.setForeground(Color.BLACK);
        toggleButton1.setBackground(new Color(0xffff33));
        toggleButton1.setForeground(Color.BLACK);
        checkBox1.setBackground(Color.WHITE);
        checkBox1.setForeground(Color.BLACK);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test UI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new Test_UI());
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setVisible(true);
        });
    }

    private void comboBox1(ActionEvent e) {
        // Lấy chỉ số của item được chọn từ comboBox1
        int selectedIndex = comboBox1.getSelectedIndex();

        // Cập nhật nội dung của textField4 với chỉ số đã chọn
        textField4.setText(String.valueOf(selectedIndex+1));

        // Các đoạn mã hiện tại của bạn trong phương thức comboBox1 (nếu có)
        // TODO thêm đoạn mã của bạn ở đây nếu cần
    }

    private void browseButtonClicked(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            textField5.setText(selectedFile.getAbsolutePath());
        }
    }


    private void checkBox1ActionPerformed(ActionEvent e) {
        // Xác định trạng thái của checkBox1
        boolean isChecked = checkBox1.isSelected();

        // Nếu checkBox1 được tích, tự động điền thông tin vào textField1 và textField2
        if (isChecked) {
            textField3.setText("maytinhmang447@gmail.com");  // Thay bằng địa chỉ email mặc định của bạn
            //textField2.setText("ggat sxwp mrvx tlof");  // Thay bằng mật khẩu mặc định của bạn
        } else {
            textField3.setText("");  // Nếu không tích, có thể đặt lại giá trị thành rỗng hoặc giá trị khác tùy vào yêu cầu
            //textField2.setText("");
        }
    }

    public static String getClientContent() {
        return textField1.getText();
    }

    public static String getFileDemandedName() {
        return textField5.getText();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Vu Le Hoang
        label2 = new JLabel();
        label5 = new JLabel();
        textField1 = new JTextField();
        label6 = new JLabel();
        textField2 = new JTextField();
        label7 = new JLabel();
        textField3 = new JTextField();
        label8 = new JLabel();
        textField4 = new JTextField();
        button1 = new JButton();
        label15 = new JLabel();
        label16 = new JLabel();
        toggleButton1 = new JToggleButton();
        comboBox1 = new JComboBox<>();
        toggleButton2 = new JToggleButton();
        label9 = new JLabel();
        textField5 = new JTextField();
        button2 = new JButton();
        checkBox1 = new JCheckBox();

        //======== this ========
        setForeground(new Color(0xcccccc));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );

        //---- label2 ----
        label2.setText("  REMOTE CONTROL");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 36));

        //---- label5 ----
        label5.setText("Email Address:");
        label5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        //---- label6 ----
        label6.setText("App password:");
        label6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        //---- label7 ----
        label7.setText("Server Mail:");
        label7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        //---- label8 ----
        label8.setText("Order your task:");
        label8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        //---- button1 ----
        button1.setText("IMPLEMENT");
        button1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        button1.addActionListener(e -> implement_button_Clicked(e));

        //---- label15 ----
        label15.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive - VNU-HCMUS\\Desktop\\NOBGKHTN.png"));

        //---- label16 ----
        label16.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive - VNU-HCMUS\\Desktop\\NOBGKHTN.png"));

        //---- toggleButton1 ----
        toggleButton1.setText("SERVER");
        toggleButton1.setForeground(Color.black);
        toggleButton1.setBackground(new Color(0xffff33));
        toggleButton1.addActionListener(e -> Client_button_Clicked(e));

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "SHUTDOWN DESKTOP",
            "RESTART DESKTOP",
            "CANCEL 1 AND 2",
            "CHECK KEYLOGGING",
            "SCREENSHOT",
            "APPLICATIONS LIST",
            "SEND FILE VIA EMAIL"
        }));
        comboBox1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        comboBox1.addActionListener(e -> comboBox1(e));

        //---- toggleButton2 ----
        toggleButton2.setText("Dark Mode");
        toggleButton2.setForeground(Color.black);
        toggleButton2.setBackground(new Color(0x33ffcc));
        toggleButton2.addActionListener(e -> toggleButton2(e));

        //---- label9 ----
        label9.setText("File (task 7 only):");
        label9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        //---- button2 ----
        button2.setText("Browse file here");
        button2.addActionListener(e -> browseButtonClicked(e));

        //---- checkBox1 ----
        checkBox1.setText("Access to default Server");
        checkBox1.addActionListener(e -> checkBox1ActionPerformed(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label15, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(button1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(6, 6, 6))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textField3)
                                                .addComponent(textField2)
                                                .addComponent(textField4)
                                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
                            .addGap(59, 59, 59)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label16, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                .addComponent(toggleButton1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(toggleButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label16, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addGap(56, 56, 56)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                    .addGap(161, 161, 161))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(143, 143, 143)
                            .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(toggleButton2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32)
                    .addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Vu Le Hoang
    private JLabel label2;
    private JLabel label5;
    private static JTextField textField1;
    private JLabel label6;
    private JTextField textField2;
    private JLabel label7;
    private JTextField textField3;
    private JLabel label8;
    private JTextField textField4;
    private JButton button1;
    private JLabel label15;
    private JLabel label16;
    private JToggleButton toggleButton1;
    private JComboBox<String> comboBox1;
    private JToggleButton toggleButton2;
    private JLabel label9;
    private static JTextField textField5;
    private JButton button2;
    private JCheckBox checkBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
