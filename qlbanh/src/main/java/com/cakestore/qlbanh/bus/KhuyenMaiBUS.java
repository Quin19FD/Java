package com.cakestore.qlbanh.bus;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cakestore.qlbanh.interfaces.BUSInterface;
import com.cakestore.qlbanh.models.KhuyenMaiModel;
import com.cakestore.qlbanh.dao.KhuyenMaiDAO;

public class KhuyenMaiBUS implements BUSInterface<KhuyenMaiModel> {
    private final List<KhuyenMaiModel> discountList = new ArrayList<>();
    private static KhuyenMaiBUS instance;

    public static KhuyenMaiBUS getInstance() {
        if (instance == null) {
            instance = new KhuyenMaiBUS();
        }
        return instance;
    }

    private KhuyenMaiBUS() {
        this.discountList.addAll(KhuyenMaiDAO.getInstance().readDatabase());
    }

    @Override
    public List<KhuyenMaiModel> getAllModels() {
        return Collections.unmodifiableList(discountList);
    }

    @Override
    public void refreshData() {
        discountList.clear();
        discountList.addAll(KhuyenMaiDAO.getInstance().readDatabase());
    }

    @Override
    public KhuyenMaiModel getModelById(String id) {
        for (KhuyenMaiModel KhuyenMaiModel : discountList) {
            if (KhuyenMaiModel.getId().equals(id)) {
                return KhuyenMaiModel;
            }
        }
        return null;
    }

    private KhuyenMaiModel mapToEntity(KhuyenMaiModel from) {
        KhuyenMaiModel to = new KhuyenMaiModel();
        updateEntityFields(from, to);
        return to;
    }

    private void updateEntityFields(KhuyenMaiModel from, KhuyenMaiModel to) {
        to.setId(from.getId());
        to.setTenKhuyenMai(from.getTenKhuyenMai());
        to.setPhanTramGiamGia(from.getPhanTramGiamGia());
        to.setNgayBatDau(from.getNgayBatDau());
        to.setNgayKetThuc(from.getNgayKetThuc());
    }

    @Override
    public int addModel(KhuyenMaiModel KhuyenMaiModel) {
        int id = KhuyenMaiDAO.getInstance().insert(mapToEntity(KhuyenMaiModel));
        KhuyenMaiModel.setId(String.valueOf(id));
        discountList.add(KhuyenMaiModel);
        return id;
    }

    @Override
    public int updateModel(KhuyenMaiModel KhuyenMaiModel) {
        int updatedRows = KhuyenMaiDAO.getInstance().update(KhuyenMaiModel);
        if (updatedRows > 0) {
            int index = discountList.indexOf(KhuyenMaiModel);
            if (index != -1) {
                discountList.set(index, KhuyenMaiModel);
            }
        }
        return updatedRows;
    }

    @Override
    public int deleteModel(String id) {
        KhuyenMaiModel KhuyenMaiModel = getModelById(id);
        if (KhuyenMaiModel == null) {
            throw new IllegalArgumentException(
                    "Mã khuyến mãi với" + id + " không tồn tại");
        }
        int deletedRows = KhuyenMaiDAO.getInstance().delete(id);
        if (deletedRows > 0) {
            discountList.remove(KhuyenMaiModel);
        }
        return deletedRows;
    }

    @Override
    public List<KhuyenMaiModel> searchModel(String value, String[] columns) {
        List<KhuyenMaiModel> results = new ArrayList<>();
        List<KhuyenMaiModel> entities = KhuyenMaiDAO.getInstance().search(value, columns);
        for (KhuyenMaiModel entity : entities) {
            if (checkFilter(entity, value, columns)) {
                results.add(entity);
            }
        }
        return results;
    }

    public List<KhuyenMaiModel> searchDateToDate(Date fromDate, Date toDate) {
        checkDateValidation(fromDate, toDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fromDateStr = (fromDate != null) ? sdf.format(fromDate) : null;
        String toDateStr = (toDate != null) ? sdf.format(toDate) : null;
        List<KhuyenMaiModel> results = KhuyenMaiDAO.getInstance().searchDatetoDate(fromDateStr, toDateStr);
        if (results.isEmpty())
            throw new IllegalArgumentException("Không có khuyến mãi nào trong khoảng thời gian mà bạn tìm kiếm");
        return results;
    }

    private boolean checkFilter(
            KhuyenMaiModel KhuyenMaiModel,
            String value,
            String[] columns) {
        for (String column : columns) {
            switch (column.toLowerCase()) {
                case "MaKM" -> {
                    if (value.equals(KhuyenMaiModel.getId())) {
                        return true;
                    }
                }
                case "TenKH" -> {
                    if (value.contains(KhuyenMaiModel.getTenKhuyenMai().toLowerCase())) {
                        return true;
                    }
                }
                case "PhanTramGiamGia" -> {
                    if (Float.parseFloat(value) == KhuyenMaiModel.getPhanTramGiamGia()) {
                        return true;
                    }
                }
                case "NgayBatDau" -> {
                    if (value.contains(KhuyenMaiModel.getNgayBatDau().toString())) {
                        return true;
                    }
                }
                case "NgayKetThuc" -> {
                    if (value.contains(KhuyenMaiModel.getNgayKetThuc().toString())) {
                        return true;
                    }
                }
                default -> {
                    if (KhuyenMaiModel.getId().contains(value)
                            || KhuyenMaiModel.getTenKhuyenMai().toLowerCase().contains(value)
                            || Float.toString(KhuyenMaiModel.getPhanTramGiamGia()).contains(value)
                            || KhuyenMaiModel.getNgayBatDau().toString().contains(value)
                            || KhuyenMaiModel.getNgayKetThuc().toString().contains(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void checkDateValidation(Date fromDate, Date toDate) {
        Date currentDate = new Date(System.currentTimeMillis());
        if (fromDate == null && toDate != null) {
            throw new IllegalArgumentException("Không được để trống ngày bắt đầu");
        } else if (toDate == null && fromDate != null) {
            throw new IllegalArgumentException("Không được để trống ngày kết thúc");
        } else if (fromDate == null && toDate == null) {
            throw new IllegalArgumentException("Chưa nhập dữ liệu ngày tháng");
        } else {
            int result1 = fromDate.compareTo(currentDate);
            int result2 = toDate.compareTo(currentDate);
            int result3 = fromDate.compareTo(toDate);
            if (result1 > 0) {
                throw new IllegalArgumentException("Ngày bắt đầu không thể lớn hơn ngày hiện tại.");
            } else if (result2 > 0) {
                throw new IllegalArgumentException("Ngày kết thúc không thể lớn hơn ngày hiện tại.");
            } else if (result3 > 0) {
                throw new IllegalArgumentException("Ngày bắt đầu không thể lớn hơn ngày kết thúc.");
            }
        }
    }
}
