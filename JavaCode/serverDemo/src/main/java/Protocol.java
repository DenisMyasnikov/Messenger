
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Protocol {

    private Connecter conn = null;
    private SQLCommandHandler sqlCH = null;


    public Protocol(Connecter conn) {
        this.conn = conn;
        sqlCH = new SQLCommandHandler(conn);
    }

    void aggregator(String request) {
        StringTokenizer st = new StringTokenizer(request, " ");
        ArrayList<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        if (!tokens.isEmpty()) {
            switch (tokens.get(0)) {
                case "addUser":
                    sqlCH.addUser(tokens.get(1), tokens.get(2));

                case "initUser":
                    if (tokens.size() == 3) {
                        sqlCH.initUser(tokens.get(1), tokens.get(2));
                    } else {
                        sqlCH.initUserWithoutPas(tokens.get(1));
                    }
                case "deleteUser":
                    sqlCH.deleteUser(tokens.get(1));
                default:
            }
        }
    }
}
