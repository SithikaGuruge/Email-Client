import javax.swing.*;
import java.awt.*;


public class EmailFrame extends JFrame{

    EmailFrame(){
        super("My Email Client");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);

        JLabel title = new JLabel("My Email Client");
        JLabel toLabel = new JLabel("To:");
        JTextField toAddress = new JTextField(20);
        JLabel subjectLabel = new JLabel("Subject:");
        JTextField subject = new JTextField(20);
        JLabel bodyLabel = new JLabel("Body:");
        JTextArea bodyArea = new JTextArea(10, 20);
        JScrollPane bodyScrollPane = new JScrollPane(bodyArea);
        JButton sendButton = new JButton("Send");


        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);

        bodyArea.setLineWrap(true);
        bodyArea.setWrapStyleWord(true);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        this.add(toLabel, gbc);

        gbc.gridx = 1;
        this.add(toAddress, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        this.add(subjectLabel, gbc);

        gbc.gridx = 1;
        this.add(subject, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        this.add(bodyLabel, gbc);

        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(bodyScrollPane, gbc);

        gbc.gridy = 5;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        this.add(sendButton, gbc);

        this.setVisible(true);
    }

}
