package LibraryManagementSystem;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///library", "root", "RISING_STAR2624");
            s = c.createStatement();
        } // End try
        catch (Exception e) {
            System.out.println(e.getMessage());
        } // End catch
    }// End constuctor
}// End java
