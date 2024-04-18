package com.cakestore.qlbanh.gui;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import com.cakestore.qlbanh.bus.LoaiSanPhamBUS;
import com.cakestore.qlbanh.models.LoaiSanPhamModel;
import com.cakestore.qlbanh.utilities.excel.LoaiSanPhamExcelUtil;

public class LoaiSanPham extends javax.swing.JFrame {
    public LoaiSanPham() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new JPanel();
        jPanel5 = new JPanel();
        LabelTitle = new JLabel();
        jPanel4 = new JPanel();
        ComboxSearch = new JComboBox<>();
        txtSearch = new JTextField();
        btnReset = new JButton();
        jPanel3 = new JPanel();
        btnAdd = new JButton();
        btnDelete = new JButton();
        btnEdit = new JButton();
        btnNhapExcel = new JButton();
        btnXuatExcel = new JButton();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102)));

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));

        LabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        LabelTitle.setForeground(new java.awt.Color(0, 204, 204));
        LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitle.setText("LOẠI SẢN PHẨM");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(LabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); 

        ComboxSearch.setEditable(true);
        ComboxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã loại", "Tên loại", "Mô tả" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnReset.setBackground(new java.awt.Color(255, 255, 204));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/icons8_data_backup_30px.png"))); 
        btnReset.setText("Làm mới");
        //Làm mới
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        btnAdd.setBackground(new java.awt.Color(204, 204, 204));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/icons8_add_30px.png")));
        btnAdd.setText("Thêm");
        jPanel3.add(btnAdd);
        //Thêm
        btnAdd.addActionListener(e-> {
                new ThemLoaiSP().setVisible(true);
            });

        btnDelete.setBackground(new java.awt.Color(255, 204, 204));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/icons8_delete_forever_30px_1.png")));
        btnDelete.setText("Xóa");
        jPanel3.add(btnDelete);
        // Hành động xóa
        btnDelete.addActionListener(e -> {
            int[] selectedRows = jTable1.getSelectedRows();
            if (selectedRows.length == 0) {
                return;
            }
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String id = (String) jTable1.getValueAt(selectedRows[i], 0);
                int result = LoaiSanPhamBUS.getInstance().deleteModel(id);
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                }
            }
            LoaiSanPhamBUS.getInstance().refreshData();
        });

        btnEdit.setBackground(new java.awt.Color(153, 255, 153));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/icons8_support_30px.png")));
        btnEdit.setText("Sửa");
        jPanel3.add(btnEdit);
       // hành động sửa
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Lấy hàng được chọn:
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow == -1) {
                    return;
                }
                String maLoaiSP = (String) jTable1.getValueAt(selectedRow, 0);
                String tenLoaiSP = (String) jTable1.getValueAt(selectedRow, 1);
                String Mota = (String ) jTable1.getValueAt(selectedRow, 2);

                // Tạo đối tượng LoaiSanPhamModel
                LoaiSanPhamModel loaiSP = new LoaiSanPhamModel(maLoaiSP, tenLoaiSP, Mota);
                // Cập nhật dữ liệu
                int result = LoaiSanPhamBUS.getInstance().updateModel(loaiSP);
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    LoaiSanPhamBUS.getInstance().refreshData();
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                    LoaiSanPhamBUS.getInstance().refreshData();
                }
            }
        });
        
        btnNhapExcel.setBackground(new java.awt.Color(0, 204, 153));
        btnNhapExcel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnNhapExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/icons8_ms_excel_30px.png")));
        btnNhapExcel.setText("Nhập Excel");
        jPanel3.add(btnNhapExcel);
        // Nhập Excel 
        btnNhapExcel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    new LoaiSanPhamExcelUtil();
                    LoaiSanPhamExcelUtil.writeLoaiSanPhamModelsToExcel(
                            LoaiSanPhamBUS.getInstance().getAllModels());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    });

        btnXuatExcel.setBackground(new java.awt.Color(0, 204, 153));
        btnXuatExcel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/icons8_ms_excel_30px.png")));
        btnXuatExcel.setText("Xuất Excel");
        jPanel3.add(btnXuatExcel);
     // Xuất Excel
        btnXuatExcel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    new LoaiSanPhamExcelUtil();
                   LoaiSanPhamExcelUtil.writeLoaiSanPhamModelsToExcel(
                            LoaiSanPhamBUS.getInstance().getAllModels());
               } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(306, 306, 306)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGap(306, 306, 306)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addGap(30, 30, 30))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(103, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "Mã loại", "Tên loại", "Mô tả" }
        ) {
            Class[] types = new Class [] { java.lang.String.class, java.lang.String.class, java.lang.String.class };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                        String value = txtSearch.getText().toString().toLowerCase();
                        String index = txtSearch.getSelectedText().toString();
                        if (index.equals("Tất cả")) {
                            List<LoaiSanPhamModel> searchResult = LoaiSanPhamBUS.getInstance().searchModel(value, new String[] {
                                    "MaLSP", "TenLSP", "Mota" });
                            showSearchResult(searchResult);
                        } else {
                            String[] searchFields = null;
                            if (index.equals("Tên loại")) {
                                searchFields = new String[] { "TenLSP" };
                            } else if (index.equals("Mã loại")) {
                                searchFields = new String[] { "MaLSP" };
                            } else if (index.equals("Mô tả")) {
                                searchFields = new String[] { "Mota" };
                            } 
                            if (searchFields != null) {
                                List<LoaiSanPhamModel> searchResult = LoaiSanPhamBUS.getInstance().searchModel(value,
                                        searchFields);
                                showSearchResult(searchResult);
                            }
                        }
                    }
                }

                private void showSearchResult(List<LoaiSanPhamModel> searchResult) {
                        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                        tableModel.setRowCount(0);
                        searchResult.forEach(loaiSanPham -> {
                            tableModel.addRow(new Object[] {
                                    loaiSanPham.getMaLoaiSP(),
                                    loaiSanPham.getTenLoaiSP(),
                                    loaiSanPham.getMota()
                            });
                        });
        
                        if (searchResult.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp");
                            hienThiLoaiSP();
                        }
                    }
                });
                getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
                hienThiLoaiSP();
                pack();
    }
    public void hienThiLoaiSP() {
        LoaiSanPhamBUS.getInstance().refreshData();
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);

        LoaiSanPhamBUS.getInstance().getAllModels().forEach(loaiSP-> {
            tableModel.addRow(new Object[] {
                    loaiSP.getMaLoaiSP(),
                    loaiSP.getTenLoaiSP(),
                    loaiSP.getMota()
            });
        });
    }                                      

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoaiSanPham().setVisible(true);
            }
        });
    }

    private JComboBox<String> ComboxSearch;
    private JLabel LabelTitle;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnEdit;
    private JButton btnNhapExcel;
    private JButton btnReset;
    private JButton btnXuatExcel;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField txtSearch;
}
