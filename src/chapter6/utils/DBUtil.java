package chapter6.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import chapter6.exception.SQLRuntimeException;

/**
 * DB(コネクション関係)のユーティリティー
 */
public class DBUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/simple_twitter";
    private static final String USER = "root";
<<<<<<< HEAD
    private static final String PASSWORD = "miuraami1010";
=======
    private static final String PASSWORD = "Nozomu@@1933";
>>>>>>> 02bb6ead58900eda7ad526c52db6c2418e2f6fb8

    static {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * コネクションを取得します。
     *
     * @return
     */
    public static Connection getConnection() {

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        }
    }

    /**
     * コミットします。
     *
     * @param connection
     */
    public static void commit(Connection connection) {

        try {
            connection.commit();
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        }
    }

    /**
     * ロールバックします。
     *
     * @param connection
     */
    public static void rollback(Connection connection) {

        if (connection == null) {
            return;
        }

        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        }
    }
}

