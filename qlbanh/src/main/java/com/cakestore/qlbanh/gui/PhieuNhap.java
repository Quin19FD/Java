
package com.cakestore.qlbanh.gui;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class PhieuNhap extends javax.swing.JFrame {
    public PhieuNhap() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
                           
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel6 = new JPanel();
        jPanel9 = new JPanel();
        txtMaPN = new JTextField();
        jLabel4 = new JLabel();
        txtMaNCC = new JTextField();
        txtMaNV = new JTextField();
        txtNgay = new JTextField();
        txtGio = new JTextField();
        txtTongTien = new JTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        btnAdd = new JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnNhapExcel = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        ComboBoxSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        txtFrom = new javax.swing.JTextField();
        btnChonNgay = new javax.swing.JButton();
        txtTo = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        txtFrom1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        txtTo1 = new javax.swing.JTextField();
        LabelTitle = new javax.swing.JLabel();
        btnPDF = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPNActionPerformed(evt);
            }
        });
        jPanel9.add(txtMaPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 6, 127, -1));

        jLabel4.setText("Mã PN");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 152, 22));
        jPanel9.add(txtMaNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 127, -1));
        jPanel9.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 74, 127, -1));

        txtNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayActionPerformed(evt);
            }
        });
        jPanel9.add(txtNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 108, 127, -1));
        jPanel9.add(txtGio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 142, 127, -1));
        jPanel9.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 176, 127, -1));

        jLabel5.setText("Mã NCC");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, 152, 22));

        jLabel6.setText("Mã NV");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 74, 152, 22));

        jLabel7.setText("Ngày lập");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 108, 152, 22));

        jLabel8.setText("Giờ lập");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 142, 152, 22));

        jLabel9.setText("Tổng tiền");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 176, 152, 22));

        btnAdd.setBackground(new java.awt.Color(255, 153, 153));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 102, 102));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/img/icons8_add_30px.png"))); // NOI18N
        btnAdd.setText("Thêm");
        jPanel9.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 210, -1, -1));

        btnDelete.setBackground(new Color(255, 204, 204));
        btnDelete.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setIcon(new ImageIcon(getClass().getResource("/project/img/icons8_delete_forever_30px_1.png"))); // NOI18N
        btnDelete.setText("Xóa");
        jPanel9.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 210, -1, -1));

        btnEdit.setBackground(new java.awt.Color(255, 204, 153));
        btnEdit.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setIcon(new ImageIcon(getClass().getResource("/project/img/icons8_support_30px.png"))); // NOI18N
        btnEdit.setText("Sửa");
        jPanel9.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 265, -1, -1));

        btnReset.setBackground(new java.awt.Color(255, 255, 204));
        btnReset.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setForeground(new Color(0, 102, 102));
        btnReset.setIcon(new ImageIcon(getClass().getResource("/project/img/icons8_data_backup_30px.png"))); // NOI18N
        btnReset.setText("Làm mới");
        jPanel9.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 265, -1, -1));

        btnNhapExcel.setBackground(new java.awt.Color(204, 204, 204));
        btnNhapExcel.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        btnNhapExcel.setForeground(new Color(0, 153, 153));
        btnNhapExcel.setIcon(new ImageIcon(getClass().getResource("/project/img/icons8_ms_excel_30px.png"))); // NOI18N
        btnNhapExcel.setText("Nhập Excel");
        jPanel9.add(btnNhapExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 320, -1, -1));

        btnXuatExcel.setBackground(new java.awt.Color(204, 204, 204));
        btnXuatExcel.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatExcel.setForeground(new Color(0, 153, 153));
        btnXuatExcel.setIcon(new ImageIcon(getClass().getResource("/project/img/icons8_ms_excel_30px.png"))); // NOI18N
        btnXuatExcel.setText("Xuất Excel");
        jPanel9.add(btnXuatExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 320, -1, -1));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        ComboBoxSearch.setEditable(true);
        ComboBoxSearch.setModel(new DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã phiếu nhập", "Mã nhà cung cấp", "Mã Nhân viên", "Ngày nhập", "Giờ nhập", "Tổng tiền" }));
        ComboBoxSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ComboBoxSearchActionPerformed(evt);
            }
        });
        jPanel10.add(ComboBoxSearch);
        jPanel10.add(txtSearch);

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 375, 260, -1));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngày lập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        txtFrom.setBorder(javax.swing.BorderFactory.createTitledBorder("Từ"));
        jPanel11.add(txtFrom);

        btnChonNgay.setIcon(new ImageIcon(getClass().getResource("/project/img/icons8_calendar_31_30px.png"))); // NOI18N
        jPanel11.add(btnChonNgay);

        txtTo.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        jPanel11.add(txtTo);

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 260, -1));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng tiền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        txtFrom1.setBorder(javax.swing.BorderFactory.createTitledBorder("Từ"));
        jPanel12.add(txtFrom1);

        jButton8.setIcon(new ImageIcon(getClass().getResource("/project/img/icons8_database_restore_30px.png"))); // NOI18N
        jPanel12.add(jButton8);

        txtTo1.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        jPanel12.add(txtTo1);

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 260, -1));

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 300, -1));

        LabelTitle.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        LabelTitle.setForeground(new Color(255, 204, 255));
        LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitle.setText("Thông tin phiếu nhập");
        jPanel6.add(LabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 297, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        btnPDF.setBackground(new Color(255, 102, 102));
        btnPDF.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        btnPDF.setForeground(new Color(0, 102, 102));
        btnPDF.setText("In PDF");
        jPanel1.add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 640, 92, -1));

        getContentPane().add(jPanel1, BorderLayout.LINE_END);

        jPanel5.setLayout(new CardLayout());

        jScrollPane1.setBackground(new Color(255, 255, 255));
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setRequestFocusEnabled(false);
        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày lập", "Giờ lập", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.setUpdateSelectionOnSort(false);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1396, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 2154, -1));

        jPanel16.setBackground(new Color(255, 255, 255));

        jLabel3.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new Color(255, 102, 102));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("CHI TIẾT PHIẾU NHẬP");

        jTable2.setBackground(new Color(204, 204, 204));
        jTable2.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã PN", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jTable2.setShowHorizontalLines(true);
        jTable2.setShowVerticalLines(true);
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 477, 750, -1));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(0, 51, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PHIẾU NHẬP HÀNG");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 6, 380, -1));

        jPanel13.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 50));

        jScrollPane1.setViewportView(jPanel13);

        jPanel5.add(jScrollPane1, "card2");

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void txtMaPNActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void txtNgayActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void ComboBoxSearchActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(PhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JComboBox<String> ComboBoxSearch;
    private JLabel LabelTitle;
    private JButton btnAdd;
    private JButton btnChonNgay;
    private JButton btnDelete;
    private JButton btnEdit;
    private JButton btnNhapExcel;
    private JButton btnPDF;
    private JButton btnReset;
    private JButton btnXuatExcel;
    private JButton jButton8;
    private JLabel jLabel10;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTable jTable1;
    private JTable jTable2;
    private JTextField txtFrom;
    private JTextField txtFrom1;
    private JTextField txtGio;
    private JTextField txtMaNCC;
    private JTextField txtMaNV;
    private JTextField txtMaPN;
    private JTextField txtNgay;
    private JTextField txtSearch;
    private JTextField txtTo;
    private JTextField txtTo1;
    private JTextField txtTongTien;
                
}
