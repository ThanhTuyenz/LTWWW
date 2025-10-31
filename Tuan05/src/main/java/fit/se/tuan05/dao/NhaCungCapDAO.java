package fit.se.tuan05.dao;

import fit.se.tuan05.model.NhaCungCap;
import fit.se.tuan05.util.DBUtil;
import java.sql.*;
import java.util.*;

public class NhaCungCapDAO {
    public List<NhaCungCap> findAll() throws SQLException {
        String sql = "SELECT * FROM nhacungcap";
        List<NhaCungCap> list = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new NhaCungCap(
                        rs.getString("MANCC"),
                        rs.getString("TENNHACC"),
                        rs.getString("DIACHI"),
                        rs.getString("SODIENTHOAI")
                ));
            }
        }
        return list;
    }

}
