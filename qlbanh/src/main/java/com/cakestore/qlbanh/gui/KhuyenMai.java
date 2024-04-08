package com.cakestore.qlbanh.gui;

import javax.swing.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.cakestore.qlbanh.bus.KhuyenMaiBUS;
import com.cakestore.qlbanh.models.KhuyenMaiModel;
import com.cakestore.qlbanh.utilities.excel.KhuyenMaiExcelUtil;

/**
 *
 * @author Admin
 */
public class KhuyenMai extends JFrame {
    public KhuyenMai() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 88, 22));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/SALE.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("You are welcome store!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel4,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        206,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                .createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        127, Short.MAX_VALUE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        366,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KHUYẾN MÃI");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jLabel1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        321,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42,
                                Short.MAX_VALUE));

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã khuyến mãi",
                "Tên khuyến mãi", "Điều kiện khuyến mãi", "Giảm giá", "Ngày bắt đầu", "Ngày kết thúc",
                "Trạng thái" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jComboBox1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        114,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        132, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE)));

        jPanel6.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/icons8_add_30px.png"))); // NOI18N
        jButton1.setText("Thêm");

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new
        javax.swing.ImageIcon(getClass().getResource("../img/icons8_cancel_30px_1.png")));
        // NOI18N
        // jButton2.setIcon(new ImageIcon("../img/icons8_cancel_30px_1.png"));
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Get selected row:
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow == -1) {
                    return;
                }
                String id = (String) jTable1.getValueAt(selectedRow, 0);
                String tenKhuyenMai = (String) jTable1.getValueAt(selectedRow, 1);
                float dieuKien = (Float) jTable1.getValueAt(selectedRow, 2);
                Object value = jTable1.getValueAt(selectedRow, 3);
                float giamGia;

                if (value instanceof String) {
                    giamGia = Float.parseFloat((String) value);
                } else if (value instanceof Integer) {
                    giamGia = ((Integer) value).floatValue();
                } else {
                    throw new RuntimeException("Unexpected value type: " + value.getClass());
                }
                Date ngayBatDau = (Date) jTable1.getValueAt(selectedRow, 4);
                Date ngayKetThuc = (Date) jTable1.getValueAt(selectedRow, 5);
                KhuyenMaiModel km = new KhuyenMaiModel(id, tenKhuyenMai, dieuKien, giamGia, ngayBatDau,
                        ngayKetThuc);
                int result = KhuyenMaiBUS.getInstance().updateModel(km);
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    KhuyenMaiBUS.getInstance().refreshData();
                    hienThiKhuyenMai();
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                    KhuyenMaiBUS.getInstance().refreshData();
                }
            }
        });
        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new
        javax.swing.ImageIcon(getClass().getResource("../img/icons8_delete_forever_30px_1.png")));
        // // NOI18N
        // jButton3.setIcon(new ImageIcon("../img/icons8_delete_forever_30px_1.png"));
        jButton3.setText("Xóa");
        jButton3.addActionListener(e -> {
            int[] selectedRows = jTable1.getSelectedRows();
            if (selectedRows.length == 0) {
                return;
            }
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String id = (String) jTable1.getValueAt(selectedRows[i], 0);
                int result = KhuyenMaiBUS.getInstance().deleteModel(id);
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                }
            }
            KhuyenMaiBUS.getInstance().refreshData();
            hienThiKhuyenMai();
        });
        jButton4.setBackground(new java.awt.Color(255, 153, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 102));
        jButton4.setText("Kết thúc");

        jButton5.setBackground(new java.awt.Color(204, 255, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setIcon(new
        javax.swing.ImageIcon(getClass().getResource("../img/icons8_ms_excel_30px.png")));
        // // NOI18N
        // jButton5.setIcon(new ImageIcon("../img/icons8_ms_excel_30px.png"));
        jButton5.setText("Nhập Excel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new KhuyenMaiExcelUtil();
                try {
                    KhuyenMaiExcelUtil.readKhuyenMaiModelsFromExcel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 255, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setIcon(new
        javax.swing.ImageIcon(getClass().getResource("../img/icons8_ms_excel_30px.png")));
        // // NOI18N
        // jButton6.setIcon(new ImageIcon("../img/icons8_ms_excel_30px.png"));
        jButton6.setText("Xuất Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    new KhuyenMaiExcelUtil();
                    KhuyenMaiExcelUtil.writeKhuyenMaiModelsToExcel(
                            KhuyenMaiBUS.getInstance().getAllModels());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout
                                .createSequentialGroup()
                                .addContainerGap(64, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                false)
                                        .addComponent(jButton4,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jButton1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                false)
                                        .addComponent(jButton2,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jButton5,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                false)
                                        .addComponent(jButton3,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jButton6,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(26, 26, 26)));
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                false)
                                        .addComponent(jButton3,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                39,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jButton2,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton4,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jButton5,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                43,
                                                Short.MAX_VALUE)
                                        .addComponent(jButton6,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addContainerGap()));

        jPanel6.add(jPanel8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 822,
                                Short.MAX_VALUE));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel5,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel6,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Mã khuyến mãi", "Tên khuyến mãi", "Điều kiện KM", "Giảm giá",
                        "Ngày bắt đầu", "Ngày kết thúc",
                        "Trạng thái"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 822,
                                Short.MAX_VALUE));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370,
                                Short.MAX_VALUE));

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    String value = jTextField1.getText().toString().toLowerCase();
                    String index = jComboBox1.getSelectedItem().toString();
                    if (index.equals("Tất cả")) {
                        List<KhuyenMaiModel> searchResult = KhuyenMaiBUS.getInstance().searchModel(value, new String[] {
                                "MaKM", "TenKM", "DieuKienKM", "PhanTramKM", "NgayBD", "NgayKT" });
                        showSearchResult(searchResult);
                    } else {
                        String[] searchFields = null;
                        if (index.equals("Tên khuyến mãi")) {
                            searchFields = new String[] { "TenKM" };
                        } else if (index.equals("Mã khuyến mãi")) {
                            searchFields = new String[] { "MaKM" };
                        } else if (index.equals("Điều kiện khuyến mãi")) {
                            searchFields = new String[] { "DieuKienKM" };
                        } else if (index.equals("Giảm giá")) {
                            searchFields = new String[] { "PhanTramKM" };
                        } else if (index.equals("Ngày bắt đầu")) {
                            searchFields = new String[] { "NgayBD" };
                        } else if (index.equals("Ngày kết thúc")) {
                            searchFields = new String[] { "NgayKT" };
                        }
                        if (searchFields != null) {
                            List<KhuyenMaiModel> searchResult = KhuyenMaiBUS.getInstance().searchModel(value,
                                    searchFields);
                            showSearchResult(searchResult);
                        }
                    }
                }
            }

            private void showSearchResult(List<KhuyenMaiModel> searchResult) {
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                tableModel.setRowCount(0);
                searchResult.forEach(khuyenMai -> {
                    tableModel.addRow(new Object[] {
                            khuyenMai.getId(),
                            khuyenMai.getTenKhuyenMai(),
                            khuyenMai.getDieuKien(),
                            khuyenMai.getPhanTramGiamGia(),
                            khuyenMai.getNgayBatDau(),
                            khuyenMai.getNgayKetThuc(),
                    });
                });

                if (searchResult.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp");
                    hienThiKhuyenMai();
                }
            }
        });
        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        hienThiKhuyenMai();
        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void hienThiKhuyenMai() {
        KhuyenMaiBUS.getInstance().refreshData();
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);

        KhuyenMaiBUS.getInstance().getAllModels().forEach(khuyenMai -> {
            tableModel.addRow(new Object[] {
                    khuyenMai.getId(),
                    khuyenMai.getTenKhuyenMai(),
                    khuyenMai.getDieuKien(),
                    khuyenMai.getPhanTramGiamGia(),
                    khuyenMai.getNgayBatDau(),
                    khuyenMai.getNgayKetThuc(),
            });
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhuyenMai.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhuyenMai.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhuyenMai.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhuyenMai.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
