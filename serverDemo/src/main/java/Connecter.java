import java.sql.*;

public class Connecter {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public Connecter(String url) {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());;
        }
    }

    public ResultSet reqSend(String statement){
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(statement);
            return rs;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }

    }



}
