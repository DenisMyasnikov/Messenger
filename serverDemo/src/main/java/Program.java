import java.sql.ResultSet;
import java.sql.SQLException;

public class Program {

    public static void main(String[] args) {
        Connecter conn = new Connecter("jdbc:mysql://localhost:3306/messenger?" +
                "user=root&password=root");
        ResultSet resultSet = conn.reqSend("SELECT * FROM users");
        try {
            resultSet.next();
            String string = resultSet.getString(2);
            System.out.println(string);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }
}
