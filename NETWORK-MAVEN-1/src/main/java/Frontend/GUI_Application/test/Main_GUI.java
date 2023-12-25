package Frontend.GUI_Application.test;

import Functions.SendReceiveMail;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import static org.apwj.bearburger.App.mainFrame;
import static org.apwj.bearburger.view.LoginPanel.recoveryFrame;

/**
 * @author Admin
 */
public class Main_GUI extends JPanel {
    public Main_GUI() {
        initComponents();
    }

    private void implement_button_Clicked(ActionEvent e) {
        String senderEmail = textField1.getText();
        String appPassword = textField2.getText();
        String recipientEmail = textField3.getText();
        String orderTask = textField4.getText();

        // Gửi email nếu đủ thông tin
        if (!senderEmail.isEmpty() && !appPassword.isEmpty() && !recipientEmail.isEmpty() && !orderTask.isEmpty()) {
            SendReceiveMail.sendAndReceiveMail(senderEmail, appPassword, recipientEmail, orderTask);

        } else {
            JOptionPane.showMessageDialog(Main_GUI.this, "Vui lòng nhập đủ thông tin trước khi thực hiện.");
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
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        toggleButton1 = new JToggleButton();

        //======== this ========
        setForeground(new Color(0xcccccc));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
        . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing
        .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
        Font ( "Dialo\u0067", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
        ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
        public void propertyChange (java . beans. PropertyChangeEvent e) { if( "borde\u0072" .equals ( e. getPropertyName (
        ) ) )throw new RuntimeException( ) ;} } );

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
        label7.setText("Objective Address:");
        label7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        //---- label8 ----
        label8.setText("Order your task:");
        label8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

        //---- button1 ----
        button1.setText("IMPLEMENT");
        button1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        button1.addActionListener(e -> implement_button_Clicked(e));

        //---- label9 ----
        label9.setText("1/ SHUTDOWN DESKTOP");
        label9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        label9.setForeground(new Color(0x3875ed));

        //---- label10 ----
        label10.setText("2/ RESTART DESKTOP");
        label10.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        label10.setForeground(new Color(0x3875ed));

        //---- label11 ----
        label11.setText("3/ CANCEL TASK 1 OR 2");
        label11.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        label11.setForeground(new Color(0x3875ed));

        //---- label12 ----
        label12.setText("4/ KEYLOGGING CHECK");
        label12.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        label12.setForeground(new Color(0x3875ed));

        //---- label13 ----
        label13.setText("5/ SELF SCREENSHOT ");
        label13.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        label13.setForeground(new Color(0x3875ed));

        //---- label14 ----
        label14.setText("6/ SEND FILE VIA EMAIL");
        label14.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        label14.setForeground(new Color(0x3875ed));

        //---- label15 ----
        label15.setIcon(new ImageIcon("C:\\Users\\CSM\\Desktop\\Maven-Network-1\\logokhtn1.png"));

        //---- label16 ----
        label16.setIcon(new ImageIcon("C:\\Users\\CSM\\Desktop\\Maven-Network-1\\logokhtn1.png"));

        //---- toggleButton1 ----
        toggleButton1.setText("CLIENT");
        toggleButton1.setForeground(Color.black);
        toggleButton1.setBackground(new Color(0xffff33));
        toggleButton1.addActionListener(e -> Client_button_Clicked(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label10, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(label11, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(label12, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(label13, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(label14, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(label9, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(label15, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label16, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(43, 43, 43)
                                                    .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(0, 27, Short.MAX_VALUE)))
                                    .addGap(20, 20, 20))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                                    .addGap(136, 235, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label16, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label14, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(18, 18, Short.MAX_VALUE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(toggleButton1, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                    .addGap(12, 12, 12))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Vu Le Hoang
    private JLabel label2;
    private JLabel label5;
    private JTextField textField1;
    private JLabel label6;
    private JTextField textField2;
    private JLabel label7;
    private JTextField textField3;
    private JLabel label8;
    private JTextField textField4;
    private JButton button1;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JToggleButton toggleButton1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}