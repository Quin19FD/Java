package com.cakestore.qlbanh.models;

import java.sql.Date;

public class KhuyenMaiModel {
    private String id;
    private String tenKhuyenMai;
    private float dieuKien;
    private float phanTramGiamGia;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public KhuyenMaiModel() {
    }

    public KhuyenMaiModel(String id, String tenKhuyenMai, float dieuKien, float phanTramGiamGia, Date ngayBatDau,
            Date ngayKetThuc) {
        this.id = id;
        this.tenKhuyenMai = tenKhuyenMai;
        this.dieuKien = dieuKien;
        this.phanTramGiamGia = phanTramGiamGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenKhuyenMai() {
        return this.tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public float getDieuKien() {
        return this.dieuKien;
    }

    public void setDieuKien(float dieuKien) {
        this.dieuKien = dieuKien;
    }

    public float getPhanTramGiamGia() {
        return this.phanTramGiamGia;
    }

    public void setPhanTramGiamGia(float phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public Date getNgayBatDau() {
        return this.ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return this.ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public KhuyenMaiModel id(String id) {
        setId(id);
        return this;
    }

    public KhuyenMaiModel tenKhuyenMai(String tenKhuyenMai) {
        setTenKhuyenMai(tenKhuyenMai);
        return this;
    }

    public KhuyenMaiModel dieuKien(float dieuKien) {
        setDieuKien(dieuKien);
        return this;
    }

    public KhuyenMaiModel phanTramGiamGia(float phanTramGiamGia) {
        setPhanTramGiamGia(phanTramGiamGia);
        return this;
    }

    public KhuyenMaiModel ngayBatDau(Date ngayBatDau) {
        setNgayBatDau(ngayBatDau);
        return this;
    }

    public KhuyenMaiModel ngayKetThuc(Date ngayKetThuc) {
        setNgayKetThuc(ngayKetThuc);
        return this;
    }

}
