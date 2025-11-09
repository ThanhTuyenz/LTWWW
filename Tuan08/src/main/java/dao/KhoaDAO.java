package dao;

import model.Khoa;
import java.util.List;

public interface KhoaDAO {

    List<Khoa> getAllKhoa();

    void addKhoa(Khoa khoa);

    void deleteKhoa(int maKhoa);
}
