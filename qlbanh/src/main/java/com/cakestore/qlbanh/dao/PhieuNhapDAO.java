package com.cakestore.qlbanh.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cakestore.qlbanh.interfaces.DAOInterface;
import com.cakestore.qlbanh.models.PhieuNhapModel;

public class PhieuNhapDAO implements DAOInterface<PhieuNhapModel> {

    private static PhieuNhapDAO instance;

    public static PhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new PhieuNhapDAO();
        }
        return instance;
    }

    private static PhieuNhapModel createPhieuNhapModelFromResultSet(ResultSet rs) throws SQLException {
        int maPhieuNhap = rs.getInt("maPhieuNhap");
        int maNhanVien = rs.getInt("maNhanVien");
        int maNhaCungCap = rs.getInt("maNhaCungCap");
        Timestamp ngayNhap = rs.getTimestamp("ngayNhap");
        double tongTien = rs.getDouble("tongTien");
        return new PhieuNhapModel(maPhieuNhap, maNhanVien, maNhaCungCap, ngayNhap, tongTien);
    }

    @Override
    public ArrayList<PhieuNhapModel> readDatabase() {
        ArrayList<PhieuNhapModel> phieuNhapList = new ArrayList<>();
        try (
                ResultSet rs = DatabaseConnection.executeQuery("SELECT * FROM phieunhap")) {
            while (rs.next()) {
                PhieuNhapModel phieuNhapModel = createPhieuNhapModelFromResultSet(rs);
                phieuNhapList.add(phieuNhapModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuNhapList;
    }

    @Override
    public int insert(PhieuNhapModel phieuNhapModel) {
        String insertSql = "INSERT INTO phieunhap (maPhieuNhap, maNhanVien, maNhaCungCap, ngayNhap, tongTien) VALUES (?, ?, ?, ?, ?)";
        Object[] args = {
                phieuNhapModel.getMaPhieuNhap(),
                phieuNhapModel.getMaNhanVien(),
                phieuNhapModel.getMaNhaCungCap(),
                phieuNhapModel.getNgayNhap(),
                phieuNhapModel.getTongTien()
        };
        try {
            return DatabaseConnection.executeUpdate(insertSql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(PhieuNhapModel phieuNhapModel) {
        String updateSql = "UPDATE phieunhap SET maPhieuNhap = ?, maNhanVien = ?, maNhaCungCap = ?, ngayNhap = ?, tongTien = ? WHERE maPhieuNhap = ?";
        Object[] args = {
                phieuNhapModel.getMaPhieuNhap(),
                phieuNhapModel.getMaNhanVien(),
                phieuNhapModel.getMaNhaCungCap(),
                phieuNhapModel.getNgayNhap(),
                phieuNhapModel.getTongTien(),
                phieuNhapModel.getMaPhieuNhap()
        };
        try {
            return DatabaseConnection.executeUpdate(updateSql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(String maPhieuNhap) {
        String deleteSql = "DELETE FROM phieunhap WHERE maPhieuNhap = ?";
        Object[] args = { maPhieuNhap };
        try {
            return DatabaseConnection.executeUpdate(deleteSql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<PhieuNhapModel> search(String condition, String[] columnNames) {
        try {
            if (condition == null || condition.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Search condition cannot be empty or null");
            }

            String query;
            if (columnNames == null || columnNames.length == 0) {
                query = "SELECT * FROM phieunhap WHERE CONCAT(maPhieuNhap, maNhanVien, maNhaCungCap, ngayNhap, tongTien) LIKE ?";
            } else if (columnNames.length == 1) {
                String column = columnNames[0];
                query = "SELECT * FROM phieunhap WHERE " + column + " LIKE ?";
            } else {
                query = "SELECT maPhieuNhap, maNhanVien, maNhaCungCap, ngayNhap, tongTien FROM phieunhap WHERE CONCAT("
                        +
                        String.join(", ", columnNames) +
                        ") LIKE ?";
            }

            try (
                    PreparedStatement pst = DatabaseConnection.getPreparedStatement(
                            query,
                            "%" + condition + "%")) {
                try (ResultSet rs = pst.executeQuery()) {
                    List<PhieuNhapModel> phieuNhapList = new ArrayList<>();
                    while (rs.next()) {
                        PhieuNhapModel phieuNhapModel = createPhieuNhapModelFromResultSet(rs);
                        phieuNhapList.add(phieuNhapModel);
                    }

                    if (phieuNhapList.isEmpty()) {
                        throw new SQLException(
                                "No records found for the given condition: " + condition);
                    }

                    return phieuNhapList;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}