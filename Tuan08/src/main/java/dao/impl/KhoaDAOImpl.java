package dao.impl;

import dao.KhoaDAO;
import model.Khoa;
import utils.DataSourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhoaDAOImpl implements KhoaDAO {

    @Override
    public List<Khoa> getAllKhoa() {
        List<Khoa> list = new ArrayList<>();
        String sql = "SELECT * FROM khoa";

        try (Connection conn = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Khoa k = new Khoa(
                        rs.getInt("MAKHOA"),
                        rs.getString("TENKHOA"),
                        rs.getString("TRUONGKHOA"),
                        rs.getString("MOTA")
                );
                list.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addKhoa(Khoa khoa) {
        String sql = "INSERT INTO khoa (MAKHOA, TENKHOA, TRUONGKHOA, MOTA) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, khoa.getMaKhoa());
            ps.setString(2, khoa.getTenKhoa());
            ps.setString(3, khoa.getTruongKhoa());
            ps.setString(4, khoa.getMoTa());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteKhoa(int maKhoa) {
        String sql = "DELETE FROM khoa WHERE MAKHOA = ?";
        try (Connection conn = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maKhoa);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
