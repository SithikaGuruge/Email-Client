import javax.swing.*;
import java.util.Objects;

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

                if(frame.confirmDialog()){
                    if (!frame.validateEmail(from)) {
                        frame.displayMessage.setText("Enter a Valid Email");
                    }
                    else if (password.isEmpty()) {
                        frame.displayMessage.setText("Enter the password");

                    }
                    else if(!frame.validateEmail(to)){
                        frame.displayMessage.setText("Enter a valid receiver Email");
                    } else if (subject.isEmpty()) {
                        frame.displayMessage.setText("Enter a subject");

                    }
                    else if (body.isEmpty()) {
                        frame.displayMessage.setText("Enter a Email Body");

                    }
                    else {
                        String message = driver.send(to, subject, body,from,password);
                        if(Objects.equals(message, "Email Successfully Sent")){
                        frame.showSuccessDialog(message);}
                        else {
                            frame.showErrorDialog(message);
                        }

                    }
                    Timer timer = new Timer(3000, event -> frame.displayMessage.setText(""));
                    timer.setRepeats(false);
                    timer.start();
                }

            });
        });
    }
}
