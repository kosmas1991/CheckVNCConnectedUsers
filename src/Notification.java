import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class Notification implements Runnable {
    String line;

    public Notification(String line) {
        this.line = line;
    }

    @Override
    public void run()
    {
        try{
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("some-icon.png");
            TrayIcon trayIcon = new TrayIcon(image, "Java AWT Tray Demo");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("System tray icon demo");
            tray.add(trayIcon);
            trayIcon.displayMessage("Intruder", line, MessageType.INFO);
           }catch(Exception ex){
            System.err.print("yo");
        }
    }
}
