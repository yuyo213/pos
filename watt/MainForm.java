/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;
import javax.swing.*;
import java.util.*;


/**
 *
 * @author Butaw
 */
public class MainForm {
    
    public void MainForm(){
         
        Scanner sc = new Scanner(System.in);
        Scanner disc = new Scanner(System.in);
        int input, dd;
        double discountPercent, discountResult, d2, discount, money, exchange, price;
        String opt;
        LinkedList<String> Items = new LinkedList<String>(); // item
        List<Integer> Price = new LinkedList<>(); // price
        Items.add("Potato");//1
        Items.add("Chips"); // 2
        Items.add("BBQ");// 3
        Price.add(100);
        Price.add(50);
        Price.add(150);

        System.out.println();

        for (int i = 0; i < Items.size(); i++) {
            System.out.print(Items.get(i) + ":");
            System.out.println(Price.get(i) + " Pesos");
        }

        System.out.println("Enter id  0-2");
        //System.out.println(Items.size());
        input = sc.nextInt();
        while (input >= Items.size()) {
           JOptionPane.showMessageDialog(null,"Invalid Input!\nTry Again: ");
            input = sc.nextInt();
        }
        // System.out.println(Items.get(input)+"\n"+Price.get(input)+" Pesos");
        dd = Price.get(input);
        System.err.println(dd);
        System.out.print("Money: ");
        money = sc.nextInt();

        //check if money inputed is too low to the price of item
        while (money < dd) {
            JOptionPane.showMessageDialog(null,"Money is too low!\nEnter again: ");
            money = sc.nextInt();
        }
        //discount system
        System.out.println("Do you Have discount ?Y/N: ");
        opt = disc.nextLine();
        if (opt.equals("Y") || opt.equals("y")) {
             JOptionPane.showInputDialog(null,"Input Discount: ");
            discount = sc.nextDouble();

            //Check if discount is larger than 100%
            while (discount > 100) {
                 JOptionPane.showMessageDialog(null,"Discount too high!\nInput a Discount again: ");
                discount = sc.nextDouble();
            }

            /*calculation shits
              dd = item price */
            discountPercent = discount / 100; //10 /100 =  0.1  
            d2 = discountPercent * dd; // 0.1 * 150 = 15
            discountResult = dd - d2; // 150 - 15 = 135
            System.out.println(discountPercent);
            System.out.println(d2);
            System.out.println(discount + "% Discount: " + discountResult);
            exchange = money - discountResult;
            System.out.println("Exchange: " + exchange + " Pesos");
        } else if (opt.equals("N") || opt.equals("n")) {
            exchange = money - dd;
            System.out.println("Exchange: " + exchange + " Pesos");

        } else {
            System.out.println("Invalid !");
            exchange = money - dd;
            System.out.println("Exchange: " + exchange + " Pesos");

        }
    }

}
        
