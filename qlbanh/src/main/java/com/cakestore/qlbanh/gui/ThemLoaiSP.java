
package com.cakestore.qlbanh.gui;

import javax.swing.*;
public class ThemLoaiSP extends javax.swing.JFrame {

   
    public ThemLoaiSP() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
     
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
    

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Mã loại");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 29, 116, 26));

        jLabel3.setText("Tên loại");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 73, 116, 24));

        jLabel4.setText("Mô tả");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 115, 116, 27));

        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 31, 258, 28));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 73, 258, 28));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 115, 258, 28));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }

       public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemLoaiSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
  
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
  
   }   
