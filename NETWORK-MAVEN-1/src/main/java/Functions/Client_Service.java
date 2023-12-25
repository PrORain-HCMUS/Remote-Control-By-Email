package Functions;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Functions.Screenshot;
import Functions.SystemControl.*;

public class Client_Service {

    public static void sendAndReceiveMail(String senderEmail, String senderPassword, String receiverEmail, String orderTask) {
        //sendEmail(senderEmail, senderPassword, receiverEmail, orderTask);
        receiveLatestEmail(senderEmail, senderPassword);

    }

    public static void sendEmail(String senderEmail, String senderPassword, String receiverEmail, String orderTask) {
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

    public static void receiveEmail(String senderEmail, String senderPassword) {
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

    public static String receiveLatestFor6(String senderEmail, String senderPassword) {
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
                String content = removeFirstCharacters(latestMessage.getContent().toString(), 14);

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

    public static String removeFirstCharacters(String input, int n) {
        if (input != null && input.length() > n) {
            return input.substring(n);
        }
        return "";
    }

    public static String extractTask(String content) {
        // Sử dụng regex để trích xuất task từ nội dung email
        Pattern pattern = Pattern.compile("Order Task: (.+)");
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            // Trả về kết quả trích xuất
            return matcher.group(1);
        }

        // Trả về null nếu không tìm thấy
        return null;
    }

    public static String removeSpecialCharacters(String input) {
        // Sử dụng regular expression để chỉ xóa các ký tự không phải là chữ cái
        String regex = "[^a-zA-Z\\\\]";
        String result = input.replaceAll(regex, "");
        return result;
    }

    public static String removePrefix(String input, String prefix) {
        // Kiểm tra xem chuỗi có bắt đầu bằng tiền tố không
        if (input.startsWith(prefix)) {
            // Nếu có, loại bỏ tiền tố đó
            return input.replaceFirst(prefix, "");
        } else {
            // Nếu không, trả về chuỗi nguyên vẹn
            return input;
        }
    }

    public static String convertPath(String path) {
        // Thay thế mỗi dấu "/" thành "\\"
        return path.replace("\\", "\\\\");
    }

    public static String Task(String content) {
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

    private static void Announcement(String content){
        System.out.println("Client đã thành công hoàn thành task" + content.replaceAll("[^0-9]", ""));
    }

    private static void Commit(String task){
        int task_num = Integer.parseInt(task);
        switch(task_num){
            case 1:
                SystemControl.performShutdown(3600);
                break;
            case 2:
                SystemControl.performRestart(3600);
                break;
            case 3:
                SystemControl.cancelShutdown();
                break;
            case 4:
                //
                break;
            case 5:
                String default_Directory = "C:\\Users\\Administrator\\Desktop\\Maven-Network-1\\NETWORK-MAVEN-1\\src\\main\\java\\resources\\Pictures";
                Screenshot.captureScreen(default_Directory, "screenshot");

                break;
            case 6:
                //
                break;


        }
    }

}