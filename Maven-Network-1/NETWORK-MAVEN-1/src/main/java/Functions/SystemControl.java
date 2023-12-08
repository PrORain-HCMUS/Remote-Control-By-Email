package Functions;

import java.io.IOException;

public class SystemControl {

//    public static void main(String[] args) {
//        // Thực hiện shutdown
//        performShutdown();
//
//        // Thực hiện restart
//        performRestart();
//
//        // Hủy shutdown/restart
//        cancelShutdown();
//    }

    public static void performShutdown(int seconds) {
        try {
            System.out.println("Thực hiện shutdown sau " + seconds + " giây...");
            Runtime.getRuntime().exec("shutdown -s -t " + seconds);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi thực hiện shutdown: " + e.getMessage());
        }
    }

    public static void performRestart(int seconds) {
        try {
            System.out.println("Thực hiện restart sau " + seconds + " giây...");
            Runtime.getRuntime().exec("shutdown -r -t " + seconds);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi thực hiện restart: " + e.getMessage());
        }
    }

    public static void cancelShutdown() {
        try {
            System.out.println("Hủy shutdown/restart...");
            Runtime.getRuntime().exec("shutdown -a");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi hủy shutdown/restart: " + e.getMessage());
        }
    }
}
