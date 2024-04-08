package com.cakestore.qlbanh.bus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cakestore.qlbanh.dao.LoaiSanPhamDAO;
import com.cakestore.qlbanh.interfaces.BUSInterface;
import com.cakestore.qlbanh.models.LoaiSanPhamModel;

public class LoaiSanPhamBUS implements BUSInterface<LoaiSanPhamModel> {
    private final List<LoaiSanPhamModel> loaiSanPhamList = new ArrayList<>();
    private static LoaiSanPhamBUS instance;

    public static LoaiSanPhamBUS getInstance() {
        if (instance == null) {
            instance = new LoaiSanPhamBUS();
        }
        return instance;
    }

    private LoaiSanPhamBUS() {
        this.loaiSanPhamList.addAll(LoaiSanPhamDAO.getInstance().readDatabase());
    }

    public List<LoaiSanPhamModel> getAllModels() {
        return Collections.unmodifiableList(loaiSanPhamList);
    }

    public void refreshData() {
        loaiSanPhamList.clear();
        loaiSanPhamList.addAll(LoaiSanPhamDAO.getInstance().readDatabase());
    }

    public LoaiSanPhamModel getModelById(String id) {
        refreshData();
        for (LoaiSanPhamModel loaiSanPham : loaiSanPhamList) {
            if (loaiSanPham.getMaLoaiSP().equals(id)) {
                return loaiSanPham;
            }
        }
        return null;
    }

    private LoaiSanPhamModel mapToEntity(LoaiSanPhamModel from) {
        LoaiSanPhamModel to = new LoaiSanPhamModel();
        updateEntityFields(from, to);
        return to;
    }

    private void updateEntityFields(LoaiSanPhamModel from, LoaiSanPhamModel to) {
        to.setMaLoaiSP(from.getMaLoaiSP());
        to.setTenLoaiSP(from.getTenLoaiSP());
    }

    public int addModel(LoaiSanPhamModel loaiSanPham) {
        int id = LoaiSanPhamDAO.getInstance().insert(mapToEntity(loaiSanPham));
        loaiSanPham.setMaLoaiSP(String.valueOf(id));
        loaiSanPhamList.add(loaiSanPham);
        return id;
    }

    public int updateModel(LoaiSanPhamModel loaiSanPham) {
        int updatedRows = LoaiSanPhamDAO.getInstance().update(loaiSanPham);
        if (updatedRows > 0) {
            int index = loaiSanPhamList.indexOf(loaiSanPham);
            if (index != -1) {
                loaiSanPhamList.set(index, loaiSanPham);
            }
        }
        return updatedRows;
    }

    public int deleteModel(String id) {
        LoaiSanPhamModel loaiSanPham = getModelById(id);
        if (loaiSanPham == null) {
            throw new IllegalArgumentException(
                    "Mã loại sản phẩm với ID: " + id + " không tồn tại.");
        }
        int deletedRows = LoaiSanPhamDAO.getInstance().delete(id);
        if (deletedRows > 0) {
            loaiSanPhamList.remove(loaiSanPham);
        }
        return deletedRows;
    }

    public List<LoaiSanPhamModel> searchModel(String value, String[] columns) {
        List<LoaiSanPhamModel> results = new ArrayList<>();
        List<LoaiSanPhamModel> categories = LoaiSanPhamDAO.getInstance().search(value, columns);
        for (LoaiSanPhamModel loaiSanPham : categories) {
            LoaiSanPhamModel loaiSanPhamModel = mapToEntity(loaiSanPham);
            if (checkFilter(loaiSanPhamModel, value, columns)) {
                results.add(loaiSanPhamModel);
            }
        }
        return results;
    }

    private boolean checkFilter(
            LoaiSanPhamModel loaiSanPham,
            String value,
            String[] columns) {
        for (String column : columns) {
            switch (column.toLowerCase()) {
                case "MaLoaiSP" -> {
                    if (value.equals(loaiSanPham.getMaLoaiSP())) {
                        return true;
                    }
                }
                case "TenLoaiSP" -> {
                    if (value.contains(loaiSanPham.getTenLoaiSP().toLowerCase())) {
                        return true;
                    }
                }
                default -> {
                }
            }
        }
        return false;
    }

}