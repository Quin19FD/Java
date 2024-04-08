package com.cakestore.qlbanh.models;

import java.sql.Timestamp;

public class PhieuNhapModel {
    private int maPhieuNhap;
    private int maNhanVien;
    private int maNhaCungCap;
    private Timestamp ngayNhap;
    private double tongTien;

    public PhieuNhapModel() {
    }

    public PhieuNhapModel(int maPhieuNhap, int maNhanVien, int maNhaCungCap, Timestamp ngayNhap, double tongTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNhanVien = maNhanVien;
        this.maNhaCungCap = maNhaCungCap;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public int getMaPhieuNhap() {
        return this.maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public int getMaNhanVien() {
        return this.maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaNhaCungCap() {
        return this.maNhaCungCap;
    }

    public void setMaNhaCungCap(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public Timestamp getNgayNhap() {
        return this.ngayNhap;
    }

    public void setNgayNhap(Timestamp ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getTongTien() {
        return this.tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public PhieuNhapModel maPhieuNhap(int maPhieuNhap) {
        setMaPhieuNhap(maPhieuNhap);
        return this;
    }

    public PhieuNhapModel maNhanVien(int maNhanVien) {
        setMaNhanVien(maNhanVien);
        return this;
    }

    public PhieuNhapModel maNhaCungCap(int maNhaCungCap) {
        setMaNhaCungCap(maNhaCungCap);
        return this;
    }

    public PhieuNhapModel ngayNhap(Timestamp ngayNhap) {
        setNgayNhap(ngayNhap);
        return this;
    }

    public PhieuNhapModel tongTien(double tongTien) {
        setTongTien(tongTien);
        return this;
    }

}
