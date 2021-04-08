/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.sql.*;

/**
 *
 * @author Butaw
 */
public class My_Connection {

    Connection con;
    Connection cons;

    public static Connection dbConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:db.db");
            //Connection cons=DriverManager.getConnection("jdbc:sqlite:data2.db");
             System.err.println("Connection Successful!");
//					JOptionPane.showMessageDialog(null, "Connection Succesful");
            return con;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return null;
        }
    }
}
