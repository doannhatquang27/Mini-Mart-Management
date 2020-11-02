/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.InventoryMgt;

import Model.Product;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import DBUtils.TblProduct;
import DBUtils.TblStockInOut;
import DBUtils.TblStockInOutDetails;

/**
 *
 * @author ASUS
 */
public class displayControlStock extends javax.swing.JFrame {
    private boolean isNew = true;
    private int stockId = 0, userId = 0;
    private int amountInStore = 0;
    /**
     * Creates new form displayControlStock
     */
    public displayControlStock() {
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

        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        lblconsto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblproid = new javax.swing.JLabel();
        txtProduceID = new javax.swing.JTextField();
        lblamo = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        lblsta = new javax.swing.JLabel();
        rbtAdd = new javax.swing.JRadioButton();
        rbtRemove = new javax.swing.JRadioButton();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cbxLanguage = new javax.swing.JComboBox<>();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblconsto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblconsto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblconsto.setText("CONTROL STOCK");

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblproid.setText("Product ID");

        txtProduceID.setEditable(false);

        lblamo.setText("Amount");

        lblsta.setText("Status");

        buttonGroup1.add(rbtAdd);
        rbtAdd.setText("Add");

        buttonGroup1.add(rbtRemove);
        rbtRemove.setText("Remove");

        btnOK.setText("OK");
        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKMouseClicked(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblproid)
                            .addComponent(lblamo)
                            .addComponent(lblsta))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbtAdd)
                                .addGap(27, 27, 27)
                                .addComponent(rbtRemove)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtAmount)
                            .addComponent(txtProduceID)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(79, 79, 79)
                        .addComponent(btnCancel)
                        .addGap(36, 36, 36)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblproid)
                    .addComponent(txtProduceID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblamo)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtAdd)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblsta)
                        .addComponent(rbtRemove)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOK)
                    .addComponent(btnCancel))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        cbxLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EN", "VN" }));
        cbxLanguage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLanguageItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblconsto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblconsto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setInfor(int userId) {
        this.userId = userId;
    }
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        loadProductTable();
    }//GEN-LAST:event_formWindowActivated

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        displayProductInformation();
    }//GEN-LAST:event_tblProductMouseClicked

    private void btnOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseClicked
        TblStockInOut excSIO = new TblStockInOut();
        TblStockInOutDetails excSIOD = new TblStockInOutDetails();
        
        boolean flat = true;
        
        if (isNew) {
            int newId = excSIO.loadStockList() + 1;
            this.stockId = newId;
            try {
                excSIO.insertStockModify(newId, this.userId);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            isNew = false;
        }
        
        int productId = Integer.parseInt(txtProduceID.getText());
        int amount = Integer.parseInt(txtAmount.getText());
        
        if (rbtRemove.isSelected()) amount *= -1;
        
        if (this.amountInStore + amount < 0) {
            JOptionPane.showMessageDialog(this, "Do not have enough product in store");
            flat = false;
        }
        
        if (flat) {
            try {
                boolean isExecutetd = excSIOD.insertStock(this.stockId, productId, amount);
                
                if (isExecutetd) {
                    JOptionPane.showMessageDialog(this, "Modify successfully");
                    txtProduceID.setText(""); txtAmount.setText(""); buttonGroup1.clearSelection();
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }                
    }//GEN-LAST:event_btnOKMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void cbxLanguageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLanguageItemStateChanged
        Locale loc;

        if (cbxLanguage.getSelectedItem().equals("VN")) {
            loc = new Locale("vi", "VN");
            changeLanguageTo(loc);
        } else {
            loc = new Locale("en", "US");
            changeLanguageTo(loc);
        }
    }//GEN-LAST:event_cbxLanguageItemStateChanged

    public void changeLanguageTo(Locale loc) {
        ResourceBundle rb = ResourceBundle.getBundle("pkgLanguage/MessageBundle", loc);
        lblconsto.setText(rb.getString("consto"));
        lblproid.setText(rb.getString("proid"));
        lblamo.setText(rb.getString("amo"));
        lblsta.setText(rb.getString("sta"));
        rbtAdd.setText(rb.getString("add"));
        rbtRemove.setText(rb.getString("rem"));
        btnCancel.setText(rb.getString("can"));  
    }
    
    public void loadProductTable() {
        TblProduct exc = new TblProduct();
        tblProduct.setModel(exc.loadProductTable());
    }
    
    public ArrayList<Product> loadProductList() {
        TblProduct exc = new TblProduct();
        return exc.loadProduct();
    }
    
    public void displayProductInformation() {
        TblProduct exc = new TblProduct();
        ArrayList<Product> productList = exc.loadProduct();
        int rowSelected = tblProduct.getSelectedRow();
        
        if (rowSelected != -1) {
            txtProduceID.setText(Integer.toString(productList.get(rowSelected).getProductId()));
            this.amountInStore = productList.get(rowSelected).getAmount();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(displayControlStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(displayControlStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(displayControlStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(displayControlStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new displayControlStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxLanguage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblamo;
    private javax.swing.JLabel lblconsto;
    private javax.swing.JLabel lblproid;
    private javax.swing.JLabel lblsta;
    private javax.swing.JRadioButton rbtAdd;
    private javax.swing.JRadioButton rbtRemove;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtProduceID;
    // End of variables declaration//GEN-END:variables
}