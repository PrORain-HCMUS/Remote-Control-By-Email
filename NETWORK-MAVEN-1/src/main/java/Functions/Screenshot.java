package Functions;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Screenshot {
    public static void captureScreen(String outputDirectory, String fileName) {
        try {
            // Tạo đối tượng Robot để chụp màn hình
            Robot robot = new Robot();

            // Lấy kích thước màn hình
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            // Chụp màn hình
            BufferedImage screenCapture = robot.createScreenCapture(screenRect);

            // Tạo thư mục đầu ra nếu chưa tồn tại
            File directory = new File(outputDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Tạo đường dẫn đến tập tin đầu ra
            String filePath = outputDirectory + File.separator + fileName;

            // Lưu ảnh vào tập tin
            ImageIO.write(screenCapture, "png", new File(filePath));

            System.out.println("Màn hình đã được chụp và lưu vào: " + filePath);
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        // Thực hiện chụp màn hình và lưu vào thư mục "screenshots" với tên tập tin "screenshot.png"
//        captureScreen("C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\NETWORK-MAVEN-1\\src\\main\\java\\resources", "screenshot.png");
//    }
}
