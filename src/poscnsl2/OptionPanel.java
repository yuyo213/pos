/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import static poscnsl2.mainFrame.PanelFrame;
import static poscnsl2.mainFrame.panelOption;

/**
 *
 * @author Butaw
 */
public class OptionPanel extends javax.swing.JPanel {

    /**
     * Creates new form OptionPanel
     */
    Connection con = My_Connection.dbConnection();

    public OptionPanel() {
        initComponents();
        update2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBack = new javax.swing.JLabel();
        panelTabs = new javax.swing.JPanel();
        panelTable = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        crudPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfItemName = new javax.swing.JTextField();
        tfItemPrice = new javax.swing.JTextField();
        tfItemQuan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfItemCode = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        tfItemStock = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        TransPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblViewTab = new javax.swing.JLabel();
        lblCrud = new javax.swing.JLabel();
        lblTransactions = new javax.swing.JLabel();

        lblBack.setBackground(new java.awt.Color(204, 204, 204));
        lblBack.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lblBack.setText("   Back");
        lblBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackMouseExited(evt);
            }
        });

        panelTabs.setLayout(new java.awt.CardLayout());

        panelTable.setBackground(new java.awt.Color(255, 255, 255));
        panelTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jDateChooser1.setDateFormatString("MM-dd-yyyy");
        jDateChooser1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jMonthChooser1.setDayChooser(null);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Seller", "Time", "Date"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel7.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel9.setText("Profit:");

        jLabel10.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel10.setText("Total:");

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTableLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(panelTableLayout.createSequentialGroup()
                        .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTableLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTableLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 162, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelTabs.add(panelTable, "card2");

        crudPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Items"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel1.setText("Item Name:");

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel2.setText("Price:");

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel3.setText("Initial Quantity:");

        tfItemName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        tfItemPrice.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        tfItemQuan.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel4.setText("Item Code:");

        tfItemCode.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        btnAdd.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        btnAdd.setText("Add Item");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        btnUpdate.setText("Update Item");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        btnDelete.setText("Delete Item");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tfItemStock.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel5.setText("Stock Quantity:");

        jLabel6.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel6.setText("ID:");

        lblID.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lblID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout crudPanelLayout = new javax.swing.GroupLayout(crudPanel);
        crudPanel.setLayout(crudPanelLayout);
        crudPanelLayout.setHorizontalGroup(
            crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tfItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tfItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfItemQuan, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(tfItemStock)))
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crudPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfItemCode, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        crudPanelLayout.setVerticalGroup(
            crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(tfItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(tfItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(tfItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(tfItemQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfItemStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(135, 135, 135)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelTabs.add(crudPanel, "card3");

        TransPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout TransPanelLayout = new javax.swing.GroupLayout(TransPanel);
        TransPanel.setLayout(TransPanelLayout);
        TransPanelLayout.setHorizontalGroup(
            TransPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        TransPanelLayout.setVerticalGroup(
            TransPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        panelTabs.add(TransPanel, "card4");

        lblViewTab.setBackground(new java.awt.Color(204, 204, 204));
        lblViewTab.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lblViewTab.setText("Table Infos");
        lblViewTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblViewTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewTabMouseExited(evt);
            }
        });

        lblCrud.setBackground(new java.awt.Color(204, 204, 204));
        lblCrud.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lblCrud.setText("Add Items");
        lblCrud.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblCrud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCrudMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCrudMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCrudMouseExited(evt);
            }
        });

        lblTransactions.setBackground(new java.awt.Color(204, 204, 204));
        lblTransactions.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lblTransactions.setText("Transactions");
        lblTransactions.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTransactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTransactionsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTransactionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTransactionsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblViewTab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCrud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTransactions)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewTab, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCrud, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelTabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(panelTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        panelOption.hide();
        PanelFrame.show();

    }//GEN-LAST:event_lblBackMouseClicked

    private void lblBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseEntered
        lblBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    }//GEN-LAST:event_lblBackMouseEntered

    private void lblBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseExited
        lblBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_lblBackMouseExited

    private void lblViewTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewTabMouseClicked
        // TODO add your handling code here:
        //view table
        panelTabs.removeAll();
        panelTabs.repaint();
        panelTabs.revalidate();
        panelTabs.add(panelTable);
        panelTabs.repaint();
        panelTabs.revalidate();
    }//GEN-LAST:event_lblViewTabMouseClicked

    private void lblViewTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewTabMouseEntered
        // TODO add your handling code here:
        lblViewTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    }//GEN-LAST:event_lblViewTabMouseEntered

    private void lblViewTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewTabMouseExited
        // TODO add your handling code here:
        lblViewTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_lblViewTabMouseExited

    private void lblCrudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrudMouseClicked
        // TODO add your handling code here:
        //crud
        panelTabs.removeAll();
        panelTabs.repaint();
        panelTabs.revalidate();
        panelTabs.add(crudPanel);
        panelTabs.repaint();
        panelTabs.revalidate();
        tfItemCode.requestFocus();
    }//GEN-LAST:event_lblCrudMouseClicked

    private void lblCrudMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrudMouseEntered
        // TODO add your handling code here:
        lblCrud.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    }//GEN-LAST:event_lblCrudMouseEntered

    private void lblCrudMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrudMouseExited
        // TODO add your handling code here:
        lblCrud.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_lblCrudMouseExited

    private void lblTransactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransactionsMouseClicked
        // TODO add your handling code here:
        panelTabs.removeAll();
        panelTabs.repaint();
        panelTabs.revalidate();
        panelTabs.add(TransPanel);
        panelTabs.repaint();
        panelTabs.revalidate();
    }//GEN-LAST:event_lblTransactionsMouseClicked

    private void lblTransactionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransactionsMouseEntered
        // TODO add your handling code here:
        lblTransactions.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    }//GEN-LAST:event_lblTransactionsMouseEntered

    private void lblTransactionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransactionsMouseExited
        // TODO add your handling code here:
        lblTransactions.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_lblTransactionsMouseExited
    private void clear() {
        tfItemCode.setText("");
        tfItemName.setText("");
        tfItemPrice.setText("");
        tfItemQuan.setText("");
        tfItemStock.setText("");
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        PreparedStatement ps;
        ResultSet rs;
        if (tfItemCode.getText().equals("") || tfItemName.getText().equals("") || tfItemPrice.getText().equals("")
                || tfItemQuan.getText().equals("") || tfItemStock.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Input Somethin first");
        } else {
            String query1 = "insert into itemLists(code,itemName,itemQuantity,itemPrice,itemStock)values('" + tfItemCode.getText() + "','" + tfItemName.getText()
                    + "','" + tfItemQuan.getText() + "','" + tfItemPrice.getText() + "','" + tfItemStock.getText() + "')";
            try {
                ps = con.prepareStatement(query1);

                int i = ps.executeUpdate();
                if (i >= 1) {
                    JOptionPane.showMessageDialog(null, tfItemName.getText() + " Data Saved!");//if 1
                    clear();
                    update2();

                } else {
                    JOptionPane.showMessageDialog(null, tfItemName.getText() + "Failed to Save!");//else 1

                }
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        PreparedStatement ps;
        try {
            String query = "Update itemLists set itemPrice=?,itemName=?,itemQuantity=?,itemStock=?,code=? where ID=?";
            ps = con.prepareStatement(query);
            ps.setString(6, lblID.getText());
            ps.setString(1, tfItemPrice.getText());
            ps.setString(2, tfItemName.getText());
            ps.setString(3, tfItemQuan.getText());
            ps.setString(4, tfItemStock.getText());
            ps.setString(5, tfItemCode.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item Updated");
            update2();
            /*int input = JOptionPane.showOptionDialog(null, "Item Updated", "New Account",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (input == JOptionPane.OK_OPTION) {

            }*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        PreparedStatement pst;

        String query = "DELETE FROM `itemLists` WHERE `code` ='" + tfItemCode.getText() + "'";
//                String query = "delete from client_info where id=?";
        try {
            pst = con.prepareStatement(query);
            JOptionPane.showMessageDialog(null, "Item Deleted");
            pst.executeUpdate();
            pst.close();
            update2();
        } catch (SQLException ex) {
            Logger.getLogger(OptionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        update2();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int i = jTable1.getSelectedRow();
//        model.getValueAt(i, 0).toString();
        lblID.setText(model.getValueAt(i, 0).toString());
        tfItemName.setText(model.getValueAt(i, 1).toString());
        tfItemCode.setText(model.getValueAt(i, 2).toString());
        tfItemQuan.setText(model.getValueAt(i, 3).toString());
        tfItemPrice.setText(model.getValueAt(i, 4).toString());
        tfItemStock.setText(model.getValueAt(i, 5).toString());

    }//GEN-LAST:event_jTable1MouseClicked
    private void update2() {
        try {
            PreparedStatement pst;
            ResultSet rs;
            //   String sql = "select * from itemLists";
            String sql = "select ID,itemName as Item,code as Code,itemQuantity as Quantity,itemPrice as Price,itemStock as Stock  from itemLists";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TransPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel crudPanel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblCrud;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTransactions;
    private javax.swing.JLabel lblViewTab;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel panelTabs;
    private javax.swing.JTextField tfItemCode;
    private javax.swing.JTextField tfItemName;
    private javax.swing.JTextField tfItemPrice;
    private javax.swing.JTextField tfItemQuan;
    private javax.swing.JTextField tfItemStock;
    // End of variables declaration//GEN-END:variables
}
