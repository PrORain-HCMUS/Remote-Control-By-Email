package IGNORE;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;

public class KeyLog extends JFrame implements KeyListener {

  private BufferedWriter writer;
  public boolean isLogging = false;

  public KeyLog() {
    super("Key Logger");
    addKeyListener(this);
    setFocusable(true);

    try {
      writer = new BufferedWriter(new FileWriter("keylog.txt", true));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public void startLogging() {
    isLogging = true;
  }

  public void stopLogging() {
    isLogging = false;
    try {
      writer.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public void start() {
    startLogging();
  }

  public void stop() {
    stopLogging();
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
    KeyLog keyLog = new KeyLog();
    keyLog.setSize(300, 200);
    keyLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    keyLog.setVisible(true);
    keyLog.start();

    // Simulate logging for a while
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    keyLog.stop();
  }
}
