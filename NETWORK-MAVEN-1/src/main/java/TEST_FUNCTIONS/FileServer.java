package TEST_FUNCTIONS;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileServer {

    public void main(String[] args) {
        // Khởi tạo ứng dụng
        FileController fileController = new FileController();

        // Thực hiện upload file (đặt đường dẫn và tên file tương ứng của bạn)
        MultipartFile multipartFile = createMultipartFile(); // Replace with your MultipartFile object
        ResponseEntity<String> response = fileController.handleFileUpload(multipartFile);

        // Xử lý kết quả
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("File uploaded successfully.");
        } else {
            System.err.println("Error uploading file: " + response.getBody());
        }
    }

    // Replace this method with actual MultipartFile creation logic
    private static MultipartFile createMultipartFile() {
        try {
            // Đường dẫn đến file trên Desktop
            String filePath = "C:\\Users\\Administrator\\Desktop\\text.txt";
            File file = ResourceUtils.getFile(filePath);

            // Tạo đối tượng MultipartFile giả lập từ file
            FileInputStream input = new FileInputStream(file);
            return new MockMultipartFile("file", file.getName(), "text/plain", input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RestController
    @RequestMapping("/file")
    class FileController {

        @PostMapping("/upload")
        public ResponseEntity<String> handleFileUpload(
                @RequestParam("file") MultipartFile file) {
            try {
                // Lưu file trên máy server
                File destinationDirectory = new File("uploaded_files");
                if (!destinationDirectory.exists()) {
                    destinationDirectory.mkdirs();
                }

                File destinationFile = new File(destinationDirectory, file.getOriginalFilename());
                file.transferTo(destinationFile);

                return ResponseEntity.ok("File uploaded successfully.");
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file.");
            }
        }
    }
}
