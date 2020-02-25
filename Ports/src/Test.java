import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Dmitry on 2017-02-28.
 */
public class Test {

    public static void main(String[] args) {
        Services services = new Services();

        final String host = "95.216.2.95";  //95.216.2.95  //176.114.4.70
        int startPort = 1;
        int endPort = 48619;
        final int timeOut = 1500;  // 1.5 seconds

        for (int port = startPort; port <= endPort; port++) {
            Boolean isOpen = Boolean.TRUE;

            System.out.print("checking port " + port + " ... ");

            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(host, port), timeOut);
            } catch (Throwable cause) {
                isOpen = Boolean.FALSE;
            }

            if (isOpen) {
                String serviceName = (String) services.get(Integer.toString(port));

                if (serviceName != null) {
                    String[] service = serviceName.split("/");

                    System.out.println("is open (" + service[0] + ", " + service[1] + ")");
                } else {
                    System.out.println("is open (unknown)");
                }
            } else {
                System.out.println("is closed");
            }
        }
    }
}