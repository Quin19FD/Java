
package com.cakestore.qlbanh.gui;

import java.sql.Date;

import javax.swing.*;

import com.cakestore.qlbanh.bus.KhuyenMaiBUS;
import com.cakestore.qlbanh.models.KhuyenMaiModel;
import com.toedter.calendar.JDateChooser;

public class ThemKhuyenMai extends javax.swing.JFrame {

    public ThemKhuyenMai() {
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
        jLabel5 = new JLabel();
        jLabel8 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        addButton = new JButton();
        cancelButton = new JButton();
        startDateChooser = new JDateChooser();
        endDateChooser = new JDateChooser();
        ngayBatDauLbl = new JLabel();
        ngayKetThucLbl = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE));

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Mã khuyến mãi");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 29, 116, 26));

        jLabel3.setText("Tên khuyến mãi");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 73, 116, 24));

        jLabel4.setText("Điều kiện khuyến mãi");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 115, 116, 27));

        jLabel5.setText("Giảm giá");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 160, 116, 28));

        ngayBatDauLbl.setText("Ngày bắt đầu");
        jPanel2.add(ngayBatDauLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 206, 116, 28));

        ngayKetThucLbl.setText("Ngày kết thúc");
        jPanel2.add(ngayKetThucLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 258, 116, 28));
        addButton.setText("Thêm");
        cancelButton.setText("Hủy");

        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 31, 258, 28));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 73, 258, 28));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 115, 258, 28));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 160, 258, 28));
        jPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 350, 80, 28));
        jPanel2.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 80, 28));
        jPanel2.add(startDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 206, 258, 28));
        jPanel2.add(endDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 258, 258, 28));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        addButton.addActionListener(e -> {
            String maKM = jTextField1.getText();
            String tenKM = jTextField2.getText();
            Float dieuKienKM = null;
            Float giamGia = null;

            // Add JDateChooser checking validation:
            Date ngayBatDau = null;
            Date ngayKetThuc = null;

            // Check empty or null:
            if (maKM.isEmpty() || tenKM.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                return;
            }

            // Check dieuKienKM input:
            try {
                dieuKienKM = Float.parseFloat(jTextField3.getText());
                if (dieuKienKM <= 0) {
                    JOptionPane.showMessageDialog(null, "Điều kiện khuyến mãi phải lớn hơn 0");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Điều kiện khuyến mãi không hợp lệ");
                return;
            }

            // Check giamGia input:
            try {
                giamGia = Float.parseFloat(jTextField4.getText());
                if (giamGia <= 0 || giamGia > 100) {
                    JOptionPane.showMessageDialog(null, "Giảm giá phải nằm trong khoảng từ 1 đến 100");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Giảm giá không hợp lệ");
                return;
            }

            try {
                if (startDateChooser.getDate() == null || endDateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bắt đầu và ngày kết thúc");
                    return;
                }

                ngayBatDau = new Date(startDateChooser.getDate().getTime());
                ngayKetThuc = new Date(endDateChooser.getDate().getTime());
                //Check valid date input, startDate must be before endDate and must be after current date
                if (ngayBatDau.after(ngayKetThuc)) {
                    JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải trước ngày kết thúc");
                    return;
                }

                // Get current time:
                long millis = System.currentTimeMillis();
                Date currentDate = new Date(millis);
                if (ngayBatDau.before(currentDate)) {
                    JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải lớn hơn ngày hiện tại");
                    return;
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
                return;
            }

            // Check input:
            KhuyenMaiModel khuyenmaiModel = KhuyenMaiBUS.getInstance().getModelById(maKM);
            if (khuyenmaiModel != null) {
                JOptionPane.showMessageDialog(null, "Mã khuyến mãi đã tồn tại");
                return;
            }

            // Add new khuyen mai:
            KhuyenMaiModel khuyenMaiModel = new KhuyenMaiModel();
            khuyenMaiModel.setId(maKM);
            khuyenMaiModel.setTenKhuyenMai(tenKM);
            khuyenMaiModel.setDieuKien(dieuKienKM);
            khuyenMaiModel.setPhanTramGiamGia(giamGia);
            khuyenMaiModel.setNgayBatDau(ngayBatDau);
            khuyenMaiModel.setNgayKetThuc(ngayKetThuc);

            int result = KhuyenMaiBUS.getInstance().addModel(khuyenMaiModel);
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Thêm khuyến mãi thành công");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm khuyến mãi thất bại! Vui lòng kiểm tra lại");
            }
        });

        cancelButton.addActionListener(e -> {
            this.dispose();
        });

        pack();
    }// </editor-fold>

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel8;
    private JLabel ngayBatDauLbl;
    private JLabel ngayKetThucLbl;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JButton addButton;
    private JButton cancelButton;
    private JDateChooser startDateChooser;
    private JDateChooser endDateChooser;
}
