package fit.se.tuan05.model;

public class DienThoai {
    private String madt;
    private String tendt;
    private int namsanxuat;
    private String cauhinh;
    private String mancc;
    private String hinhanh;

    public DienThoai() {}

    public DienThoai(String madt, String tendt, int namsanxuat, String cauhinh, String mancc, String hinhanh) {
        this.madt = madt;
        this.tendt = tendt;
        this.namsanxuat = namsanxuat;
        this.cauhinh = cauhinh;
        this.mancc = mancc;
        this.hinhanh = hinhanh;
    }

    public String getMadt() {
        return madt;
    }

    public void setMadt(String madt) {
        this.madt = madt;
    }

    public String getTendt() {
        return tendt;
    }

    public void setTendt(String tendt) {
        this.tendt = tendt;
    }

    public int getNamsanxuat() {
        return namsanxuat;
    }

    public void setNamsanxuat(int namsanxuat) {
        this.namsanxuat = namsanxuat;
    }

    public String getCauhinh() {
        return cauhinh;
    }

    public void setCauhinh(String cauhinh) {
        this.cauhinh = cauhinh;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}