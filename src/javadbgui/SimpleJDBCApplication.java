package javadbgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.awt.*;


public class SimpleJDBCApplication {

    static final String DB_URL = "jdbc:mysql://localhost:3306/courses";
    static final String DB_DRV = "com.mysql.cj.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    
    public static void printUser(){
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            // make sure driver is reachable
            Class.forName(DB_DRV);
            
            // establish connection to server
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM student");

            while (resultSet.next()) {
                System.out.printf("%s\t%s\t%s\n",
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
                    
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultSet.close();
                connection.close();
            } catch (SQLException ex) {
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Enroll In Classes");
        
        // Create button object to submit form
        JButton button = new JButton("Enroll");
        
        // Create panel and adjust sizing
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(400, 300, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        
        // Add button to panel
        panel.add(button);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Enroll");
        frame.pack();
        frame.setVisible(true);
        
        
    }
}
