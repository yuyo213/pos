/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import static poscnsl2.POSCnsl.con;
import static poscnsl2.mainFrame.PanelFrame;
import static poscnsl2.mainFrame.MainPanel;
/**
 *
 * @author Butaw
 */
public class ViewerPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewerPanel
     */
    public ViewerPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemViewer = new javax.swing.JPanel();
        tablePanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableStock = new javax.swing.JTable();
        ItemBack = new javax.swing.JButton();

        tablePanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Item"));

        tableStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item Name", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableStock.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableStock);

        javax.swing.GroupLayout tablePanel1Layout = new javax.swing.GroupLayout(tablePanel1);
        tablePanel1.setLayout(tablePanel1Layout);
        tablePanel1Layout.setHorizontalGroup(
            tablePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );
        tablePanel1Layout.setVerticalGroup(
            tablePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
        );

        ItemBack.setText("Back");
        ItemBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout itemViewerLayout = new javax.swing.GroupLayout(itemViewer);
        itemViewer.setLayout(itemViewerLayout);
        itemViewerLayout.setHorizontalGroup(
            itemViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ItemBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        itemViewerLayout.setVerticalGroup(
            itemViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemBack))
                .addContainerGap(558, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(itemViewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(itemViewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemBackActionPerformed
        // TODO add your handling code here:

        panelChanger(PanelFrame, MainPanel);
    }//GEN-LAST:event_ItemBackActionPerformed
 private void panelChanger(JPanel parentPanel, JPanel panel) {
        parentPanel.removeAll();
        parentPanel.repaint();
        parentPanel.revalidate();
        parentPanel.add(panel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }
  public void updateTableStock() {

        PreparedStatement pst;
        ResultSet rs;
        try {
            //   String sql = "select * from itemLists";
            String sql = "select ID,itemName as Name,itemStock as Stock from itemLists";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            tableStock.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void operators(char operator, String iName, String bItem) {
        DefaultTableModel tb1 = (DefaultTableModel) tableStock.getModel();
        for (int i = 0; i < tableStock.getRowCount(); i++) {
            for (int j = 0; j < tableStock.getColumnCount(); j++) {
                if (tableStock.getModel().getValueAt(i, j).equals(iName)) {
                    System.out.println(tableStock.getValueAt(i, j));
                    int tStock = (int) tableStock.getValueAt(i, 2);
                    int num2 = Integer.parseInt(bItem);
                    switch (operator) {
                        case '+' -> {
                            int result = tStock + num2;
                            System.out.println(result);
                            tableStock.setValueAt(result, i, 2);
                        }
                        case '-' -> {
                            int result = tStock - num2;
                            System.out.println(result);
                            tableStock.setValueAt(result, i, 2);
                        }
                        default -> {
                            JOptionPane.showMessageDialog(null, "Error");
                        }

                    }

                    int tb2 = (int) tb1.getValueAt(i, 2);
                    if (tb2 < 0) {
                        JOptionPane.showMessageDialog(null, "Not enough item");
                    }

                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ItemBack;
    private javax.swing.JPanel itemViewer;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel tablePanel1;
    private javax.swing.JTable tableStock;
    // End of variables declaration//GEN-END:variables
}
