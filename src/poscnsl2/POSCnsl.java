/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.sql.Connection;


/**
 *
 * @author Butaw
 */
public class POSCnsl {

    /**
     * @param args the command line arguments
     */
    static public Connection con = My_Connection.dbConnection();
    public static void main(String[] args) {
        
       //new mainFrame().setVisible(true);
      new LoginSystem().setVisible(true);
        //frame.ReadResolution();
    /*    WindowResolution res = new WindowResolution();
        res.saveResolution();
        res.ReadResolution();*/

    }

}
