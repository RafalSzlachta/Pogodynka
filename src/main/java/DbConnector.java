import org.hibernate.mapping.PrimaryKey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private static String URL = "jdbc:mysql://localhost:3306/weather?serverTimezone=Europe/Warsaw";

    private static String USER = "root";

    private static String PASSWORD = "123456";

    public static Connection connect() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
          //  System.out.println("połaczono");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

