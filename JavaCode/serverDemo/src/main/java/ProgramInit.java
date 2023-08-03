public class ProgramInit {

    private final static String url = "jdbc:mysql://localhost:3306/messenger?" +
            "user=root&password=root";
    public static void main(String[] args) {

        Connecter conn = new Connecter(url);
        Server server = new Server();


    }

}
