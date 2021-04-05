/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Butaw
 */
public class Items {

    String iName;
    protected double price;
    Connection con = (Connection) My_Connection.dbConnection();

    public void saveItem(String ItemName) {
        //Serve as db 
        // <--Create an item!-->
        String iName;
        int barCode;
        Scanner sPrice = new Scanner(System.in);
        Scanner sName = new Scanner(System.in);
        Scanner sCode = new Scanner(System.in);
        PreparedStatement pst;
        ResultSet rs;
        barCode = sCode.nextInt();
        iName = sName.nextLine();
        price = sPrice.nextDouble();
        try {
            String query = "Insert into itemLists(code,itemName,itemPrice) values(?,?,?)";
            pst = con.prepareStatement(query);
            pst.setInt(0, barCode);
            pst.setString(1, iName);
            pst.setDouble(2, price);
            pst.execute();
            System.out.println("I Put it in Database!");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void readItem() {
        //Serve as readerDb
        PreparedStatement pst;
        ResultSet rs;
        try {
            String query = "SELECT * FROM itemLists";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("-------------------");
                System.out.print("Item Name: ");
                System.out.println(rs.getString("itemName"));
                System.out.print("Price: ");
                System.out.println(rs.getDouble("itemPrice"));
                System.out.println("-------------------");
            }
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readTransactions() {
        //Sum up all transactions
        PreparedStatement pst;
        ResultSet rs;
        try {
            //  String query = "SELECT * FROM transLists\n WHERE date='3-25-2021'"; // like searching for someting

            String query = "SELECT  sum(tPrice) as overs FROM transLists ";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {

                System.out.println("-------------------");
                System.out.print("Equals: ");
                System.out.println(rs.getDouble("overs"));
                System.out.println("-------------------");

            }

            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int n) {
        this.price = n;
    }

}
