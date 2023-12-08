/*
 * Created by JFormDesigner on Tue Dec 05 08:49:19 ICT 2023
 */

package Frontend.GUI_Application.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import net.miginfocom.swing.*;

import static org.apwj.bearburger.App.mainFrame;
import static org.apwj.bearburger.view.LoginPanel.recoveryFrame;

/**
 * @author Administrator
 */
public class Client_Test_UI extends JPanel {
    public Client_Test_UI() {
        initComponents();
    }

    private void implement_button_Clicked(ActionEvent e) {
        // TODO add your code here
    }

    private void Server_button_Clicked(ActionEvent e) {
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

    private void comboBox1(ActionEvent e) {
        // TODO add your code here
    }

    private void setDarkMode() {
        // TODO: Implement dark mode styling
        this.setBackground(Color.BLACK);
        label2.setForeground(Color.WHITE);

        label6.setForeground(Color.WHITE);
        label7.setForeground(Color.WHITE);

        textField2.setBackground(Color.DARK_GRAY);
        textField2.setForeground(Color.WHITE);
        textField3.setBackground(Color.DARK_GRAY);
        textField3.setForeground(Color.WHITE);

        button1.setBackground(Color.DARK_GRAY);
        button1.setForeground(Color.WHITE);
        comboBox1.setBackground(Color.DARK_GRAY);
        comboBox1.setForeground(Color.WHITE);
        toggleButton1.setBackground(Color.DARK_GRAY);
        toggleButton1.setForeground(Color.WHITE);
    }

    private void setLightMode() {
        // TODO: Implement light mode styling
        this.setBackground(Color.WHITE);
        label2.setForeground(Color.BLACK);

        label6.setForeground(Color.BLACK);
        label7.setForeground(Color.BLACK);

        textField2.setBackground(Color.WHITE);
        textField2.setForeground(Color.BLACK);
        textField3.setBackground(Color.WHITE);
        textField3.setForeground(Color.BLACK);

        button1.setBackground(Color.WHITE);
        button1.setForeground(Color.BLACK);
        comboBox1.setBackground(Color.WHITE);
        comboBox1.setForeground(Color.BLACK);
        toggleButton1.setBackground(new Color(0xffff33));
        toggleButton1.setForeground(Color.BLACK);
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Client Test UI");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Client_Test_UI());
                frame.pack();
                frame.setLocationRelativeTo(null); // Đưa frame vào giữa màn hình
                frame.setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Vu Le Hoang
        this2 = new JPanel();
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
        comboBox1 = new JComboBox<>();

        //======== this2 ========
        {
            this2.setForeground(new Color(0xcccccc));
            this2.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,this2. getBorder () ) ); this2. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- label2 ----
            label2.setText("  REMOTE CONTROL");
            label2.setFont(new Font("Segoe UI", Font.BOLD, 36));

            //---- label6 ----
            label6.setText("Client Email:");
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
            toggleButton1.setText("SERVER");
            toggleButton1.setForeground(Color.black);
            toggleButton1.setBackground(new Color(0x00cccc));
            toggleButton1.addActionListener(e -> Server_button_Clicked(e));

            //---- checkBox1 ----
            checkBox1.setText("Accept to give permission to Server");

            //---- toggleButton2 ----
            toggleButton2.setText("Dark Mode");
            toggleButton2.setForeground(Color.black);
            toggleButton2.setBackground(new Color(0x33ffcc));
            toggleButton2.addActionListener(e -> toggleButton2(e));

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "SHUTDOWN DESKTOP",
                "RESTART DESKTOP",
                "CANCEL 1 AND 2",
                "CHECK KEYLOGGING",
                "SCREENSHOT",
                "SEND FILE VIA EMAIL"
            }));
            comboBox1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
            comboBox1.addActionListener(e -> comboBox1(e));

            GroupLayout this2Layout = new GroupLayout(this2);
            this2.setLayout(this2Layout);
            this2Layout.setHorizontalGroup(
                this2Layout.createParallelGroup()
                    .addGroup(this2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(this2Layout.createParallelGroup()
                            .addGroup(this2Layout.createSequentialGroup()
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(this2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(label16, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.LEADING, this2Layout.createSequentialGroup()
                                        .addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(GroupLayout.Alignment.LEADING, this2Layout.createSequentialGroup()
                                                .addGroup(this2Layout.createParallelGroup()
                                                    .addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                                        .addComponent(checkBox1, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                                        .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
                                                .addGap(43, 43, 43)
                                                .addGroup(this2Layout.createParallelGroup()
                                                    .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(toggleButton2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(20, 20, 20))
                            .addGroup(this2Layout.createSequentialGroup()
                                .addComponent(label15, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
            );
            this2Layout.setVerticalGroup(
                this2Layout.createParallelGroup()
                    .addGroup(this2Layout.createSequentialGroup()
                        .addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label16, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGroup(this2Layout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addComponent(label15, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                        .addGroup(this2Layout.createParallelGroup()
                            .addGroup(this2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                .addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(this2Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(toggleButton2, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                                .addGap(170, 170, 170))))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Vu Le Hoang
    private JPanel this2;
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
    private JComboBox<String> comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
