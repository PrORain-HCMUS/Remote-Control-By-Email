package TEST_FUNCTIONS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class FileClient {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("File Client");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new FileClientPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

class FileClientPanel extends JPanel {

    private JTextField filePathField;

    public FileClientPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new FlowLayout());

        filePathField = new JTextField(20);
        JButton browseButton = new JButton("Browse");
        JButton uploadButton = new JButton("Upload");

        browseButton.addActionListener(this::browseButtonClicked);
        uploadButton.addActionListener(this::uploadButtonClicked);

        add(filePathField);
        add(browseButton);
        add(uploadButton);
    }

    private void browseButtonClicked(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filePathField.setText(selectedFile.getAbsolutePath());
        }
    }

    private void uploadButtonClicked(ActionEvent e) {
        String filePath = filePathField.getText();

        if (filePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a file to upload.");
            return;
        }

        File file = new File(filePath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "File does not exist.");
            return;
        }

        String serverUrl = "http://localhost:55142/file/upload";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        FileSystemResource resource = new FileSystemResource(file);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", resource);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(serverUrl, requestEntity, String.class);

        JOptionPane.showMessageDialog(this, response.getBody());
    }
}

