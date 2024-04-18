package com.cakestore.qlbanh.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cakestore.qlbanh.interfaces.DAOInterface;
import com.cakestore.qlbanh.models.LoaiSanPhamModel;

public class LoaiSanPhamDAO implements DAOInterface<LoaiSanPhamModel> {

    private static LoaiSanPhamDAO instance;

    public static LoaiSanPhamDAO getInstance() {
        if (instance == null) {
            instance = new LoaiSanPhamDAO();
        }
        return instance;
    }

    private static LoaiSanPhamModel createLoaiSanPhamModelFromResultSet(ResultSet rs) throws SQLException {
        String maLoaiSP = rs.getString("maLoaiSP");
        String tenLoaiSP = rs.getString("tenLoaiSP");
        String Mota = rs.getString("Mota");
        return new LoaiSanPhamModel(maLoaiSP, tenLoaiSP, Mota);
    }

    @Override
    public ArrayList<LoaiSanPhamModel> readDatabase() {
        ArrayList<LoaiSanPhamModel> loaiSanPhamList = new ArrayList<>();
        try (
                ResultSet rs = DatabaseConnection.executeQuery("SELECT * FROM loaisanpham")) {
            while (rs.next()) {
                LoaiSanPhamModel loaiSanPhamModel = createLoaiSanPhamModelFromResultSet(rs);
                loaiSanPhamList.add(loaiSanPhamModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loaiSanPhamList;
    }

    @Override
    public int insert(LoaiSanPhamModel loaiSanPhamModel) {
        String insertSql = "INSERT INTO loaisanpham (maLoaiSP, tenLoaiSP) VALUES (?, ?)";
        Object[] args = {
                loaiSanPhamModel.getMaLoaiSP(),
                loaiSanPhamModel.getTenLoaiSP()
        };
        try {
            return DatabaseConnection.executeUpdate(insertSql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(LoaiSanPhamModel loaiSanPhamModel) {
        String updateSql = "UPDATE loaisanpham SET maLoaiSP = ?, tenLoaiSP = ? WHERE maLoaiSP = ?";
        Object[] args = {
                loaiSanPhamModel.getMaLoaiSP(),
                loaiSanPhamModel.getTenLoaiSP(),
                loaiSanPhamModel.getMaLoaiSP()
        };
        try {
            return DatabaseConnection.executeUpdate(updateSql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(String maLoaiSP) {
        String deleteSql = "DELETE FROM loaisanpham WHERE maLoaiSP = ?";
        Object[] args = { maLoaiSP };
        try {
            return DatabaseConnection.executeUpdate(deleteSql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<LoaiSanPhamModel> search(String condition, String[] columnNames) {
        try {
            if (condition == null || condition.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Search condition cannot be empty or null");
            }

            String query;
            if (columnNames == null || columnNames.length == 0) {
                query = "SELECT * FROM loaisanpham WHERE CONCAT(maLoaiSP, tenLoaiSP) LIKE ?";
            } else if (columnNames.length == 1) {
                String column = columnNames[0];
                query = "SELECT * FROM loaisanpham WHERE " + column + " LIKE ?";
            } else {
                query = "SELECT maLoaiSP, tenLoaiSP FROM loaisanpham WHERE CONCAT("
                        +
                        String.join(", ", columnNames) +
                        ") LIKE ?";
            }

            try (
                    PreparedStatement pst = DatabaseConnection.getPreparedStatement(
                            query,
                            "%" + condition + "%")) {
                try (ResultSet rs = pst.executeQuery()) {
                    List<LoaiSanPhamModel> loaiSanPhamList = new ArrayList<>();
                    while (rs.next()) {
                        LoaiSanPhamModel loaiSanPhamModel = createLoaiSanPhamModelFromResultSet(rs);
                        loaiSanPhamList.add(loaiSanPhamModel);
                    }

                    if (loaiSanPhamList.isEmpty()) {
                        throw new SQLException(
                                "No records found for the given condition: " + condition);
                    }

                    return loaiSanPhamList;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}