/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Butaw
 */
public class POSCnsl {

    /**
     * @param args the command line arguments
     */
        
            static final void panelChanger(JPanel parentPanel, JPanel panel) {
                parentPanel.removeAll();
                parentPanel.repaint();
                parentPanel.revalidate();
                parentPanel.add(panel);
                parentPanel.repaint();
                parentPanel.revalidate();

            }
            static final void aesthetic(JLabel label, int checker, Color any) {
                label.setBorder(javax.swing.BorderFactory.createBevelBorder(checker));
                label.setForeground(any);
            }
        
        
    
    public static void main(String[] args) {
       
       
    }
}
