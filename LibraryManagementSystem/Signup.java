package LibraryManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Signup extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton b1, b2;
    private JComboBox comboBox;

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }// End main

    public Signup() {
        setBounds(600, 250, 606, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(99, 123, 92, 26);
        contentPane.add(lblUsername);

        JLabel lblName = new JLabel("Name: ");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(99, 123, 92, 26);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 123, 92, 26);
        contentPane.add(lblPassword);

        JLabel lblAnswer = new JLabel("Password: ");
        lblAnswer.setForeground(Color.DARK_GRAY);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(99, 123, 92, 26);
        contentPane.add(lblAnswer);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
                "Your childHood SuperHero?", "Your Childhood Name ?" }));
        comboBox.setBounds(265, 202, 148, 20);
        contentPane.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Security Question: ");
        lblSecurityQuestion.setForeground(Color.DARK_GRAY);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 123, 92, 26);
        contentPane.add(lblSecurityQuestion);

        textField = new JTextField();
        textField.setBounds(265, 91, 148, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField1 = new JTextField();
        textField1.setColumns(10);
        textField1.setBounds(265, 165, 148, 20);
        contentPane.add(textField1);

        textField2 = new JTextField();
        textField2.setColumns(10);
        textField2.setBounds(265, 165, 148, 20);
        contentPane.add(textField2);

        textField3 = new JTextField();
        textField3.setColumns(10);
        textField3.setBounds(265, 165, 148, 20);
        contentPane.add(textField3);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("tahoma", Font.BOLD, 13));
        b1.setBounds(140, 200, 100, 30);
        b2.setBackground(Color, BLACK);
        b2.setForeground(Color, WHITE);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2),
                "Create-Account", TitledBorder, LEADING, TitledBorder, TOP, null, new Color(34, 139, 34)));

        panel.setBounds(31, 46, 476, 296);
        panel.setBounds(Color.WHITE);
        contentPane.add(panel);
    }// End constructor

    public void actionPerformed(ActionEvent ae)
    {
        try{
            conn con = new conn();

            if(ae.getSource() == b1){
                String sql = "insert into account (username,name,password,see_q,see_ans) values(?,?, ?, ?, ?)";
                PreparedStatement st= con.c.PreparedStatement(sql);

                st.setString(1,textField.getText);
                st.setString(2,textField_1.getText);
                st.setString(3,textField_2.getText);
                st.setString(4,,(String) comboBox.getSelectedItem());
                st.setString(5,textField_3.getText);

                int i = st.executeUpdate();
                if(i>0){
                    JOptionPane.showMessageDialog(null, "Successfully Created");
                }//End if

                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
            }//End if

            if (ae.getSource() == b2){
                this.setVisible(false);
                new Login_user().setVisible(true);
            }//End if
        }//End try

        catch(Exception e){
            
        }//End catch    
    }// End actionPerformed
}// End Signup
