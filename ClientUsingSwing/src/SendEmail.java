import javax.swing.*;
public class SendEmail {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmailFrame frame = new EmailFrame();
            frame.addSendButtonListener(e -> {
                String to = frame.getToAddress();
                String subject = frame.getSubject();
                String body = frame.getBody();
                ConfigEmailSettings driver = new ConfigEmailSettings();
                driver.send(to, subject, body);
            });
        });
    }
}
