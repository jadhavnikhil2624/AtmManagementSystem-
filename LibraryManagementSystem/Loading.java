package LibraryManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {
    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    int s;
    Thread th;

    public static void main(String[] args) {
        new Loading().setVisible(true);
    }// End main

    public void setUploading() {
        // setVisible(false);
        th.start();
    }// End setUploading

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();

                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Home().setVisible(true);
                } // End if-else
                Thread.sleep(50);
            } // End for
        } // End try
        catch (Exception e) {
            e.printStackTrace();
        } // End catch
    }// End run

    public Loading()
    {
        super("Loading");
        th = new Thread((Runnable)this);

        setBounds(600,300,600,400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbllibraryManagement new JLabel("Digital Library");
        lbllibraryManagement.setForeground(new Color(72,209,204));
        lbllibraryManagement.setFont(new Font("Trebuchet MS",Font.ITALIC,35));
        contentPane.add(lbllibraryManagement);

        progressBar = new JprogressBar();
        progressBar.setFont(new Font("Tahoma",Font.BOLD,12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130,135,300,25);
        contentPane.add(progressBar);

        JLabel lblNewLabel_2 = new JLabel("Please Wait..");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold",Font.BOLD,20));
        lblNewLabel_2.setForeground(new Color(160,150,20));
        lblNewLabel_2.setBounds(200,165,150,20);
        contentPane.add(lblNewLabel_2);

        setUploading();
    }// End constructor
}// End class
