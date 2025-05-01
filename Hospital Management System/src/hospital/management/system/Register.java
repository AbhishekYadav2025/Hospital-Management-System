package hospital.management.system;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton registerBtn, backBtn;

    Register() {
        setTitle("Register");
        setLayout(null);

        JLabel userLabel = new JLabel("New Username:");
        userLabel.setBounds(40, 20, 120, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(170, 20, 150, 30);
        add(usernameField);

        JLabel passLabel = new JLabel("New Password:");
        passLabel.setBounds(40, 70, 120, 30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(170, 70, 150, 30);
        add(passwordField);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(40, 120, 120, 30);
        registerBtn.addActionListener(e -> {
            try {
                String user = usernameField.getText();
                String pass = new String(passwordField.getPassword());
                conn c = new conn();
                String query = "INSERT INTO login (ID, PW) VALUES ('" + user + "', '" + pass + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Registered Successfully!");
                setVisible(false);
                new Login();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(registerBtn);

        backBtn = new JButton("Back to Login");
        backBtn.setBounds(180, 120, 150, 30);
        backBtn.addActionListener(e -> {
            setVisible(false);
            new Login();
        });
        add(backBtn);

        getContentPane().setBackground(new Color(109, 164, 170));
        setSize(400, 220);
        setLocation(500, 300);
        setVisible(true);
    }
}

