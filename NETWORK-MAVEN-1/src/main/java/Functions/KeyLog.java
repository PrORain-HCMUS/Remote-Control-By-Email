package Functions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class KeyLog extends JFrame implements KeyListener {

    private BufferedWriter writer;
    private boolean isLogging = false;
    private Runnable callback;

    public KeyLog() {
        super("Key Logger");
        addKeyListener(this);
        setFocusable(true);

        String logFilePath = JOptionPane.showInputDialog("Nhập đường dẫn và tên file lưu keylog:");

        if (logFilePath != null && !logFilePath.isEmpty()) {
            try {
                writer = new BufferedWriter(new FileWriter(logFilePath, true));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Đường dẫn không hợp lệ!");
            System.exit(0);
        }
    }

    public void setCallback(Runnable callback) {
        this.callback = callback;
    }

    public void startLogging() {
        isLogging = true;

        // Sau khi keylogging hoàn thành, gọi callback
        if (callback != null) {
            callback.run();
        }
    }

    public void stopLogging() {
        isLogging = false;
        try {
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void keyPressed(KeyEvent e) {
        try {
            if (isLogging) {
                String keyText = KeyEvent.getKeyText(e.getKeyCode());
                writer.write("Key Pressed: " + keyText);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void keyReleased(KeyEvent e) {
        // Handle key released event if needed
    }

    public void keyTyped(KeyEvent e) {
        // Handle key typed event if needed
    }

    public static void main(String[] args) {
        KeyLog keyLogger = new KeyLog();
        keyLogger.setSize(300, 200);
        keyLogger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyLogger.setVisible(true);
        keyLogger.startLogging();
    }
}
