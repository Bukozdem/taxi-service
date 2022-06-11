package taxi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String URL =
            "mysql://b8b9cb1eb069d0:c0c46d14@eu-cdbr-west-02.cleardb.net"
                    + "/heroku_5b5c2c9bc24e02b?useUnicode=true"
                    + "&characterEncoding=utf-8&reconnect=true";
    private static final String USERNAME = "b8b9cb1eb069d0";
    private static final String PASSWORD = "c0c46d14";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getConnection() {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        try {
            return DriverManager.getConnection(URL, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DB ", e);
        }
    }
}
