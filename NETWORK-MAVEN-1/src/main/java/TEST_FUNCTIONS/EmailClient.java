package TEST_FUNCTIONS;

import com.sun.mail.imap.IMAPFolder;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailClient {

    public static void main(String[] args) {
        // Thông tin tài khoản email
        String username = "maytinhmang060@gmail.com";
        String password = "lrtg ecbq ahxs abza";

        // Cấu hình đối tượng Properties
        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol", "imaps");
        properties.setProperty("mail.imaps.host", "imap.gmail.com");
        properties.setProperty("mail.imaps.port", "993");
        properties.setProperty("mail.imaps.starttls.enable", "true");

        try {
            // Tạo phiên làm việc với email server
            Session session = Session.getInstance(properties);
            Store store = session.getStore("imaps");
            store.connect(username, password);

            // Mở hộp thư inbox
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);

            // Lắng nghe thay đổi trên server
            idleListen(inbox);

            // Đóng kết nối
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phương thức lắng nghe IDLE
    private static void idleListen(Folder folder) throws MessagingException {
        IdleManager idleManager = new IdleManager((IMAPFolder) folder);
        idleManager.start();
    }


    // Lớp quản lý IDLE
    public static class IdleManager extends Thread {
        private final IMAPFolder folder;

        private IdleManager(IMAPFolder folder) {
            this.folder = folder;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (folder.isOpen() && folder.hasNewMessages()) {
                        // Xử lý khi có email mới
                        System.out.println("Có email mới.");

                        // Lấy và xử lý email mới
                        Message[] newMessages = folder.getMessages();
                        for (Message message : newMessages) {
                            processEmail(message);
                        }
                    }

                    // Chờ 1 phút trước khi kiểm tra lại
                    Thread.sleep(60000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void processEmail(Message message) throws Exception {
        // Get the sender, subject, and content of the message
        String sender = InternetAddress.toString(message.getFrom());
        String subject = message.getSubject();
        Object content = message.getContent();

        // Print the message details to the console
        System.out.println("- From: " + sender);
        System.out.println("- Subject: " + subject);
        System.out.println("- Content: " + content);

        // Mark the message as read
        message.setFlag(Flags.Flag.SEEN, true);

        // Do something with the email content
        if (subject.equals("TelePCEST")) {
            // Format input
            String formattedContent = content.toString().replace("\r\n", " ");

            // Perform actions based on the formatted content
            performActions(formattedContent);

            // Reply back to the sender
            replyToSender(message.getReplyTo()[0], "Server TelePC reply", "Reply content here");
        }
    }

    private static void performActions(String formattedContent) {
        // Implement your logic to perform actions based on the formatted content
        // You can parse and execute different actions as needed
        // Example: executeCommand(formattedContent);
    }

    private static void replyToSender(Address recipient, String subject, String content) throws MessagingException {
        // Set up JavaMail session and transport
        Properties properties = new Properties();
        Session session = Session.getInstance(properties);
        Transport transport = session.getTransport("smtp");

        // Set the recipient, subject, and content of the reply message
        Message replyMessage = new MimeMessage(session);
        replyMessage.setRecipient(Message.RecipientType.TO, recipient);
        replyMessage.setSubject(subject);
        replyMessage.setContent(content, "text/plain");

        // Send the reply message
        transport.connect();
        transport.sendMessage(replyMessage, replyMessage.getAllRecipients());
        transport.close();
    }
}

