/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static poscnsl2.POSCnsl.checkerExist;

/**
 *
 * @author Butaw
 */
public class LoginEvents {

    private static final LoginEvents logEvts = new LoginEvents();
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private String Name, userName, Password, ConfirmPassword, warnMessage, cashier, userPos;
    private final String pos = "Seller";

    private LoginEvents() {

    }

    public static LoginEvents getInstance() {
        return logEvts;
    }

    /*------------Time Card - IN-----------*/
    public void timeIn() {
        Date d;
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dbD = new SimpleDateFormat("MM-dd-yyyy");
        String curTime = time.format(d = new Date());
        String todate = dbD.format(d = new Date());
        String currentlyOnline = "Currently Online";

        try {
            String query = "Insert into timecard(Name,tIn,tOut,date)values(?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, getCashier());
            pst.setString(2, curTime);
            pst.setString(3, currentlyOnline);
            pst.setString(4, todate);
            pst.execute();
            pst.close();
            //  con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Occur");
            JOptionPane.showMessageDialog(null, e);
            try {
                con.rollback();
            } catch (SQLException ex) {
            }
        }

    }


 /*------------Create Account-----------*/
    public void createAccount() {
        con = Main_Connection.getConnection();
        if (!checkerExist(getUserName(), "userlogin", "uName"))// check on db if user exist if not then proceed
        {
            try {
                String query = "Insert into userlogin(Name,uPos,uName,uPass)values(?,?,?,?)";
                pst = con.prepareStatement(query);
                pst.setString(1, getName());
                pst.setString(2, pos);
                pst.setString(3, getUserName());
                pst.setString(4, getPassword());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Created Successfully!");
                pst.close();
                con.close();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    /*------------Login Account-----------*/
    public void loginAction() {
        // PreparedStatement pst;
        // System.out.println(curTime);
        con = Main_Connection.getConnection();
        mainFrame form = mainFrame.getInstance();
        try {
            String query = "Select * from userlogin where uName=? and uPass=?";
            pst = con.prepareStatement(query);
            pst.setString(1, getUserName());
            pst.setString(2, getPassword());
            rs = pst.executeQuery();
            if (rs.next()) {
                if (getPassword().equals(rs.getString("uPass")) && getUserName().equals(rs.getString("uName"))) {
                    setCashier(rs.getString("Name"));
                    setUserPos(rs.getString("uPos"));
                    if (getUserPos().equals("Seller")) {//checking if seller
                        System.out.println("WOOOOOOW you're an seller");
                        form.seller();
                    } else {//if not
                        System.out.println("WOOOOOOW you're an admin");
                        form.admin();
                    }
                    form.user(getCashier());
                  //  timeIn();
                    form.setVisible(true);
                    form.pack();
                    form.setLocationRelativeTo(null);

                }
            } else {
                setWarnMessage("Login Failed, Check your user and password!");
            }
            // Decrypt(logPass);
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            //  JOptionPane.showMessageDialog(null, "Wrong User and Pass");
            JOptionPane.showMessageDialog(null, e);
            try {
                con.rollback();
            } catch (Exception ex) {
            }
        }

    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the ConfirmPassword
     */
    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    /**
     * @param ConfirmPassword the ConfirmPassword to set
     */
    public void setConfirmPassword(String ConfirmPassword) {
        this.ConfirmPassword = ConfirmPassword;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the warnMessage
     */
    public String getWarnMessage() {
        return warnMessage;
    }

    /**
     * @param warnMessage the warnMessage to set
     */
    public void setWarnMessage(String warnMessage) {
        this.warnMessage = warnMessage;
    }

    /**
     * @return the cashier
     */
    public String getCashier() {
        return cashier;
    }

    /**
     * @param cashier the cashier to set
     */
    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    /**
     * @return the userPos
     */
    public String getUserPos() {
        return userPos;
    }

    /**
     * @param userPos the userPos to set
     */
    public void setUserPos(String userPos) {
        this.userPos = userPos;
    }
}
