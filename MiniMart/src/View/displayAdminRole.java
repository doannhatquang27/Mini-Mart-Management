/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.User;
import View.Report.displayReportManagement;
import View.CategoryMgt.displayCategoryManagement;
import View.ProductMgt.displayProductManagement;
import View.UserMgt.displayUserManager;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ASUS
 */
public class displayAdminRole extends javax.swing.JFrame {
    private User user;
    /**
     * Creates new form displayAdminRole
     */
    public displayAdminRole() {
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

        lbladmrol = new javax.swing.JLabel();
        cbxLanguage = new javax.swing.JComboBox<>();
        btnManageUser = new javax.swing.JButton();
        btnManageCat = new javax.swing.JButton();
        btnManagePro = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        btnChangePassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbladmrol.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbladmrol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbladmrol.setText("ADMIN ROLE");

        cbxLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EN", "VN" }));
        cbxLanguage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLanguageItemStateChanged(evt);
            }
        });

        btnManageUser.setText("Manage User");
        btnManageUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManageUserMouseClicked(evt);
            }
        });

        btnManageCat.setText("Manage Category");
        btnManageCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManageCatMouseClicked(evt);
            }
        });

        btnManagePro.setText("Manage Product");
        btnManagePro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManageProMouseClicked(evt);
            }
        });

        btnReport.setText("Reporting");
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportMouseClicked(evt);
            }
        });

        btnHelp.setText("Context Help");
        btnHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHelpMouseClicked(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbladmrol, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManageCat, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManagePro, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(btnChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbladmrol, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageUser)
                    .addComponent(btnManagePro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageCat)
                    .addComponent(btnReport))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHelp)
                    .addComponent(btnChangePassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnManageUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageUserMouseClicked
        displayUserManager dum = new displayUserManager();
        dum.setVisible(true);
    }//GEN-LAST:event_btnManageUserMouseClicked

    private void btnManageProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageProMouseClicked
        displayProductManagement drm = new displayProductManagement();
        drm.setVisible(true);
    }//GEN-LAST:event_btnManageProMouseClicked

    private void btnManageCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageCatMouseClicked
        displayCategoryManagement dcm = new displayCategoryManagement();
        dcm.setVisible(true);
    }//GEN-LAST:event_btnManageCatMouseClicked

    private void btnReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseClicked
        new displayReportManagement().setVisible(true);
    }//GEN-LAST:event_btnReportMouseClicked

    private void btnHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHelpMouseClicked
        new displayContextHelp().setVisible(true);
    }//GEN-LAST:event_btnHelpMouseClicked

    private void btnChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangePasswordMouseClicked
        displayChangePassword dcp = new displayChangePassword();
        dcp.setTempUser(this.user);
        dcp.changeLanguageTo(cbxLanguage.getSelectedItem().toString());
        dcp.setVisible(true);
    }//GEN-LAST:event_btnChangePasswordMouseClicked

    public void changeLanguageTo(Locale loc) {
        ResourceBundle rb = ResourceBundle.getBundle("pkgLanguage/MessageBundle", loc);
        lbladmrol.setText(rb.getString("admrol"));
        btnManageUser.setText(rb.getString("usermanagement"));
        btnManageCat.setText(rb.getString("catman"));
        btnManagePro.setText(rb.getString("proman"));
        btnReport.setText(rb.getString("rep"));
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
            java.util.logging.Logger.getLogger(displayAdminRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(displayAdminRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(displayAdminRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(displayAdminRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new displayAdminRole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnManageCat;
    private javax.swing.JButton btnManagePro;
    private javax.swing.JButton btnManageUser;
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox<String> cbxLanguage;
    private javax.swing.JLabel lbladmrol;
    // End of variables declaration//GEN-END:variables
}
