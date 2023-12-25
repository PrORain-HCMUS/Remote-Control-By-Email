package Functions;

import java.io.IOException;

public class SystemControl {

    public static void main(String[] args) {
        // Thực hiện shutdown
        // performShutdown(3600);

        // Thực hiện restart
        performRestart(3600);

        // Hủy shutdown/restart
        // cancelShutdown();
    }

    public static void performShutdown(int seconds) {
        try {
            System.out.println("Thực hiện shutdown sau " + seconds + " giây...");
            ProcessBuilder processBuilder = new ProcessBuilder("shutdown", "-s", "-t", String.valueOf(seconds));
            Process process = processBuilder.start();
            // Xử lý kết quả nếu cần
        } catch (IOException e) {
            handleIOException("shutdown/restart", e);
        }
    }

    public static void performRestart(int seconds) {
        try {
            System.out.println("Thực hiện restart sau " + seconds + " giây...");
            ProcessBuilder processBuilder = new ProcessBuilder("shutdown", "-r", "-t", String.valueOf(seconds));
            Process process = processBuilder.start();
            // Xử lý kết quả nếu cần
        } catch (IOException e) {
            handleIOException("shutdown/restart", e);
        }
    }

    public static void cancelShutdown() {
        try {
            System.out.println("Hủy shutdown/restart...");
            ProcessBuilder processBuilder = new ProcessBuilder("shutdown", "-a");
            Process process = processBuilder.start();
            // Xử lý kết quả nếu cần
        } catch (IOException e) {
            handleIOException("cancel shutdown/restart", e);
        }
    }

    private static void handleIOException(String action, IOException e) {
        System.err.println("Lỗi khi thực hiện " + action + ": " + e.getMessage());
        // Thoát ứng dụng hoặc xử lý lỗi theo nhu cầu của bạn
        System.exit(1);
    }
}
