/*
 * Created by JFormDesigner on Mon Nov 06 04:50:36 ICT 2023
 */

package Frontend.GUI_Application.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Admin
 */
public class test1  {

    private void register(ActionEvent e) {
        // TODO add your code here
    }

    private void registerMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void loginLabelMouseClicked(MouseEvent e) {
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
        label9 = new JLabel();
        phoneTF = new JTextField();
        label7 = new JLabel();
        maleRadioButton = new JRadioButton();
        femaleRadioButton = new JRadioButton();
        otherRadioButton = new JRadioButton();

        //======== panel ========
        {
            panel.setMaximumSize(new Dimension(1025, 575));
            panel.setPreferredSize(new Dimension(1025, 575));
            panel.setMinimumSize(new Dimension(1025, 575));
            panel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
            . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder
            . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
            awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel. getBorder () ) )
            ; panel. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;

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
            label8.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive - VNU-HCMUS\\Desktop\\OIP.png"));

            //---- label9 ----
            label9.setText("Contact Number");
            label9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- phoneTF ----
            phoneTF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

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
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                    .addGroup(panelLayout.createParallelGroup()
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addGroup(panelLayout.createParallelGroup()
                                                .addComponent(label4)
                                                .addComponent(label2)
                                                .addComponent(label3))
                                            .addGap(85, 85, 85))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                            .addComponent(label6)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                                    .addGroup(panelLayout.createParallelGroup()
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(emailTF)
                                                .addComponent(usernameTF, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(confirmPasswordTF)))
                                .addComponent(registerButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                    .addComponent(label5)
                                    .addGap(6, 6, 6)
                                    .addComponent(loginLabel)
                                    .addGap(109, 109, 109))
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(label7)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(maleRadioButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(femaleRadioButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(otherRadioButton))
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(label9)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(phoneTF, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74))
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
                                    .addComponent(usernameTF, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addGap(6, 6, 6)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailTF, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(confirmPasswordTF, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6))
                                .addGap(6, 6, 6)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label9)
                                    .addComponent(phoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(otherRadioButton)
                                    .addComponent(femaleRadioButton)
                                    .addComponent(maleRadioButton)
                                    .addComponent(label7))
                                .addGap(32, 32, 32)
                                .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup()
                            .addComponent(label5)
                            .addComponent(loginLabel))
                        .addContainerGap(67, Short.MAX_VALUE))
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
    private JLabel label9;
    private JTextField phoneTF;
    private JLabel label7;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton otherRadioButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
