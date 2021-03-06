/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.InventoryMgt;

import Model.User;
import View.displayChangePassword;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ASUS
 */
public class displayInventoryManagement extends javax.swing.JFrame {
    private User user;
    /**
     * Creates new form displayInventoryManagement
     */
    public displayInventoryManagement() {
        initComponents();
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblinvman = new javax.swing.JLabel();
        btnControl = new javax.swing.JButton();
        btnCheckStatus = new javax.swing.JButton();
        cbxLanguage = new javax.swing.JComboBox<>();
        btnChangePassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblinvman.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblinvman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblinvman.setText("INVENTORY MANAGEMENT");

        btnControl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnControl.setText("CONTROL ON THE STOCK IN / OUT");
        btnControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnControlMouseClicked(evt);
            }
        });

        btnCheckStatus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCheckStatus.setText("CHECK THE STATUS OF STOCK");
        btnCheckStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheckStatusMouseClicked(evt);
            }
        });

        cbxLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EN", "VN" }));
        cbxLanguage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLanguageItemStateChanged(evt);
            }
        });

        btnChangePassword.setText("Change Password");
        btnChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChangePasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCheckStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnControl, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(lblinvman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxLanguage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChangePassword, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblinvman, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnControl, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCheckStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChangePassword)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnControlMouseClicked
        displayControlStock stock = new displayControlStock();
        stock.setInfor(this.user.getUserID());
        stock.setVisible(true);
    }//GEN-LAST:event_btnControlMouseClicked

    private void btnCheckStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckStatusMouseClicked
        new displayStockStatus().setVisible(true);
    }//GEN-LAST:event_btnCheckStatusMouseClicked

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

    private void btnChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangePasswordMouseClicked
        displayChangePassword dcp = new displayChangePassword();
        dcp.setTempUser(this.user);
        dcp.changeLanguageTo(cbxLanguage.getSelectedItem().toString());
        dcp.setVisible(true);
    }//GEN-LAST:event_btnChangePasswordMouseClicked

    public void changeLanguageTo(Locale loc) {
        ResourceBundle rb = ResourceBundle.getBundle("pkgLanguage/MessageBundle", loc);
        lblinvman.setText(rb.getString("invman"));
        btnControl.setText(rb.getString("conio"));
        btnCheckStatus.setText(rb.getString("chesta"));
        btnChangePassword.setText(rb.getString("chapas"));
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
            java.util.logging.Logger.getLogger(displayInventoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(displayInventoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(displayInventoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(displayInventoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new displayInventoryManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnCheckStatus;
    private javax.swing.JButton btnControl;
    private javax.swing.JComboBox<String> cbxLanguage;
    private javax.swing.JLabel lblinvman;
    // End of variables declaration//GEN-END:variables
}
