package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdb:mysql://127.0.0.1:3306/CARRENTAL";
    private static final String USER = "ROOT";
    private static final String PASSWORD = "813297";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

}
