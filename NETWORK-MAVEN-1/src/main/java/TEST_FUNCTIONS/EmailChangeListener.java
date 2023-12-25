package TEST_FUNCTIONS;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.util.Properties;
import Functions.Client_Service.*;

public class EmailChangeListener {

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
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Lắng nghe sự kiện IDLE
            // Functions.Client_Service.idleListen(inbox);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
