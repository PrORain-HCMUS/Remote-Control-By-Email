package Functions;

import javax.swing.*;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class RunningApplications {

    public static void main(String[] args) {
        getRunningApplications();
    }

    public static void getRunningApplications() {
        // Hiển thị hộp thoại nhập đường dẫn từ người dùng
        String filePath = getFilePathFromUser();

        // Nếu người dùng không nhập hoặc nhấn cancel, thoát khỏi phương thức
        if (filePath == null || filePath.trim().isEmpty()) {
            return;
        }

        try {
            // Sử dụng lệnh tasklist để lấy danh sách các tiến trình trên Windows
            Process process = Runtime.getRuntime().exec("tasklist");

            // Kiểm tra lỗi trong quá trình chạy lệnh
            if (process.waitFor() != 0) {
                // Đọc thông báo lỗi từ quá trình
                java.util.Scanner errorScanner = new java.util.Scanner(process.getErrorStream());
                StringBuilder errorMessage = new StringBuilder();

                while (errorScanner.hasNextLine()) {
                    errorMessage.append(errorScanner.nextLine()).append("\n");
                }

                JOptionPane.showMessageDialog(null, "Lỗi khi chạy lệnh tasklist:\n" + errorMessage.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Đọc dữ liệu từ Output của quá trình
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder runningApplications = new StringBuilder();

            // Bỏ qua các dòng không cần thiết
            reader.readLine();
            reader.readLine();
            reader.readLine();

            // Đọc thông tin tiến trình
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String applicationName = parts[0];
                runningApplications.append(applicationName).append("\n");
            }

            // In ra danh sách ứng dụng để kiểm tra
            System.out.println("Danh sách ứng dụng: " + runningApplications.toString());

            // Ghi danh sách vào file
            writeToFile(runningApplications.toString(), filePath);

            JOptionPane.showMessageDialog(null, "Danh sách ứng dụng đã được ghi vào file: " + filePath);
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private static void writeToFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi ghi vào file: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static String getFilePathFromUser() {
        // Hiển thị hộp thoại nhập đường dẫn từ người dùng
        return JOptionPane.showInputDialog("Nhập đường dẫn và tên file (ví dụ: running_applications.txt):");
    }

    public static String getFileNameFromPath(String filePath) {
        // Trích xuất tên file từ đường dẫn
        return filePath.substring(filePath.lastIndexOf("/") + 1);
    }
}
