package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private Connection connection = null;

    public void openConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ChatDB" , "postgre", "Nikodem1989");
        }
        catch (Exception e) {
            System.out.println(e.getClass().getName() + " --> " + e.getMessage());
        }
    }

    public void closeConnection()  {
        try {
            if (connection != null)
                connection.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage() + " --> " + "connection with DB wasn't closed properly.");
        }
    }
}
