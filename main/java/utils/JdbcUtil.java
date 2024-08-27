package utils;



public class JdbcUtil {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/niit?useSSL=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "chenyuran2";
    public static java.sql.Connection getConnection() {
        java.sql.Connection conn =null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = java.sql.DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(java.sql.Connection conn, java.sql.Statement stmt, java.sql.ResultSet rs) {
        try {
            if (rs!= null) {
                rs.close();
            }
            if (stmt!= null) {
                stmt.close();
            }
            if (conn!= null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(java.sql.Connection conn, java.sql.Statement stmt) {
        try {
            if (stmt!= null) {
                stmt.close();
            }
            if (conn!= null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(JdbcUtil.getConnection());
    }
}
