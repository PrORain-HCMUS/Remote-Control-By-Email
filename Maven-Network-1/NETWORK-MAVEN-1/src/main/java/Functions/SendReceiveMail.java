package Functions;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;

public class SendReceiveMail {

    public static void sendAndReceiveMail(String senderEmail, String senderPassword, String receiverEmail, String orderTask) {
        sendEmail(senderEmail, senderPassword, receiverEmail, orderTask);
        receiveLatestEmail(senderEmail, senderPassword);

    }

    private static void sendEmail(String senderEmail, String senderPassword, String receiverEmail, String orderTask) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject("Order Task");
            message.setText("Order Task: " + orderTask);

            Transport.send(message);

            System.out.println("Email đã được gửi thành công!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi gửi email: " + e.getMessage());
        }
    }

    private static void receiveEmail(String senderEmail, String senderPassword) {
        Properties props = new Properties();
        props.put("mail.imap.ssl.enable", "true");
        props.put("mail.imap.host", "imap.gmail.com");
        props.put("mail.imap.port", "993");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Store store = session.getStore("imap");
            store.connect();

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            for (Message message : messages) {
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + InternetAddress.toString(message.getFrom()));
                System.out.println("Date: " + message.getSentDate());
                System.out.println("---------------");
            }

            inbox.close(false);
            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi nhận email: " + e.getMessage());
        }
    }

    public static String receiveLatestEmail(String senderEmail, String senderPassword) {
        Properties props = new Properties();
        props.put("mail.imap.ssl.enable", "true");
        props.put("mail.imap.host", "imap.gmail.com");
        props.put("mail.imap.port", "993");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Store store = session.getStore("imap");
            store.connect();

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            if (messages.length > 0) {
                Message latestMessage = messages[messages.length - 1]; // Lấy mail gần nhất

                String subject = latestMessage.getSubject();
                String from = InternetAddress.toString(latestMessage.getFrom());
                String sentDate = latestMessage.getSentDate().toString();
                String content = Task(latestMessage.getContent().toString());

                System.out.println("Subject: " + subject);
                System.out.println("From: " + from);
                System.out.println("Date: " + sentDate);
                System.out.println("Content: " + content);

                return content;
            }

            inbox.close(false);
            store.close();
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi nhận email: " + e.getMessage());
        }

        return null;
    }

    private static String Task(String content) {
        // Loại bỏ tất cả ký tự không phải số từ nội dung
        return content.replaceAll("[^0-9]", "");
    }

    public static boolean Contain_Number(String input, int targetNumber) {
        String[] numbers = input.split("\\s+");

        for (String number : numbers) {
            try {
                int currentNumber = Integer.parseInt(number);
                if (currentNumber == targetNumber) {
                    return true;
                }
            } catch (NumberFormatException e) {
                // Bỏ qua các phần tử không phải số
            }
        }

        return false;
    }




}