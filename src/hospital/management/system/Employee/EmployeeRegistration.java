/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.Employee;

import hospital.management.system.Database;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Sumanta
 */
public class EmployeeRegistration extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form EmployeeRegistration
     */
    public EmployeeRegistration() {
        initComponents();
        conn = Database.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_name = new javax.swing.JTextField();
        txt_loginId = new javax.swing.JTextField();
        txt_contactNo = new javax.swing.JTextField();
        label_name = new javax.swing.JLabel();
        label_contactNo = new javax.swing.JLabel();
        label_loginId = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        label_confirmPassword = new javax.swing.JLabel();
        label_department = new javax.swing.JLabel();
        txt_department = new javax.swing.JTextField();
        txt_confirmPassword = new javax.swing.JPasswordField();
        txt_password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setLayout(null);
        jPanel1.add(txt_name);
        txt_name.setBounds(390, 120, 203, 33);
        jPanel1.add(txt_loginId);
        txt_loginId.setBounds(390, 170, 203, 33);

        txt_contactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactNoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_contactNo);
        txt_contactNo.setBounds(390, 370, 203, 33);

        label_name.setText("Name");
        jPanel1.add(label_name);
        label_name.setBounds(200, 120, 135, 33);

        label_contactNo.setText("Contact No");
        jPanel1.add(label_contactNo);
        label_contactNo.setBounds(200, 370, 135, 33);

        label_loginId.setText("Login Id");
        jPanel1.add(label_loginId);
        label_loginId.setBounds(200, 170, 135, 33);

        label_password.setText("Password");
        jPanel1.add(label_password);
        label_password.setBounds(200, 220, 135, 33);

        label_confirmPassword.setText("Confirm Password");
        jPanel1.add(label_confirmPassword);
        label_confirmPassword.setBounds(200, 270, 135, 33);

        label_department.setText("Department");
        jPanel1.add(label_department);
        label_department.setBounds(200, 320, 135, 33);
        jPanel1.add(txt_department);
        txt_department.setBounds(390, 320, 203, 33);
        jPanel1.add(txt_confirmPassword);
        txt_confirmPassword.setBounds(390, 270, 203, 33);
        jPanel1.add(txt_password);
        txt_password.setBounds(390, 220, 203, 33);

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(390, 440, 130, 60);

        jButton2.setText("Clear Form");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(230, 440, 130, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_contactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactNoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        txt_name.setText("");
        txt_confirmPassword.setText("");
        txt_contactNo.setText("");
        txt_department.setText("");
        txt_loginId.setText("");
        txt_password.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Confirm registration task ?", "Register Record", JOptionPane.YES_NO_OPTION);
        if (txt_password.getText().equals(txt_confirmPassword.getText()) && x == 0) {
            try {
                Calendar cal = new GregorianCalendar();
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                String sql = "insert into Employee "
                        + "(name, loginId, password, department, contactNo) "
                        + "values (?, ?, ?, ?, ?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, txt_name.getText());
                pst.setString(2, txt_loginId.getText());
                pst.setString(3, txt_password.getText());
                pst.setString(4, txt_department.getText());
                pst.setString(5, txt_contactNo.getText());

                pst.execute();
                JOptionPane.showMessageDialog(null, "Data is saved successfully");
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            finally {
                try {
//                   rs.close();
                    pst.close();
                }
                catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
                }
            }
        }
        else {
                JOptionPane.showMessageDialog(null, "Passwords Don't match");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_confirmPassword;
    private javax.swing.JLabel label_contactNo;
    private javax.swing.JLabel label_department;
    private javax.swing.JLabel label_loginId;
    private javax.swing.JLabel label_name;
    private javax.swing.JLabel label_password;
    private javax.swing.JPasswordField txt_confirmPassword;
    private javax.swing.JTextField txt_contactNo;
    private javax.swing.JTextField txt_department;
    private javax.swing.JTextField txt_loginId;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
