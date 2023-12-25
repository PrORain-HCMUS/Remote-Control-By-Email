package Functions.remote_server;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

// chạy lỗi hãy thử dùng *netstat -ano | findstr :5000* -> *taskkill /F /PID PID-gi-do*

// import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

/**
 *
 * @author Desktop
 */
public class RemoteServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Tạo luồng thực thi
                Thread thread = new Thread(() -> handleClientRequest(socket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void handleClientRequest(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            while (true) {
                String request = reader.readLine();
                System.out.println(request);
                if (request.equals("shutdown")) {
                    // Sử dụng Runtime
                    Runtime.getRuntime().exec("shutdown -s -t 3600");
                    writer.println("Máy tính đang tắt ... ");
                    writer.flush();
                } else if (request.equals("restart")) {
                    // Sử dụng Runtime
                    Runtime.getRuntime().exec("shutdown -r -t 3600");
                    writer.println("Máy tính đang khởi động lại ... ");
                    writer.flush();
                } else if (request.equals("cancel")) {
                    // Sử dụng Runtime
                    Runtime.getRuntime().exec("shutdown -a");
                    writer.println("Máy tính đang khởi động lại ... ");
                    writer.flush();
                } else if (request.equals("screenshot")) {
                    // Chụp ảnh
                    BufferedImage screenshot = new Robot().createScreenCapture(
                            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(screenshot, "png", baos);

                    byte[] imageBytes = baos.toByteArray();
                    baos.close();

                    writer.println(imageBytes.length);
                    writer.flush();
                    socket.getOutputStream().write(imageBytes);
                }
            }
        } catch (Exception e) {
        }
    }
}
