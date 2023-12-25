package Functions;

// import Functions.SendReceiveMail;
//import Database.DatabaseManager;

public class Main {

    public static void main(String[] args) {
        final String username = "maytinhmang447@gmail.com";
        final String password = "ggat sxwp mrvx tlof"; // App password

        // Gửi và nhận email (sử dụng SendReceiveMail)
        SendReceiveMail.sendAndReceiveMail(username, password, "maytinhmang060@gmail.com", "1");
    }
}
