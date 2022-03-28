package LibraryManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class BookDetails extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1, b2, b3;

    public static void main(String args[]) {
        new BookDetails().setVisible(true);
    }// End main

    public void Book() {
        try {
            conn con = new conn();
            String sql = "Select * from book";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.ResultSetToTableModel(rs));
            rs.close();
            st.close();

            con.c.close();
        } // End try
        catch (Exception e) {

        } // End catch
    }// End book

    public BookDetails() {
        setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 282);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                search.setText(table.setModel().getValueAt(row, 1).toString());
            }// End mouseclicked
        });// End addmouseListener

        table.setBackground(new Color(240, 248, 255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        scrollPane.setViewportView(table);

        JButton b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("add image"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);
    }// End constructors
}// End bookDetails