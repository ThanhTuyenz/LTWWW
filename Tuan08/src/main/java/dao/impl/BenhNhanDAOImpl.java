package dao.impl;

import dao.BenhNhanDAO;
import model.BenhNhan;
import utils.DataSourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanDAOImpl implements BenhNhanDAO {

    @Override
    public List<BenhNhan> getAllBenhNhan() {
        List<BenhNhan> list = new ArrayList<>();
        String sql = "SELECT * FROM benhnhan";
        try (Connection conn = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addBenhNhan(BenhNhan bn) {
        String sql = "INSERT INTO benhnhan (MABN, HOTEN, NGAYNHAPVIEN, CHUANDOAN, MAKHOA) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bn.getMaBn());
            ps.setString(2, bn.getHoTen());
            ps.setDate(3, new java.sql.Date(bn.getNgayNhapVien().getTime()));
            ps.setString(4, bn.getChuanDoan());
            ps.setInt(5, bn.getMaKhoa());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BenhNhan> searchByName(String name) {
        List<BenhNhan> list = new ArrayList<>();
        String sql = "SELECT * FROM benhnhan WHERE HOTEN LIKE ?";
        try (Connection conn = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BenhNhan> getByKhoa(int maKhoa) {
        List<BenhNhan> list = new ArrayList<>();
        String sql = "SELECT * FROM benhnhan WHERE MAKHOA = ?";
        try (Connection conn = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maKhoa);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteBenhNhan(int maBn) {
        String sql = "DELETE FROM benhnhan WHERE MABN = ?";
        try (Connection conn = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maBn);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BenhNhan getBenhNhanById(int maBn) {
        String sql = "SELECT * FROM benhnhan WHERE MABN = ?";
        try (Connection conn = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maBn);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateBenhNhan(BenhNhan bn) {
        String sql = "UPDATE benhnhan SET HOTEN = ?, NGAYNHAPVIEN = ?, CHUANDOAN = ?, MAKHOA = ? WHERE MABN = ?";
        try (Connection conn = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bn.getHoTen());
            ps.setDate(2, new java.sql.Date(bn.getNgayNhapVien().getTime()));
            ps.setString(3, bn.getChuanDoan());
            ps.setInt(4, bn.getMaKhoa());
            ps.setInt(5, bn.getMaBn());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hàm tiện ích
    private BenhNhan mapRow(ResultSet rs) throws SQLException {
        BenhNhan bn = new BenhNhan();
        bn.setMaBn(rs.getInt("MABN"));
        bn.setHoTen(rs.getString("HOTEN"));
        bn.setNgayNhapVien(rs.getDate("NGAYNHAPVIEN"));
        bn.setChuanDoan(rs.getString("CHUANDOAN"));
        bn.setMaKhoa(rs.getInt("MAKHOA"));
        return bn;
    }
}
