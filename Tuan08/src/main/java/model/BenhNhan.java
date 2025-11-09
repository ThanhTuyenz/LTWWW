package model;

import java.util.Date;

public class BenhNhan {
    private int maBn;
    private String hoTen;
    private Date ngayNhapVien;
    private String chuanDoan;
    private int maKhoa;
    public BenhNhan() {
        // Constructor mặc định (cần cho JSP/Servlet, JDBC, hoặc frameworks như Hibernate)
    }

    public BenhNhan(int maBn, String hoTen, Date ngayNhapVien, String chuanDoan, int maKhoa) {
        this.maBn = maBn;
        this.hoTen = hoTen;
        this.ngayNhapVien = ngayNhapVien;
        this.chuanDoan = chuanDoan;
        this.maKhoa = maKhoa;
    }

    public int getMaBn() {
        return maBn;
    }

    public void setMaBn(int maBn) {
        this.maBn = maBn;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(Date ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(int maKhoa) {
        this.maKhoa = maKhoa;
    }
}
