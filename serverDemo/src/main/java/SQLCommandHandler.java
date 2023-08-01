
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLCommandHandler {
    Connecter conn = null;

    public SQLCommandHandler(Connecter cn) {
        conn = cn;
    }
    public Integer initUser(String logUser, String pasUser) {

        String query = "SELECT user_id FROM users WHERE username = \"" + logUser + "\"AND password_hash = \"" + pasUser + "\";";
        ResultSet resultSet = conn.reqSendWithResSet(query);
        try {
            resultSet.next();
            int usrId = resultSet.getInt(1);
            return usrId;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    public Integer initUserWithoutPas(String logUser) {

        String query = "SELECT user_id FROM users WHERE username = \"" + logUser + "\";";
        ResultSet resultSet = conn.reqSendWithResSet(query);
        try {
            resultSet.next();
            int usrId = resultSet.getInt(1);
            return usrId;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    public void addUser(String logUser, String pasUser) {
        if (initUserWithoutPas(logUser) != null) {
            System.out.println("User already exist");
        } else {
            String query = "INSERT IGNORE INTO users (username, password_hash) VALUES(\"" + logUser + "\", \"" + pasUser + "\");";
            conn.reqSendUpdate(query);

            if (initUser(logUser, pasUser) == null)
                System.out.println("SQL addition error");
        }
    }

    public void deleteUser(String logUser) {    //Нужен ли пароль
        if (initUserWithoutPas(logUser) != null) {
            String query = "DELETE FROM users WHERE username = \"" + logUser + "\"";
            conn.reqSendUpdate(query);
            if (initUserWithoutPas(logUser) != null)
                System.out.println("SQL deletion error");
        } else {
            System.out.println("User don't exist");
        }
    }



}
