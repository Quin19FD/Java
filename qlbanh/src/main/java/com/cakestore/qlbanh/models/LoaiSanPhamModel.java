package com.cakestore.qlbanh.models;

public class LoaiSanPhamModel {
    private String maLoaiSP;
    private String tenLoaiSP;


    public LoaiSanPhamModel() {
    }

    public LoaiSanPhamModel(String maLoaiSP, String tenLoaiSP) {
        this.maLoaiSP = maLoaiSP;
        this.tenLoaiSP = tenLoaiSP;
    }

    public String getMaLoaiSP() {
        return this.maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getTenLoaiSP() {
        return this.tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public LoaiSanPhamModel maLoaiSP(String maLoaiSP) {
        setMaLoaiSP(maLoaiSP);
        return this;
    }

    public LoaiSanPhamModel tenLoaiSP(String tenLoaiSP) {
        setTenLoaiSP(tenLoaiSP);
        return this;
    }
}
