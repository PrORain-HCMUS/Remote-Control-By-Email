package Functions;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.io.File;

public class SendFile {

    public static void sendEmailWithAttachment(String from, String to, String subject, String body, String attachmentDirectory, String attachmentFileName, String username, String password) {
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            BodyPart textPart = new MimeBodyPart();
            textPart.setText(body);

            BodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(new File(attachmentDirectory, attachmentFileName));
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(attachmentFileName);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Email has been sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void sendEmailWithAttachment_2(String from, String to, String subject, String body,
                                                 String attachment, String username, String password) {
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            BodyPart textPart = new MimeBodyPart();
            textPart.setText(body);

            BodyPart attachmentPart = new MimeBodyPart();
            Path filePath = Paths.get(attachment);
            DataSource source = new FileDataSource(filePath.toString());
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(filePath.getFileName().toString());

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Email has been sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        // Example usage:
//        String from = "your_email@gmail.com";
//        String to = "recipient_email@gmail.com";
//        String subject = "Email with attachment";
//        String body = "This is the email body.";
//        String attachmentDirectory = "C:\\path\\to\\your\\directory";
//        String attachmentFileName = "file.txt";
//        String username = "your_email@gmail.com";
//        String password = "your_password";
//
//        sendEmailWithAttachment(from, to, subject, body, attachmentDirectory, attachmentFileName, username, password);
//    }
}