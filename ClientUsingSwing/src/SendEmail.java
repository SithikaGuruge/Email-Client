import javax.swing.*;
public class SendEmail {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmailFrame frame = new EmailFrame();
            frame.addSendButtonListener(e -> {
                String to = frame.getToAddress();
                String subject = frame.getSubject();
                String body = frame.getBody();
                String from = frame.getFromAddress();
                String password = frame.getPassword();
                ConfigEmailSettings driver = new ConfigEmailSettings();
                if (from.isEmpty()) {
                    frame.displayMessage.setText("Enter the senders' Email");

                }
                else if (password.isEmpty()) {
                    frame.displayMessage.setText("Enter the password");

                }
                else if(to.isEmpty()){
                    frame.displayMessage.setText("Enter valid receiver Email");
                } else if (subject.isEmpty()) {
                    frame.displayMessage.setText("Enter a subject");

                }
               else if (body.isEmpty()) {
                    frame.displayMessage.setText("Enter a Email Body");

                }
                else {driver.send(to, subject, body,from,password);}
                Timer timer = new Timer(3000, event -> frame.displayMessage.setText(""));
                timer.setRepeats(false);
                timer.start();
            });
        });
    }
}
