package Frontend.GUI_Application.test;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class test_new_UI extends JPanel {

    private JToggleButton themeToggleButton;

    public test_new_UI() {
        initComponents();
        initThemeToggleButton();
    }

    private void implement_button_Clicked(ActionEvent e) {
        // TODO add your code here
    }

    private void Client_button_Clicked(ActionEvent e) {
        // TODO add your code here
    }

    private void initThemeToggleButton() {
        themeToggleButton = new JToggleButton("Dark Mode");
        themeToggleButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        themeToggleButton.addActionListener(e -> toggleTheme());

        // Thêm nút vào panel
        add(themeToggleButton, BorderLayout.SOUTH);
    }

    // Thêm một biến để theo dõi chủ đề hiện tại
    private boolean isDarkTheme = false;

    private void toggleTheme() {
        if (isDarkTheme) {
            // Chuyển sang Light Mode
            setLightTheme();
        } else {
            // Chuyển sang Dark Mode
            setDarkTheme();
        }

        // Cập nhật văn bản của nút
        updateThemeToggleButton();
    }

    private void setDarkTheme() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        isDarkTheme = true;

        // Cập nhật giao diện của tất cả các thành phần hiện tại
        SwingUtilities.updateComponentTreeUI(this);
        revalidate();
        repaint();
    }

    private void setLightTheme() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        isDarkTheme = false;

        // Cập nhật giao diện của tất cả các thành phần hiện tại
        SwingUtilities.updateComponentTreeUI(this);
        revalidate();
        repaint();
    }

    // Hàm này cập nhật văn bản của nút dựa trên chủ đề hiện tại
    private void updateThemeToggleButton() {
        themeToggleButton.setText(isDarkTheme ? "Light Mode" : "Dark Mode");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Chọn một chủ đề mặc định cho ứng dụng khi bắt đầu
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            JFrame frame = new JFrame("Your Application Title");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Tạo một instance của test_new_UI
            test_new_UI uiPanel = new test_new_UI();

            // Đặt giao diện màn hình
            frame.setContentPane(uiPanel);

            // Đặt kích thước và hiển thị màn hình
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null); // Hiển thị màn hình ở giữa
            frame.setVisible(true);
        });
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

        //======== this ========
        setForeground(new Color(0xcccccc));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
        new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e"
        , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 )
        , java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

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

        //---- label15 ----
        label15.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive - VNU-HCMUS\\Desktop\\NOBGKHTN.png"));

        //---- label16 ----
        label16.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive - VNU-HCMUS\\Desktop\\NOBGKHTN.png"));

        //---- toggleButton1 ----
        toggleButton1.setText("CLIENT");
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
            "SEND FILE VIA EMAIL"
        }));
        comboBox1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label16, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(toggleButton1, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                            .addGap(9, 9, 9)))
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
                            .addGap(11, 11, 11)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label16, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                .addComponent(label15, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, Short.MAX_VALUE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
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
    private JLabel label15;
    private JLabel label16;
    private JToggleButton toggleButton1;
    private JComboBox<String> comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
