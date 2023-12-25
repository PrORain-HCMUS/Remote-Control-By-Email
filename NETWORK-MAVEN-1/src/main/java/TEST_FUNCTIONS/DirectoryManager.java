package TEST_FUNCTIONS;

import java.io.File;
import java.io.IOException;

public class DirectoryManager {

    public static void showDirectoryTree(String root, int deepLevel) {
        File directory = new File(root);
        if (directory.exists() && directory.isDirectory()) {
            displayDirectoryTree(directory, deepLevel, "");
        } else {
            System.out.println("Invalid directory path");
        }
    }

    private static void displayDirectoryTree(File directory, int deepLevel, String prefix) {
        System.out.println(prefix + directory.getName());
        if (deepLevel == 0) {
            return;
        }

        File[] subFiles = directory.listFiles();
        if (subFiles != null) {
            for (int i = 0; i < subFiles.length - 1; i++) {
                displayDirectoryTree(subFiles[i], deepLevel - 1, prefix + "|   ");
            }
            if (subFiles.length > 0) {
                displayDirectoryTree(subFiles[subFiles.length - 1], deepLevel - 1, prefix + "    ");
            }
        }
    }

    public static String copyFile(String srcPath, String dstPath) {
        File sourceFile = new File(srcPath);
        File destinationDir = new File(dstPath);

        if (!sourceFile.exists()) {
            return "Source file does not exist.";
        }

        if (!destinationDir.exists()) {
            destinationDir.mkdirs();
        }

        try {
            java.nio.file.Files.copy(sourceFile.toPath(), (new File(destinationDir, sourceFile.getName())).toPath());
            return "File copied successfully.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error copying file.";
        }
    }

    public static String moveFile(String srcPath, String dstDir) {
        File sourceFile = new File(srcPath);
        File destinationDir = new File(dstDir);

        if (!sourceFile.exists()) {
            return "Source file does not exist.";
        }

        if (!destinationDir.exists()) {
            destinationDir.mkdirs();
        }

        File destinationFile = new File(destinationDir, sourceFile.getName());

        if (destinationFile.exists()) {
            return "File already exists at the destination.";
        }

        if (sourceFile.renameTo(destinationFile)) {
            return "File moved successfully.";
        } else {
            return "Error moving file.";
        }
    }

    public static String deleteFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            return "File does not exist.";
        }

        if (file.delete()) {
            return "File deleted successfully.";
        } else {
            return "Error deleting file.";
        }
    }

    public static void main(String[] args) {
        // Example usage
        showDirectoryTree("C:\\Users", 2);
//        System.out.println(copyFile("/path/to/source/file.txt", "/path/to/destination"));
//        System.out.println(moveFile("/path/to/source/file.txt", "/path/to/destination"));
//        System.out.println(deleteFile("/path/to/deleted/file.txt"));
    }
}
