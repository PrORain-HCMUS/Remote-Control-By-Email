package Functions;

public class test_main {
    public static void main(String[] args) {
        final String username = "maytinhmang060@gmail.com";
        final String password = "lrtg ecbq ahxs abza"; // App password

        // Gửi và nhận email (sử dụng SendReceiveMail)
        SendReceiveMail.sendAndReceiveMail(username, password, "maytinhmang447@gmail.com", "1");
    }
}
