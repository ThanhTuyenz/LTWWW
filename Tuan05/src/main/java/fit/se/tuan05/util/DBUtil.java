package fit.se.tuan05.util;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mariadb://localhost:3306/quanlydienthoai";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
