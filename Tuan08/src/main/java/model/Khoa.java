package model;

public class Khoa {
    private int maKhoa;
    private String tenKhoa;
    private String truongKhoa;
    private String moTa;

    public Khoa() {
        // Constructor mặc định (cần cho JSP/Servlet, JDBC, hoặc frameworks như Hibernate)
    }
    public Khoa(int maKhoa,String tenKhoa,  String truongKhoa, String moTa) {
        this.tenKhoa = tenKhoa;
        this.maKhoa = maKhoa;
        this.truongKhoa = truongKhoa;
        this.moTa = moTa;
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public String getTruongKhoa() {
        return truongKhoa;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMaKhoa(int maKhoa) {
        this.maKhoa = maKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public void setTruongKhoa(String truongKhoa) {
        this.truongKhoa = truongKhoa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
