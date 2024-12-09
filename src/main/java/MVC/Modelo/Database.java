package MVC.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String url = "jdbc:mariadb://localhost:3306/db_empleados";
    private static String user = "root";
    private static String password = "";
    private static Connection con = null;

    public static Connection openConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(url, user, password);
                System.out.println("Conexion establecida(" + con.getCatalog() + ")");
            } catch(SQLException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }

        return con;
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());;
        }
    }
}
