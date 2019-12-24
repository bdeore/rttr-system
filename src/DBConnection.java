package sample;
import java.sql.*;

public class DBConnection {
    //private static final String USERNAME ="root";
    private static final String USERNAME ="dba_access";
    private static final String PASSWORD ="root";
    //private static final String CONN = "jdbc:mysql://localhost:3310/primary";
    private static final String CONN = "jdbc:mysql://35.200.158.64:3306/?verifyServerCertificate=true&useSSL=true&requireSSL=true";

    public static Connection getConnection() throws SQLException{

        return DriverManager.getConnection(CONN, USERNAME, PASSWORD);
    }

}
