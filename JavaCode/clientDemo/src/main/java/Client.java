import myas.Phone;

import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        
        try (Phone phone = new Phone("127.0.0.1", 8000))
        {
            String request  = null;
            while (request != "exit"){
                System.out.println("connected to server");
                Scanner in = new Scanner(System.in);

                request = in.nextLine();
                System.out.println("Request: " + request);
                phone.writeLine(request);
                String response = phone.readLine();
                System.out.println("Response: " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
