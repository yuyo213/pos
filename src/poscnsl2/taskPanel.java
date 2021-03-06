/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscnsl2;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import static poscnsl2.POSCnsl.panelChanger;
import static poscnsl2.POSCnsl.aesthetic;
import static poscnsl2.mainFrame.MainPanel;
import static poscnsl2.mainFrame.PanelFrame;

/**
 *
 * @author Butaw
 */
public class taskPanel extends javax.swing.JPanel {
    /**
     * Creates new form optionPanel
     */
    private static final taskPanel task = new taskPanel();
    taskPanelEvents tEvt;

    private taskPanel() {
        initComponents();

        tEvt = taskPanelEvents.getInstance();

    }

    /*DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");
        String monthString = monthFormatter.format(Month.of(jMonthChooser1.getMonth() + 1));*/
    public static taskPanel getInstance() {
        return task;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblViewTab = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelOption = new javax.swing.JPanel();
        lblBack = new javax.swing.JLabel();
        panelTables = new javax.swing.JPanel();
        TransPanel = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMonth = new javax.swing.JTable();
        bView = new javax.swing.JButton();
        crudPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAddItem = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfAddItemName = new javax.swing.JTextField();
        tfAddItemPrice = new javax.swing.JTextField();
        tfAddItemQuan = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfAddItemCode = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        tfAddItemStock = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblAddID = new javax.swing.JLabel();
        accountPanel = new javax.swing.JPanel();
        tabPanel = new javax.swing.JPanel();
        lblCrud = new javax.swing.JLabel();
        lblTransactions = new javax.swing.JLabel();
        lblaccManager = new javax.swing.JLabel();

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

        panelTable.setBackground(new java.awt.Color(255, 255, 255));
        panelTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel15.setText("Profit:");

        jLabel16.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel16.setText("Total:");

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addGap(518, 518, 518)
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setPreferredSize(new java.awt.Dimension(720, 778));

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

        panelTables.setLayout(new java.awt.CardLayout());

        TransPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jDateChooser1.setDateFormatString("MM-dd-yyyy");
        jDateChooser1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        tableMonth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Seller", "Total", "Date"
            }
        ));
        jScrollPane3.setViewportView(tableMonth);

        bView.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        bView.setText("View");
        bView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TransPanelLayout = new javax.swing.GroupLayout(TransPanel);
        TransPanel.setLayout(TransPanelLayout);
        TransPanelLayout.setHorizontalGroup(
            TransPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bView, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
            .addGroup(TransPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TransPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        TransPanelLayout.setVerticalGroup(
            TransPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TransPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bView)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(631, Short.MAX_VALUE))
            .addGroup(TransPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TransPanelLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelTables.add(TransPanel, "card4");

        crudPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Items"));

        tableAddItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableAddItem.getTableHeader().setReorderingAllowed(false);
        tableAddItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAddItemMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableAddItem);

        jLabel17.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel17.setText("Item Name:");

        jLabel18.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel18.setText("Price:");

        jLabel19.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel19.setText("Initial Quantity:");

        tfAddItemName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        tfAddItemPrice.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        tfAddItemQuan.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel20.setText("Item Code:");

        tfAddItemCode.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

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

        tfAddItemStock.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel21.setText("Stock Quantity:");

        jLabel22.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel22.setText("ID:");

        lblAddID.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lblAddID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout crudPanelLayout = new javax.swing.GroupLayout(crudPanel);
        crudPanel.setLayout(crudPanelLayout);
        crudPanelLayout.setHorizontalGroup(
            crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(tfAddItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(tfAddItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel21)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfAddItemQuan, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(tfAddItemStock)))
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(crudPanelLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crudPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)))
                        .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfAddItemCode, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(lblAddID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                .addContainerGap())
        );
        crudPanelLayout.setVerticalGroup(
            crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22)
                    .addComponent(lblAddID, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel20))
                    .addComponent(tfAddItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addComponent(tfAddItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel18))
                    .addComponent(tfAddItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crudPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19))
                    .addComponent(tfAddItemQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tfAddItemStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelTables.add(crudPanel, "card3");

        accountPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout accountPanelLayout = new javax.swing.GroupLayout(accountPanel);
        accountPanel.setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        accountPanelLayout.setVerticalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );

        panelTables.add(accountPanel, "card5");

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

        lblaccManager.setBackground(new java.awt.Color(204, 204, 204));
        lblaccManager.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lblaccManager.setText("Account Manager");
        lblaccManager.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblaccManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblaccManagerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblaccManagerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblaccManagerMouseExited(evt);
            }
        });

        javax.swing.GroupLayout tabPanelLayout = new javax.swing.GroupLayout(tabPanel);
        tabPanel.setLayout(tabPanelLayout);
        tabPanelLayout.setHorizontalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTransactions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCrud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblaccManager, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabPanelLayout.setVerticalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCrud, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblaccManager, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelOptionLayout = new javax.swing.GroupLayout(panelOption);
        panelOption.setLayout(panelOptionLayout);
        panelOptionLayout.setHorizontalGroup(
            panelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelOptionLayout.createSequentialGroup()
                        .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelOptionLayout.setVerticalGroup(
            panelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked

        panelChanger(PanelFrame, MainPanel);
        aesthetic(lblBack, BevelBorder.RAISED, Color.black);
        clear();
        panelChanger(panelTables, TransPanel);
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseEntered
        aesthetic(lblBack, BevelBorder.LOWERED, Color.red);
    }//GEN-LAST:event_lblBackMouseEntered

    private void lblBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseExited
        aesthetic(lblBack, BevelBorder.RAISED, Color.black);
    }//GEN-LAST:event_lblBackMouseExited

    private void tableAddItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAddItemMouseClicked
        //if table got click print all rows in fields
        DefaultTableModel model = (DefaultTableModel) tableAddItem.getModel();
        int i = tableAddItem.getSelectedRow();
        //        model.getValueAt(i, 0).toString();
        lblAddID.setText(model.getValueAt(i, 0).toString());
        tfAddItemName.setText(model.getValueAt(i, 1).toString());
        tfAddItemCode.setText(model.getValueAt(i, 2).toString());
        tfAddItemQuan.setText(model.getValueAt(i, 3).toString());
        tfAddItemPrice.setText(model.getValueAt(i, 4).toString());
        tfAddItemStock.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_tableAddItemMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // ADD items in database
        if (checkFields()) {// check if fields are not null or empty
            JOptionPane.showMessageDialog(null, "Input Somethin first");
        } else {
            tEvt.setItemName(tfAddItemName.getText());
            tEvt.setItemCode(tfAddItemCode.getText());
            tEvt.setItemPrice(Float.parseFloat(tfAddItemPrice.getText()));
            tEvt.setItemQuantity(Integer.parseInt(tfAddItemQuan.getText()));
            tEvt.setItemStock(Integer.parseInt(tfAddItemStock.getText()));
            tEvt.addButton(tableAddItem);
            clear();
        }
    }//GEN-LAST:event_btnAddActionPerformed
    private boolean checkFields() { //checker if fields are not null
        return tfAddItemName.getText().equals("") || tfAddItemCode.getText().equals("") || tfAddItemPrice.getText().equals("")
                || tfAddItemQuan.getText().equals("") || tfAddItemStock.getText().equals("");
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        //UPDATE BUTTON
        if (checkFields() || lblAddID.getText().equals("")) {//check if fields are not null
            JOptionPane.showMessageDialog(null, "Please Complete", "Error", 2);
        } else {
            tEvt.setItemName(tfAddItemName.getText());
            tEvt.setItemCode(tfAddItemCode.getText());
            tEvt.setItemPrice(Float.parseFloat(tfAddItemPrice.getText()));
            tEvt.setItemQuantity(Integer.parseInt(tfAddItemQuan.getText()));
            tEvt.setItemStock(Integer.parseInt(tfAddItemStock.getText()));
            tEvt.setItemID(lblAddID.getText());
            tEvt.updateButton(tableAddItem);
            clear();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // DELETE BUTTON:
        // DELETE ITEM IN DATABASE 
        if (checkFields()) {
            JOptionPane.showMessageDialog(null, "No item Selected");
        } else {
            tEvt.setItemCode(tfAddItemCode.getText());
            tEvt.deleteButton(tableAddItem);
            clear();
        }
        //   update2();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void lblViewTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewTabMouseClicked
        // TODO add your handling code here:
        //view table
        panelChanger(panelTables, panelTable);
    }//GEN-LAST:event_lblViewTabMouseClicked

    private void lblViewTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewTabMouseEntered
        // TODO add your handling code here:

        aesthetic(lblViewTab, BevelBorder.LOWERED, Color.red);
    }//GEN-LAST:event_lblViewTabMouseEntered

    private void lblViewTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewTabMouseExited
        // TODO add your handling code here:

        aesthetic(lblViewTab, BevelBorder.RAISED, Color.black);
    }//GEN-LAST:event_lblViewTabMouseExited

    private void lblCrudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrudMouseClicked
        // TODO add your handling code here:
        //crud
        panelChanger(panelTables, crudPanel);
        tfAddItemCode.requestFocus();
        tEvt.updateItems(tableAddItem);

    }//GEN-LAST:event_lblCrudMouseClicked

    private void lblCrudMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrudMouseEntered
        // TODO add your handling code here:

        aesthetic(lblCrud, BevelBorder.LOWERED, Color.red);
    }//GEN-LAST:event_lblCrudMouseEntered

    private void lblCrudMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrudMouseExited
        // TODO add your handling code here:
        aesthetic(lblCrud, BevelBorder.RAISED, Color.black);

    }//GEN-LAST:event_lblCrudMouseExited

    private void lblTransactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransactionsMouseClicked
        // TODO add your handling code here:
        panelChanger(panelTables, TransPanel);
        clear();
    }//GEN-LAST:event_lblTransactionsMouseClicked

    private void lblTransactionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransactionsMouseEntered
        // TODO add your handling code here:
        aesthetic(lblTransactions, BevelBorder.LOWERED, Color.red);
    }//GEN-LAST:event_lblTransactionsMouseEntered

    private void lblTransactionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransactionsMouseExited
        // TODO add your handling code here:
        aesthetic(lblTransactions, BevelBorder.RAISED, Color.black);
    }//GEN-LAST:event_lblTransactionsMouseExited

    private void lblaccManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccManagerMouseClicked
        // TODO add your handling code here:
        panelChanger(panelTables, accountPanel);
        clear();

    }//GEN-LAST:event_lblaccManagerMouseClicked

    private void lblaccManagerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccManagerMouseEntered
        // TODO add your handling code here:
        aesthetic(lblaccManager, BevelBorder.LOWERED, Color.red);
    }//GEN-LAST:event_lblaccManagerMouseEntered

    private void lblaccManagerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccManagerMouseExited
        // TODO add your handling code here:
        aesthetic(lblaccManager, BevelBorder.RAISED, Color.black);
    }//GEN-LAST:event_lblaccManagerMouseExited

    private void bViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewActionPerformed
        // TODO add your handling code here:
        if (tableMonth.getModel().getRowCount() == 0) {
            tEvt.transTable(tableMonth);
        }
        tEvt.viewTable(tableMonth, jDateChooser1);

    }//GEN-LAST:event_bViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TransPanel;
    private javax.swing.JPanel accountPanel;
    private javax.swing.JButton bView;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel crudPanel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAddID;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblCrud;
    private javax.swing.JLabel lblTransactions;
    private javax.swing.JLabel lblViewTab;
    private javax.swing.JLabel lblaccManager;
    private javax.swing.JPanel panelOption;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel panelTables;
    private javax.swing.JPanel tabPanel;
    private javax.swing.JTable tableAddItem;
    private javax.swing.JTable tableMonth;
    private javax.swing.JTextField tfAddItemCode;
    private javax.swing.JTextField tfAddItemName;
    private javax.swing.JTextField tfAddItemPrice;
    private javax.swing.JTextField tfAddItemQuan;
    private javax.swing.JTextField tfAddItemStock;
    // End of variables declaration//GEN-END:variables

    public void clear() {//clear fields
        lblAddID.setText("");
        tfAddItemCode.setText("");
        tfAddItemName.setText("");
        tfAddItemPrice.setText("");
        tfAddItemStock.setText("");
        tfAddItemQuan.setText("");
    }

}
