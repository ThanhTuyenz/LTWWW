package utils;

import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/qlbenhnhan?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    private static MysqlDataSource dataSource;

    // Chỉ tạo 1 lần duy nhất (singleton)
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setURL(URL);
            dataSource.setUser(USER);
            dataSource.setPassword(PASSWORD);
        }
        return dataSource;
    }
}