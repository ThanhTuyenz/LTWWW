package fit.se.tuan05.model;

public class NhaCungCap {
    private String mancc;
    private String tennhacc;
    private String diachi;
    private String sodienthoai;

    public NhaCungCap() {}
    public NhaCungCap(String mancc, String tennhacc, String diachi, String sodienthoai) {
        this.mancc = mancc;
        this.tennhacc = tennhacc;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getTennhacc() {
        return tennhacc;
    }

    public void setTennhacc(String tennhacc) {
        this.tennhacc = tennhacc;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }
}
