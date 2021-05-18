/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static poscnsl2.POSCnsl.tableUpdates;

/**
 *
 * @author Butaw
 */
public class mainFrameEvents {

    HashMap<String, Integer> map;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private static final mainFrameEvents mEvents = new mainFrameEvents();

    public static mainFrameEvents getInstance() {

        return mEvents;
    }

    private mainFrameEvents() {

        map = new HashMap<>();

    }
    private String itemName, transactionID, timeToday, dateToday, cashierName, time, cID;
    private int itemQuantity, currentStock, totalStock, totalQuantity;
    private float itemPrice, moneyExchange, money, displayAllTotal;

    /*-----------Add item to table-----------*/
    public void addToCart(JTable tableSoldItems, JTable tableStock) {
        DefaultTableModel dtm = (DefaultTableModel) tableSoldItems.getModel();

        float totalPrice = getItemPrice() * getItemQuantity();
        if (!map.containsKey(getItemName())) {
            map.put(getItemName(), getItemQuantity());
            dtm.addRow(new Object[]{getItemName(), totalPrice, map.get(getItemName())});
        } else {
            // add();
            soldItem('+', getItemQuantity(), tableSoldItems);
        }
        operators('-', getItemQuantity(), tableStock);
        getSum(tableSoldItems);
    }

    /*-----------Delete item to table-----------*/
    public void deleteToCart(JTable tableSoldItems, JTable tableStock) {
        DefaultTableModel dtm = (DefaultTableModel) tableSoldItems.getModel();
        int i = tableSoldItems.getSelectedRow();
        if (i >= 0) {
            int Squant = Integer.parseInt(dtm.getValueAt(i, 2) + "");
            String input = JOptionPane.showInputDialog("Input qty", Squant);
            if (!input.isEmpty()) {
                soldItem('-', Integer.parseInt(input), tableSoldItems);
                operators('+', Integer.parseInt(input), tableStock);
            }
            if (dtm.getValueAt(i, 2).equals(0)) {
                String name = (String) dtm.getValueAt(i, 0);
                map.remove(name);
                dtm.removeRow(i);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Delete Error");
        }
        getSum(tableSoldItems);

    }

    /*-----------Cash Out-----------*/
    public void cashOut(JTextArea jTextArea1, JTable tableSoldItems, JTable tableStock) {
        con = Main_Connection.getConnection();
        DefaultTableModel dtm = (DefaultTableModel) tableSoldItems.getModel();
        String moneys = JOptionPane.showInputDialog("Input Money");
        if (moneys == null || (" ".equals(moneys))) {
            JOptionPane.showMessageDialog(null, "empty Fields");
        } else {
            setMoney(Float.parseFloat(moneys));
            if (getMoney() < getDisplayAllTotal() || moneys.equals("0")) {
                JOptionPane.showMessageDialog(null, "Please Try again", "Invalid", 2);
            } else {

                float result = getMoney() - getDisplayAllTotal();
                setMoneyExchange(result);
                printhead(jTextArea1);
                try {
                    for (int i = 0; i < tableSoldItems.getRowCount(); i++) {
                        String tableQuery = "Insert into translists(transactionID,tName,tPrice,tQuant)values(?,?,?,?)";
                        pst = con.prepareStatement(tableQuery);
                        pst.setString(1, getTransactionID());
                        pst.setString(2, dtm.getValueAt(i, 0).toString());
                        pst.setString(3, dtm.getValueAt(i, 1).toString());
                        pst.setString(4, dtm.getValueAt(i, 2).toString());
                        pst.execute();
                    }
                    pst.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error Occured!");
                    try {
                        con.rollback();
                    } catch (SQLException ex) {
                    }
                }
                try {
                    String recieptSearch = " select i.itemPrice as initPrice,t.tQuant,t.tName,t.tPrice from itemlists as i,translists as t"
                            + " where t.transactionID = ? and t.tName = i.itemName";
                    pst = con.prepareStatement(recieptSearch);
                    pst.setString(1, getTransactionID());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        //  setInit(rs.getString("initPrice"));
                        String inPrice = rs.getString("initPrice");
                        // String total = (String) tableSoldItems.getValueAt(i, 1);
                        String totPrice = rs.getString("tPrice");
                        String iname = rs.getString("tName");
                        String quan = rs.getString("tQuant");
                        //  String iname = (String) tableSoldItems.getValueAt(i, 0);
                        // String quan = (String) tableSoldItems.getValueAt(i, 2);
                        jTextArea1.append(quan + " "
                                + iname + " @ " + inPrice
                                + "\t" + totPrice + "V" + " \n ");
                    }
                    rs.close();
                    pst.close();
                    printfoot(jTextArea1);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error Occured!!");
                    try {
                        con.rollback();
                    } catch (SQLException ex) {
                    }
                }
                try {
                    String tableOfTrans = "Insert into tableoftrans(transID,Seller,transPrice,TransMoney,transDate)values(?,?,?,?,?)";
                    pst = con.prepareStatement(tableOfTrans);
                    pst.setString(1, getTransactionID());
                    pst.setString(2, getCashierName());
                    pst.setFloat(3, getDisplayAllTotal());
                    pst.setFloat(4, getMoney());
                    pst.setString(5, getDateToday());
                    pst.execute();
                    pst.close();
                    stockUpdate(tableStock);
                    JOptionPane.showMessageDialog(null, "Transaction success!");
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error Occured!!!");
                    try {
                        con.rollback();
                    } catch (SQLException ex) {
                    }
                }
            }
        }
    }

