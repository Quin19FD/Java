package com.cakestore.qlbanh.models;

public class LoaiSanPhamModel {
    private String maLoaiSP;
    private String tenLoaiSP;
    private String Mota;


    public LoaiSanPhamModel() {
    }

    public LoaiSanPhamModel(String maLoaiSP, String tenLoaiSP, String Mota) {
        this.maLoaiSP = maLoaiSP;
        this.tenLoaiSP = tenLoaiSP;
        this.Mota = Mota;
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
    public String getMota() {
        return this.Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }


    public LoaiSanPhamModel maLoaiSP(String maLoaiSP) {
        setMaLoaiSP(maLoaiSP);
        return this;
    }

    public LoaiSanPhamModel tenLoaiSP(String tenLoaiSP) {
        setTenLoaiSP(tenLoaiSP);
        return this;
    }
    public LoaiSanPhamModel Mota(String Mota) {
        setMota(Mota);
        return this;
    }
}
