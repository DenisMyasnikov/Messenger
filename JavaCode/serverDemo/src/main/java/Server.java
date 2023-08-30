import myas.Phone;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public Server(Protocol protocol) {
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started");

            while (true){
                Phone phone = new Phone(server);

                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.println("Request: " + request);
                    String response = (int)(Math.random()* 30) + "";
                    protocol.aggregator(request);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    phone.writeLine(response);
                    System.out.println("Response: " + response);

                    try {
                        phone.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

