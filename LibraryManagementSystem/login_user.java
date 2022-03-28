package LibraryManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class login_user extends JFrame implements ActionListener {
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2, b3;

    public login_user() {
        setLayout(null);
        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(124, 89, 95, 24);
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(124, 89, 95, 24);
        panel.add(l2);

        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);

        b1 = new JButton("Login");
        b1.addActionListener(this);

        b1.setForeground(new Color(46, 139, 97));
        b1.setBackground(new Color(250, 250, 210));
        b1.setBounds(149, 181, 113, 39);
        panel.add(b1);

        b2 = new JButton("Login");
        b2.addActionListener(this);

        b2.setForeground(new Color(46, 139, 97));
        b2.setBackground(new Color(250, 250, 210));
        b2.setBounds(149, 181, 113, 39);
        panel.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);

        b3.setForeground(new Color(205, 92, 92));
        b3.setBackground(new Color(253, 245, 230));
        b3.setBounds(199, 231, 179, 39);
        panel.add(b3);

        JLabel l5 = new JLabel("Trouble in login?");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l5.setForeground(new Color(255, 0, 0));
        l5.setBounds(70, 240, 130, 20);
        panel.add(l5);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(176, 224, 230));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
    }// End constructor

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            Boolean status = false;
            try {
                conn con = new conn();
                String sql = "selcect * from libray where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    this.setVisible(false);
                    new Loading().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login!");
                } // Endif-else
            } // End End try
            catch (Exception e2) {
                e2.printStackTrace();
            } // End catch
        } // End if

        if (ae.getSource() == b2) {
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        } // End if

        if (ae.getSource() == b3) {
            setVisible(false);
            Forgot forgot = new Forgot();
            forgot.setVisible(true);
        } // End if
    }// End actionperformed

    public static void main(String[] args) {
        new login_user().setVisible(true);
    }// End main
}// End loginuser
