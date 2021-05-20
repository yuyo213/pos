/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Butaw
 */
public class Main_Connection {
    private static String servername="localhost";
     private static String username="root";
    private static String dbname="pos_db";
    private static Integer portnumber=3306;
    private static String password="";
    public static Connection getConnection(){
        
        Connection Con = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        try{
            
        
        Con = datasource.getConnection();
        }catch(SQLException ex){
            Logger.getLogger("UwU"+Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Con;
    }

}
