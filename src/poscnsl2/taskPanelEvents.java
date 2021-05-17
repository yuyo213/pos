/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static poscnsl2.POSCnsl.checkerExist;
import static poscnsl2.POSCnsl.tableUpdates;

/**
 *
 * @author Butaw
 */
public class taskPanelEvents {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private String itemName, itemCode, itemID;
    private int itemStock, itemQuantity;
    private float itemPrice;

    private static final taskPanelEvents taskEvent = new taskPanelEvents();

    private taskPanelEvents() {

    }

    public static taskPanelEvents getInstance() {
        return taskEvent;
    }

    public void addButton(JTable tableAddItem) {
        con = Main_Connection.getConnection();
        if (!checkerExist(getItemName(), "itemlists", "itemName")) { // check item if its already exist
            try {
                String query1 = "insert into itemlists(code,itemName,itemQuantity,itemPrice,itemStock)values('" + getItemCode()
                        + "','" + getItemName() + "','" + getItemQuantity()
                        + "','" + getItemPrice() + "','" + getItemStock() + "')";
                pst = con.prepareStatement(query1);
                int i = pst.executeUpdate();
                if (i >= 1) {
                    JOptionPane.showMessageDialog(null, getItemName() + " Data Saved!");//if 1
                    updateItems(tableAddItem);
                    // clear();
                } else {
                    JOptionPane.showMessageDialog(null, getItemName() + "Failed to Save!");//else 1

                }
                pst.close();
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                try {
                    con.rollback();
                } catch (SQLException x) {
                }
            }
        }
    }

    public void updateButton(JTable tableAddItem) {
     con = Main_Connection.getConnection();
        try {
            String query = "Update itemlists set itemPrice=?,itemName=?,itemQuantity=?,itemStock=?,code=? where ID=?";
            pst = con.prepareStatement(query);
            pst.setString(6, getItemID());
            pst.setFloat(1, getItemPrice());
            pst.setString(2, getItemName());
            pst.setInt(3, getItemQuantity());
            pst.setInt(4, getItemStock());
            pst.setString(5, getItemCode());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item Updated");
            updateItems(tableAddItem);
            //  clear();
            /*int input = JOptionPane.showOptionDialog(null, "Item Updated", "New Account",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if (input == JOptionPane.OK_OPTION) {

                }*/
            pst.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            try {
                con.rollback();
            } catch (SQLException x) {
            }
        }
    }

    public void deleteButton(JTable tableAddItem) {
    con = Main_Connection.getConnection();
        try {
            String query = "DELETE FROM `itemlists` WHERE `code` ='" + getItemCode() + "'";
            pst = con.prepareStatement(query);
            JOptionPane.showMessageDialog(null, "Item Deleted");
            pst.executeUpdate();
            updateItems(tableAddItem);
            // clear();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            try {
                con.rollback();
            } catch (SQLException x) {
            }
        }
    }

    public void viewTable(JTable tableMonth, JDateChooser jDateChooser1) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        if (jDateChooser1.getDate() == null) {
            // transTable(tableMonth);
            DefaultTableModel table = (DefaultTableModel) tableMonth.getModel();  //table sorter
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
            tableMonth.setRowSorter(tr);
        } else {
            // transTable(tableMonth);
            DefaultTableModel table = (DefaultTableModel) tableMonth.getModel();  //table sorter
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
            tableMonth.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(sdf.format(jDateChooser1.getDate())));
        }
    }

    public void updateItems(JTable tableAddItem) {// print all data in itemName in tableAddItem
        String sql = "select ID,itemName as Item,code as Code,itemQuantity as Quantity,itemPrice as Price,itemStock as Stock  from itemlists";
        tableUpdates(tableAddItem, sql);
    }

    public void transTable(JTable tableMonth) {

        String sql = "Select `transID` as `Transaction ID`,`Seller` as `Cashier Name`,transPrice as Total,transDate as Date from tableoftrans";
        tableUpdates(tableMonth, sql);
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the itemStock
     */
    public int getItemStock() {
        return itemStock;
    }

    /**
     * @param itemStock the itemStock to set
     */
    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    /**
     * @return the itemQuantity
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * @param itemQuantity the itemQuantity to set
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * @return the itemPrice
     */
    public float getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
}
