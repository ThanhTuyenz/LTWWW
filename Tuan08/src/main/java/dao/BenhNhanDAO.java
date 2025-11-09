package dao;

import model.BenhNhan;
import java.util.List;

public interface BenhNhanDAO {
    List<BenhNhan> getAllBenhNhan();
    void addBenhNhan(BenhNhan bn);
    List<BenhNhan> searchByName(String name);
    List<BenhNhan> getByKhoa(int maKhoa);
    void deleteBenhNhan(int maBn);
    BenhNhan getBenhNhanById(int maBn);
    void updateBenhNhan(BenhNhan bn);
}
