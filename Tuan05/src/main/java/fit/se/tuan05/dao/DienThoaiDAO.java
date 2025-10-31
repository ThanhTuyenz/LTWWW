package fit.se.tuan05.dao;

import fit.se.tuan05.model.DienThoai;
import fit.se.tuan05.util.DBUtil;
import java.sql.*;
import java.util.*;

public class DienThoaiDAO {
    public List<DienThoai> findByMancc(String mancc) throws SQLException {
        String sql = "SELECT * FROM dienthoai WHERE MANCC = ?";
        List<DienThoai> list = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, mancc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DienThoai(
                        rs.getString("MADT"),
                        rs.getString("TENDT"),
                        rs.getInt("NAMSANXUAT"),
                        rs.getString("CAUHINH"),
                        rs.getString("MANCC"),
                        rs.getString("HINHANH")
                ));
            }
        }
        return list;
    }

    public void insert(DienThoai d) throws SQLException {
        String sql = "INSERT INTO dienthoai VALUES(?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, d.getMadt());
            ps.setString(2, d.getTendt());
            ps.setInt(3, d.getNamsanxuat());
            ps.setString(4, d.getCauhinh());
            ps.setString(5, d.getMancc());
            ps.setString(6, d.getHinhanh());
            ps.executeUpdate();
        }
    }

    public DienThoai findById(String madt) throws SQLException {
        String sql = "SELECT * FROM dienthoai WHERE MADT = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, madt);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new DienThoai(
                        rs.getString("MADT"),
                        rs.getString("TENDT"),
                        rs.getInt("NAMSANXUAT"),
                        rs.getString("CAUHINH"),
                        rs.getString("MANCC"),
                        rs.getString("HINHANH")
                );
            }
        }
        return null;
    }

    public void update(DienThoai d) throws SQLException {
        String sql = "UPDATE dienthoai SET TENDT=?, NAMSANXUAT=?, CAUHINH=?, MANCC=?, HINHANH=? WHERE MADT=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, d.getTendt());
            ps.setInt(2, d.getNamsanxuat());
            ps.setString(3, d.getCauhinh());
            ps.setString(4, d.getMancc());
            ps.setString(5, d.getHinhanh());
            ps.setString(6, d.getMadt());
            ps.executeUpdate();
        }
    }
}

