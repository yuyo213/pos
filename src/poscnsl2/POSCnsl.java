/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;

/**
 *
 * @author Butaw
 */
public class POSCnsl {

    static Connection con = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    /**
     * @param args the command line arguments
     */
    //panel changer
    static final void panelChanger(JPanel parentPanel, JPanel panel) {
        parentPanel.removeAll();
        parentPanel.repaint();
        parentPanel.revalidate();
        parentPanel.add(panel);
        parentPanel.repaint();
        parentPanel.revalidate();

    }
    //labels in exit,taskOption

    static final void aesthetic(JLabel label, int checker, Color any) {
        label.setBorder(javax.swing.BorderFactory.createBevelBorder(checker));
        label.setForeground(any);
    }

    static final boolean checkerExist(String input, String table, String field) {//check username/uName if exist
        con = Main_Connection.getConnection();
        boolean user_exist = false;

        String query = "SELECT uName FROM " + table + " WHERE " + field + " = ?";

        try {
            pst = con.prepareStatement(query);
            pst.setString(1, input);
            rs = pst.executeQuery();

            if (rs.next()) {
                user_exist = true;
                JOptionPane.showMessageDialog(null, "Already Exist", "Failed", 2);

            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return user_exist;
    }

    static final void tableUpdates(JTable table, String sql) {// print all data in itemName in tableAddItem
       con = Main_Connection.getConnection();
        try {
            //   String sql = "select * from itemLists";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
