import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmailFrame extends JFrame {
    private JTextField toAddress;
    private JTextField subject;
    private JTextArea bodyArea;
    private JButton sendButton;

    private JTextField fromAddress;
    private JTextField password;

    public JLabel displayMessage;

    public EmailFrame() {
        super("My Email Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem menuItem = new JMenuItem("Add Sender Credentials");
        menu.add(menuItem);
        menubar.add(menu);
        setJMenuBar(menubar);

        JLabel title = new JLabel("My Email Client");
        JLabel fromLabel = new JLabel("Your Email:");
        fromAddress = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        password = new JPasswordField(20);
        JLabel toLabel = new JLabel("To:");
        toAddress = new JTextField(20);
        JLabel subjectLabel = new JLabel("Subject:");
        subject = new JTextField(20);
        JLabel bodyLabel = new JLabel("Body:");
        bodyArea = new JTextArea(10, 20);
        JScrollPane bodyScrollPane = new JScrollPane(bodyArea);
        sendButton = new JButton("Send");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);
        bodyArea.setLineWrap(true);
        bodyArea.setWrapStyleWord(true);
        displayMessage = new JLabel();
        displayMessage.setForeground(Color.RED); // Set text color to red

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(fromLabel, gbc);

        gbc.gridx = 1;
        add(fromAddress, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        add(password, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 3;
        gbc.gridx = 0;
        add(toLabel, gbc);

        gbc.gridx = 1;
        add(toAddress, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        add(subjectLabel, gbc);

        gbc.gridx = 1;
        add(subject, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(bodyLabel, gbc);

        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(bodyScrollPane, gbc);

        gbc.gridy = 7;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        add(sendButton, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Ensure the message label spans across both columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the message label
        add(displayMessage, gbc); // Add displayMessage label here

        setVisible(true);
    }

    public String getToAddress() {
        return toAddress.getText();
    }

    public String getFromAddress() {
        return fromAddress.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getSubject() {
        return subject.getText();
    }

    public String getBody() {
        return bodyArea.getText();
    }

    public void addSendButtonListener(ActionListener listener) {
        sendButton.addActionListener(listener);
    }
}
