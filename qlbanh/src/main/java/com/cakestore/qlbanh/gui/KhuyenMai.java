package com.cakestore.qlbanh.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.*;
import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import com.cakestore.qlbanh.bus.KhuyenMaiBUS;
import com.cakestore.qlbanh.models.KhuyenMaiModel;
import com.cakestore.qlbanh.utilities.excel.KhuyenMaiExcelUtil;

public class KhuyenMai extends JFrame {
    public KhuyenMai() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel5 = new JPanel();
        jLabel1 = new JLabel();
        jPanel6 = new JPanel();
        jPanel7 = new JPanel();
        JComboBox ComboxSearch = new JComboBox<>();
        JTextField txtSearch = new javax.swing.JTextField();
        jPanel8 = new JPanel();
        JButton btnAdd = new JButton();
        JButton btnEdit = new JButton();
        JButton btnDelete = new JButton();
        JButton btnTheEnd = new JButton();
        JButton btnNhapExcel = new JButton();
        JButton btnXuatExcel = new JButton();
        jPanel4 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(242, 88, 22));

        jPanel1.setBackground(new Color(255, 204, 204));
        jPanel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        jPanel1.setLayout(new BorderLayout());

        jLabel2.setIcon(new ImageIcon(getClass().getResource("../img/SALE.jpg")));
        jPanel1.add(jLabel2, BorderLayout.CENTER);

        jLabel4.setFont(new Font("Segoe UI Historic", 1, 18));
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("You are welcome store!");
        jPanel1.add(jLabel4, BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, BorderLayout.LINE_END);

        jPanel2.setLayout(new BorderLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new Color(0, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("KHUYẾN MÃI");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 0, 321, 42));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 840, -1));

        jPanel6.setBackground(new Color(255, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(BorderFactory.createTitledBorder(null, "Tìm kiếm",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComboxSearch.setModel(new DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã khuyến mãi", "Tên khuyến mãi",
                "Điều kiện khuyến mãi", "Giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái" }));
        jPanel7.add(ComboxSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 24, 114, -1));
        jPanel7.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 24, 132, -1));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 19, 280, 70));

        jPanel8.setBackground(new Color(255, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd.setBackground(new Color(204, 204, 204));
        btnAdd.setFont(new Font("Segoe UI", 1, 12));
        btnAdd.setIcon(new ImageIcon(getClass().getResource("../img/icons8_add_30px.png")));
        btnAdd.setText("Thêm");
        jPanel8.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 6, -1, 39));

        btnAdd.addActionListener(e-> {
            new ThemKhuyenMai().setVisible(true);
        });

        btnEdit.setBackground(new Color(204, 204, 204));
        btnEdit.setFont(new Font("Segoe UI", 1, 12));
        btnEdit.setIcon(new ImageIcon(getClass().getResource("../img/icons8_cancel_30px_1.png"))); // NOI18N
        btnEdit.setText("Sửa");
        jPanel8.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 6, 126, 39));

        //
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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

        btnDelete.setBackground(new Color(204, 204, 204));
        btnDelete.setFont(new Font("Segoe UI", 1, 12));
        btnDelete.setIcon(new ImageIcon(getClass().getResource("../img/icons8_delete_forever_30px_1.png"))); // NOI18N
        btnDelete.setText("Xóa");
        jPanel8.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 6, 122, 39));
        //
        btnDelete.addActionListener(e -> {
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

        btnTheEnd.setBackground(new Color(255, 153, 153));
        btnTheEnd.setFont(new Font("Segoe UI", 1, 12));
        btnTheEnd.setForeground(new Color(0, 102, 102));
        btnTheEnd.setText("Kết thúc");
        jPanel8.add(btnTheEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 51, 96, 43));

        btnNhapExcel.setBackground(new Color(204, 255, 204));
        btnNhapExcel.setFont(new Font("Segoe UI", 1, 12));
        btnNhapExcel.setIcon(new ImageIcon(getClass().getResource("../img/icons8_ms_excel_30px.png"))); // NOI18N
        btnNhapExcel.setText("Nhập Excel");
        btnNhapExcel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new KhuyenMaiExcelUtil();
                try {
                    KhuyenMaiExcelUtil.readKhuyenMaiModelsFromExcel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        jPanel8.add(btnNhapExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 51, -1, 43));

        btnXuatExcel.setBackground(new Color(204, 255, 204));
        btnXuatExcel.setFont(new Font("Segoe UI", 1, 12));
        btnXuatExcel.setIcon(new ImageIcon(getClass().getResource("../img/icons8_ms_excel_30px.png"))); // NOI18N
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    new KhuyenMaiExcelUtil();
                    KhuyenMaiExcelUtil.writeKhuyenMaiModelsToExcel(
                            KhuyenMaiBUS.getInstance().getAllModels());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        jPanel8.add(btnXuatExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 51, -1, 43));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 5, -1, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, 834, -1));

        jPanel2.add(jPanel3, BorderLayout.PAGE_START);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Mã khuyến mãi", "Tên khuyến mãi", "Điều kiện KM", "Giảm giá", "Ngày bắt đầu", "Ngày kết thúc",
                        "Trạng thái"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 836, 381));

        jPanel2.add(jPanel4, BorderLayout.CENTER);

        getContentPane().add(jPanel2, BorderLayout.CENTER);

        pack();

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    String value = txtSearch.getText().toString().toLowerCase();
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

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhuyenMai().setVisible(true);
            }
        });
    }

    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnNhapExcel;
    private JButton btnXuatExcel;
    private JButton btnTheEnd;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;
}
