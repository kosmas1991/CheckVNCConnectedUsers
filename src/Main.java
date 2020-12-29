import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            //String command = "netstat -na | find \":5900\" | find \"ESTABLISHED\"";
            String command = "netstat -na";

            try {
                Process process = Runtime.getRuntime().exec(command);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));
                String line;
                String noti = "";
                int counter = 0;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(":5900"))
                        if (line.contains("ESTABLISHED")) {
                            //System.out.println(line);
                            counter++;
                            noti += line;
                        }
                }
                if (counter > 1) {
                    System.out.println("ooops");
                    Thread threadNotification = new Thread(new Notification(noti));
                    System.out.println(noti);
                    threadNotification.start();
                }

                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(10000);
        }
    }
}
