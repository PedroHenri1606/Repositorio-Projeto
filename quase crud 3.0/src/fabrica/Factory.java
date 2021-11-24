package fabrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
    public Connection getConection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/uniflow", "root", "eduardo123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
