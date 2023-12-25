package Functions;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    public static void main(String[] args) {
        // Thông tin tài khoản email của bạn
        String username = "maytinhmang447@gmail.com";
        String password = "ggat sxwp mrvx tlof";

        // Thông tin máy chủ SMTP cục bộ
        String host = "localhost";
        int port = 25; // Thay đổi cổng SMTP nếu cần

        // Tạo đối tượng Properties để cấu hình phiên làm việc với máy chủ SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", String.valueOf(port));
        props.put("mail.smtp.auth", "true"); // Bật xác thực

        // Tạo đối tượng Session với thông tin xác thực
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Tạo đối tượng Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient_email@example.com"));
            message.setSubject("Chủ đề của email");
            message.setText("Nội dung email");

            // Gửi email
            Transport.send(message);

            System.out.println("Email đã được gửi thành công.");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi gửi email: " + e.getMessage());
        }
    }
}