    /*-----------Update Stock when new transaction-----------*/
    private void stockUpdate(JTable tableStock) {// updating stock when new transaction action event happen
        int row = tableStock.getRowCount();
        try {
            String query = "Update itemlists set itemStock=? where ID=?";
            pst = con.prepareStatement(query);
            for (int i = 0; i < row; i++) {
                int stock = (int) tableStock.getValueAt(i, 2);
                int id = (int) tableStock.getValueAt(i, 0);
                pst.setInt(1, stock);
                pst.setInt(2, id);
                pst.executeUpdate();
            }
            pst.close();
            updateTableStock(tableStock);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void updateTableStock(JTable table) {// get the database columns and its rows
        String sql = "select ID,`itemName` as `Item Name`,`itemStock` as `Item Stock` from itemlists";
        tableUpdates(table, sql);
    }

    /*-----------Manipulate item to table-----------*/
    private void soldItem(char opt, int quan, JTable tableSoldItems) {
        float resultPrice = getItemPrice() * quan;
        DefaultTableModel dtm = (DefaultTableModel) tableSoldItems.getModel();
        for (int i = 0; i < tableSoldItems.getRowCount(); i++) {
            if (dtm.getValueAt(i, 0).equals(getItemName())) {
                map.put(getItemName(), quan);
                float tblPrice = Float.parseFloat(dtm.getValueAt(i, 1) + "");
                int num1 = Integer.parseInt(dtm.getValueAt(i, 2) + "");
                int result;
                float priceResult;
                switch (opt) {
                    case '+':
                        result = quan + num1;
                        priceResult = resultPrice + tblPrice;
                        dtm.setValueAt(priceResult, i, 1);
                        dtm.setValueAt(result, i, 2);
                        break;
                    case '-':
                        result = num1 - quan;
                        priceResult = tblPrice - resultPrice;
                        dtm.setValueAt(priceResult, i, 1);
                        dtm.setValueAt(result, i, 2);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Error,Try Again");
                        break;
                }
            }
        }
    }

    /*-----------Manipulate item to tableStock-----------*/
    private void operators(char operator, int bItem, JTable tableStock) {//checking stock in the itemviewer if stock not enough 
        DefaultTableModel tb1 = (DefaultTableModel) tableStock.getModel();
        for (int i = 0; i < tb1.getRowCount(); i++) {//nested loop (brute force)
            if (tb1.getValueAt(i, 1).equals(getItemName())) {//check if tablestock == to iName
                int tStock = (int) tb1.getValueAt(i, 2);
                switch (operator) {
                    case '+'://for delete button to add up the deleted item stock
                        int result = tStock + bItem;
                        System.out.println(result);
                        // setTotal((int) jTable1.getValueAt(i, 2) - result);
                        tb1.setValueAt(result, i, 2);
                        break;
                    case '-': //for add button to minus item stock
                        result = tStock - bItem;
                        System.out.println(result);
                        // setTotal((int) jTable1.getValueAt(i, 2) - result);
                        tb1.setValueAt(result, i, 2);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Error");
                }
            }
        }
    }

    /*-----------Time Card -  Out -----------*/
    public void timeOut() {
        con = Main_Connection.getConnection();
        try {
            String query = "Update timecard set tOut=? where tOut='Currently Online'";
            pst = con.prepareStatement(query);
            pst.setString(1, getTime());
            // pst.setString(2, getcID());
            pst.executeUpdate();
            pst.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Occur");
            try {
                con.rollback();
            } catch (SQLException x) {
            }
        }
    }

    /*-----------Total Bought-----------*/
    private float getSum(JTable tableSoldItems) {// get sum code or total 
        float tot = 0;
        int total = 0;
        for (int i = 0; i < tableSoldItems.getRowCount(); i++) {
            tot += Float.parseFloat(tableSoldItems.getValueAt(i, 1).toString());
            total += Integer.parseInt(tableSoldItems.getValueAt(i, 2).toString());

        }
        setDisplayAllTotal(tot);
        setTotalQuantity(total);
        System.out.println(total + " new Total Item from Getsum()");
        return tot;
    }

    /*-----------Auto Sum Stocks-----------*/
    public int autoSum() {
        int c;
        c = getCurrentStock() - getItemQuantity();
        setCurrentStock(c);
        return c;
    }

    public int autoSum2() {// summin up the total - quantity of item = current stock and print to field
        int c;

        if (getTotalStock() == 0 || getItemQuantity() == 0) {
            setCurrentStock(0);
            setItemQuantity(0);
            c = 0;
            setCurrentStock(c);

            c = getCurrentStock() - getItemQuantity();
            return (int) c;
        } else {
            //    a = Integer.parseInt(lblCurStock.getText());
            //a = Integer.parseInt(lblTotStock.getText());
            //   b = Integer.parseInt(tfQuantity.getText());
            if (getCurrentStock() < getItemQuantity()) {
                //  JOptionPane.showMessageDialog(null, "no negative number bois", "Invalid Input", 2);
                setItemQuantity(getCurrentStock());
                c = getCurrentStock() - getItemQuantity();
                setCurrentStock(c);

                return (int) c;
            }
            c = getCurrentStock() - getItemQuantity();
            setCurrentStock(c);

        }

        return (int) c;

    }

    public void clear() {//clear fields
        //Thread.sleep(150);
        setItemName("");
        setItemPrice(0);
        setItemQuantity(0);
        setTotalStock(0);
        setCurrentStock(0);
    }

    /*-----------Search item using id or barcode -----------*/
    public void idCode(String value, String sText, JTable tableSoldItems, JTable tableStock, JButton badd, JTextField id, JTextField code) {
        con = Main_Connection.getConnection();
        //searching id or code in the database if exist fill the fields with its contents
        int flg = 0;
        try {
            String query = "Select * from itemlists where " + value + "=?";
            pst = con.prepareStatement(query);
            pst.setString(1, sText);
            rs = pst.executeQuery();
            if (rs.next() && flg == 0) {
                float iPrice = rs.getFloat("itemPrice");
                setItemName(rs.getString("itemName"));
                setItemPrice(iPrice);
                setItemQuantity(rs.getInt("itemQuantity"));
                setTotalStock(rs.getInt("itemStock"));
                CurStock(tableSoldItems, tableStock, badd, id, code);
                autoSum2();
            } else if (flg == 0) {
                flg = 1;
                clear();

            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /*-----------Current Stock in tableStock -----------*/
    public void CurStock(JTable tableSoldItems, JTable tableStock, JButton badd, JTextField id, JTextField code) {// check if tableSold items has a item(row) or not
        DefaultTableModel dtm = (DefaultTableModel) tableSoldItems.getModel();
        if (dtm.getRowCount() == 0) {
            jtabs(tableStock, badd, id, code);
        } else {
            jtabs(tableStock, badd, id, code);
        }

    }

    /*-----------Check if tableStock had Stock -----------*/
    private void jtabs(JTable tableSoldItems, JButton badd, JTextField id, JTextField code) {// check tablestock stock 
        DefaultTableModel tb1 = (DefaultTableModel) tableSoldItems.getModel();
        for (int i = 0; i < tableSoldItems.getRowCount(); i++) {
            for(int j= 0; j< tableSoldItems.getColumnCount(); j++){
            if (tableSoldItems.getModel().getValueAt(i, j).equals(getItemName())) {
                setCurrentStock(Integer.parseInt(tb1.getValueAt(i, 2) + ""));
                if (getCurrentStock() <= 0) {// if stock is equal to 0
                    JOptionPane.showMessageDialog(null, getItemName() + " is Out Of Stock, Sorry");
                    badd.setEnabled(false);
                    id.setText("");
                    code.setText("");
                    clear();
                } else {
                    badd.setEnabled(true);
                }
            }
        }
        }
    }

    /*-----------New Transaction-----------*/
    public void newTransaction(JTextArea jTextArea1, JTable tableSoldItems, JTable tableStock) {

        try {
            // jTextArea1.print();

            PrintWriter out = new PrintWriter("transactions\\" + getTransactionID());
            out.print(jTextArea1.getText());
            out.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        updateTableStock(tableStock);
        clear();
        transIDs();
        id();
    }

    public void startTran(JTable tableStock) {
        updateTableStock(tableStock);
        clear();
        transIDs();
        id();
    }

    /*-----------Reciept Print -----------*/
    private void printhead(JTextArea ta) {

        ta.setText("TRANSACTION#: " + getTransactionID()
                + "\n" + "CASHIER: " + getCashierName() + "\n" + "DATE: " + getDateToday() + "             TIME:  " + getTime() + "\n"
                + "----------------------------------------------------------\n");
    }

    private void printfoot(JTextArea ta) {
        ta.append("---------------- " + getTotalQuantity() + " Total item(s) ----------------------\n"
                + "TOTAL            " + getDisplayAllTotal() + "\n" + "CASH             "
                + getMoney() + "\n" + "CHANGE           " + getMoneyExchange() + "\n"
                + "----------------------------------------------------------\n"
                + "               Thank You For Shopping!\n                      Have a Nice Day!");
    }

    private void id() {
        con = Main_Connection.getConnection();
        try {
            String query = "Select transactionID from translists where transactionID = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, getTransactionID());
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("transactionID").equals(getTransactionID())) {
                    transIDs();
                }
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {

        }
    }

    private void transIDs() {//transaction id using random generated numbers
        //System.out.println(uniqueID);
        try {
            SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");

            //generate a random number
            String randomNum = Integer.toString(prng.nextInt());

            //get its digest
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] result = sha.digest(randomNum.getBytes());

            //System.out.println("Random number: " + randomNum);
            setTransactionID(randomNum);
            //  System.out.println("Message digest");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }

    public void tableClick(JTable tableSoldItems) {
        con = Main_Connection.getConnection();
        DefaultTableModel dtm = (DefaultTableModel) tableSoldItems.getModel();
        int selectedRowIndex = tableSoldItems.getSelectedRow();

        try {
            String query = "SELECT * FROM `itemlists` WHERE `itemName` = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, (String) dtm.getValueAt(selectedRowIndex, 0));
            rs = pst.executeQuery();
            if (rs.next()) {
                setItemName(rs.getString("itemName"));
                setTotalStock(rs.getInt("itemStock"));
                setItemQuantity(rs.getInt("itemQuantity"));
                setItemPrice(rs.getFloat("itemPrice"));
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
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
     * @return the transactionID
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * @param transactionID the transactionID to set
     */
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    /**
     * @return the timeToday
     */
    public String getTimeToday() {
        return timeToday;
    }

    /**
     * @param timeToday the timeToday to set
     */
    public void setTimeToday(String timeToday) {
        this.timeToday = timeToday;
    }

    /**
     * @return the dateToday
     */
    public String getDateToday() {
        return dateToday;
    }

    /**
     * @param dateToday the dateToday to set
     */
    public void setDateToday(String dateToday) {
        this.dateToday = dateToday;
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
     * @return the currentStock
     */
    public int getCurrentStock() {
        return currentStock;
    }

    /**
     * @param currentStock the currentStock to set
     */
    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    /**
     * @return the totalStock
     */
    public int getTotalStock() {
        return totalStock;
    }

    /**
     * @param totalStock the totalStock to set
     */
    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
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
     * @return the moneyExchange
     */
    public float getMoneyExchange() {
        return moneyExchange;
    }

    /**
     * @param moneyExchange the moneyExchange to set
     */
    public void setMoneyExchange(float moneyExchange) {
        this.moneyExchange = moneyExchange;
    }

    /**
     * @return the totalQuantity
     */
    public int getTotalQuantity() {
        return totalQuantity;
    }

    /**
     * @param totalQuantity the totalQuantity to set
     */
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    /**
     * @return the displayAllTotal
     */
    public float getDisplayAllTotal() {
        return displayAllTotal;
    }

    /**
     * @param displayAllTotal the displayAllTotal to set
     */
    public void setDisplayAllTotal(float displayAllTotal) {
        this.displayAllTotal = displayAllTotal;
    }

    /**
     * @return the money
     */
    public float getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(float money) {
        this.money = money;
    }

    /**
     * @return the cashierName
     */
    public String getCashierName() {
        return cashierName;
    }

    /**
     * @param cashierName the cashierName to set
     */
    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the cID
     */
    public String getcID() {
        return cID;
    }

    /**
     * @param cID the cID to set
     */
    public void setcID(String cID) {
        this.cID = cID;
    }
}
