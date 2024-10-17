package ASMFinal.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConnector {
    // Thông tin kết nối
    private static final String JDBC_URL = "jdbc:sqlserver://localhost;databaseName=CongNgheJava;encrypt=true;trustServerCertificate=true";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "123";


    // Hàm để kết nối với SQL Server
    public static Connection connectToDatabase() {
        Connection conn = null;
        try {
            // Đăng ký driver JDBC cho SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Tạo kết nối
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Kết nối thành công với SQL Server!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn; // Trả về đối tượng Connection
    }
}
