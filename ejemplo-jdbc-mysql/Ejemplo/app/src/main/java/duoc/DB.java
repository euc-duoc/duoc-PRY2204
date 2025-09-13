package duoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DB {
    private static DB instance;
    
    public static DB getInstance() throws SQLException {
        if(instance == null)
            instance = new DB();
        
        return instance;
    }
    
    private Connection conn;
    
    public DB() throws SQLException {
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/duoc?allowPublicKeyRetrieval=true&useSSL=false",
            "root",
            "1234"
        );
    }
    
    public Connection getConnection() {
        return conn;
    }
}
