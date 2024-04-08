package com.cakestore.qlbanh.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cakestore.qlbanh.interfaces.DAOInterface;
import com.cakestore.qlbanh.models.KhuyenMaiModel;

public class KhuyenMaiDAO implements DAOInterface<KhuyenMaiModel> {

    private static KhuyenMaiDAO instance;

    public static KhuyenMaiDAO getInstance() {
        if (instance == null) {
            instance = new KhuyenMaiDAO();
        }
        return instance;
    }

    private static KhuyenMaiModel createKhuyenMaiModelFromResultSet(ResultSet rs) throws SQLException {
        String id = rs.getString("MaKM");
        String tenKhuyenMai = rs.getString("TenKM");
        float dieuKien = rs.getFloat("DieuKienKM");
        float phanTramGiamGia = rs.getFloat("PhanTramKM");
        Date ngayBatDau = rs.getDate("NgayBD");
        Date ngayKetThuc = rs.getDate("NgayKT");
        return new KhuyenMaiModel(id, tenKhuyenMai, dieuKien, phanTramGiamGia, ngayBatDau, ngayKetThuc);
    }

    @Override
    public ArrayList<KhuyenMaiModel> readDatabase() {
        ArrayList<KhuyenMaiModel> khuyenMaiList = new ArrayList<>();
        try (
                ResultSet rs = DatabaseConnection.executeQuery("SELECT * FROM khuyenmai")) {
            while (rs.next()) {
                KhuyenMaiModel khuyenMaiModel = createKhuyenMaiModelFromResultSet(rs);
                khuyenMaiList.add(khuyenMaiModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khuyenMaiList;
    }

    @Override
    public int insert(KhuyenMaiModel khuyenMaiModel) {
        String insertSql = "INSERT INTO khuyenmai (MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT) VALUES (?, ?, ?, ?, ?)";
        Object[] args = {
                khuyenMaiModel.getId(),
                khuyenMaiModel.getTenKhuyenMai(),
                khuyenMaiModel.getDieuKien(),
                khuyenMaiModel.getPhanTramGiamGia(),
                khuyenMaiModel.getNgayBatDau(),
                khuyenMaiModel.getNgayKetThuc()
        };
        try {
            return DatabaseConnection.executeUpdate(insertSql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(KhuyenMaiModel khuyenMaiModel) {
        String updateSql = "UPDATE khuyenmai SET TenKM = ?, DieuKienKM = ?, PhanTramKM = ?, NgayBD = ?, NgayKT = ? WHERE MaKM = ?";
        Object[] args = {
                khuyenMaiModel.getTenKhuyenMai(),
                khuyenMaiModel.getDieuKien(),
                khuyenMaiModel.getPhanTramGiamGia(),
                khuyenMaiModel.getNgayBatDau(),
                khuyenMaiModel.getNgayKetThuc(),
                khuyenMaiModel.getId()
        };
        try {
            return DatabaseConnection.executeUpdate(updateSql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(String id) {
        String deleteSql = "DELETE FROM khuyenmai WHERE MaKM = ?";
        Object[] args = { id };
        try {
            return DatabaseConnection.executeUpdate(deleteSql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<KhuyenMaiModel> search(String condition, String[] columnNames) {
        try {
            if (condition == null || condition.trim().isEmpty()) {
                throw new IllegalArgumentException("Search condition cannot be empty or null");
            }

            String query;
            if (columnNames == null || columnNames.length == 0) {
                query = "SELECT * FROM khuyenmai WHERE CONCAT(MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT) LIKE ?";
            } else if (columnNames.length == 1) {
                String column = columnNames[0];
                query = "SELECT * FROM khuyenmai WHERE " + column + " LIKE ?";
            } else {
                query = "SELECT (MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT FROM khuyenmai WHERE CONCAT("
                        +
                        String.join(", ", columnNames) +
                        ") LIKE ?";
            }

            try (PreparedStatement pst = DatabaseConnection.getPreparedStatement(query, "%" + condition + "%")) {
                try (ResultSet rs = pst.executeQuery()) {
                    List<KhuyenMaiModel> khuyenMaiList = new ArrayList<>();
                    while (rs.next()) {
                        KhuyenMaiModel khuyenMaiModel = createKhuyenMaiModelFromResultSet(rs);
                        khuyenMaiList.add(khuyenMaiModel);
                    }

                    if (khuyenMaiList.isEmpty()) {
                        throw new SQLException("No records found for the given condition: " + condition);
                    }

                    return khuyenMaiList;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<KhuyenMaiModel> searchDatetoDate(String fromDate, String toDate) {
        try {
            String query;
            if (fromDate == null && toDate == null) {
                query = "SELECT * FROM khuyenmai";
            } else if (fromDate == null || toDate == null) {
                throw new IllegalArgumentException("Both fromDate and toDate must be specified.");
            } else {
                query = "SELECT * FROM KhuyenMai WHERE NgayBD BETWEEN ? AND ?";
            }
            try (PreparedStatement pst = (fromDate != null && toDate != null)
                    ? DatabaseConnection.getPreparedStatement(query, fromDate, toDate)
                    : DatabaseConnection.getPreparedStatement(query);
                    ResultSet rs = pst.executeQuery()) {
                List<KhuyenMaiModel> orderList = new ArrayList<>();
                while (rs.next()) {
                    KhuyenMaiModel KhuyenMaiModel = createKhuyenMaiModelFromResultSet(rs);
                    orderList.add(KhuyenMaiModel);
                }

                if (orderList.isEmpty()) {
                    throw new SQLException("No records found for the given date range.");
                }

                return orderList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<KhuyenMaiModel> searchDatetoDate_EndDate(String fromDate, String toDate) {
        try {
            String query;
            if (fromDate == null && toDate == null) {
                query = "SELECT * FROM KhuyenMai";
            } else if (fromDate == null || toDate == null) {
                throw new IllegalArgumentException("Both fromDate and toDate must be specified.");
            } else {
                query = "SELECT * FROM khuyenmai WHERE NgayKT BETWEEN ? AND ?";
            }
            try (PreparedStatement pst = (fromDate != null && toDate != null)
                    ? DatabaseConnection.getPreparedStatement(query, fromDate, toDate)
                    : DatabaseConnection.getPreparedStatement(query);
                    ResultSet rs = pst.executeQuery()) {
                List<KhuyenMaiModel> orderList = new ArrayList<>();
                while (rs.next()) {
                    KhuyenMaiModel KhuyenMaiModel = createKhuyenMaiModelFromResultSet(rs);
                    orderList.add(KhuyenMaiModel);
                }

                if (orderList.isEmpty()) {
                    throw new SQLException("No records found for the given date range.");
                }

                return orderList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
