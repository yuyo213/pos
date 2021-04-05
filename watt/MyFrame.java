/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Butaw
 */
public class MyFrame {

    int w, h;
    JFrame frame;
    JPanel framePanel;
    JPanel optPanel;
    JPanel mPanel;
    JButton b1;
    JButton b2;
    JButton b3;
    JTextField fInput;
    JComboBox<String> wOpt;
    String wsOpt[] = {"Select a Resolution", "1280x720", "1280x1024"};
    JTextField tfNum1;
    JLabel result = new JLabel();
    JLabel lDate = new JLabel();
    JLabel lTime = new JLabel();
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
    OptionPanel optP;
  
    public void Init() {
        //ReadResolution();
        w=720;h=740;
        frame = new JFrame("Point Of Sale");
        optP = new OptionPanel();
                framePanel = new JPanel();
        frame.add(framePanel);
        frame.setSize(w, h);
        framePanel.setSize(w,h);
        framePanel.add(optP);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }


}
