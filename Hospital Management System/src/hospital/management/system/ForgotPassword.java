package hospital.management.system;

import javax.swing.*;
import java.awt.*;

public class ForgotPassword extends JFrame {

    JTextField userField;
    JPasswordField newPasswordField;
    JButton resetBtn, backBtn;

    ForgotPassword() {
        setTitle("Reset Password");
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(40, 20, 100, 30);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(150, 20, 150, 30);
        add(userField);

        JLabel newPassLabel = new JLabel("New Password:");
        newPassLabel.setBounds(40, 70, 100, 30);
        add(newPassLabel);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(150, 70, 150, 30);
        add(newPasswordField);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(40, 120, 120, 30);
        resetBtn.addActionListener(e -> {
            try {
                String user = userField.getText();
                String newPass = new String(newPasswordField.getPassword());
                conn c = new conn();
                String query = "UPDATE login SET PW = '" + newPass + "' WHERE ID = '" + user + "'";
                int result = c.statement.executeUpdate(query);
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Password Updated!");
                    setVisible(false);
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(null, "User not found.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(resetBtn);

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

