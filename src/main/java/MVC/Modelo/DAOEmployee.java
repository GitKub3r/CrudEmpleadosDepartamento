package MVC.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class DAOEmployee {
    private Connection con = null;

    public DAOEmployee() {
        con = Database.openConnection();
    }

    public void showEmployees(ArrayList<DTOEmployee> employees) {
        for (DTOEmployee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public ArrayList<DTOEmployee> getEmployeesOrderedByName(String orderBy) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Empleados ORDER BY Nombre " + orderBy);
            ArrayList<DTOEmployee> employees = new ArrayList<>();

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("nombre");
                int age = result.getInt("edad");
                int dpto_id = result.getInt("dpto_id");

                DTOEmployee employee = new DTOEmployee(name, age, dpto_id);
                employee.setId(result.getInt("id"));
                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<DTOEmployee> getEmployeesOrderedByAge(String orderBy) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Empleados ORDER BY Edad " + orderBy);
            ArrayList<DTOEmployee> employees = new ArrayList<>();

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("nombre");
                int age = result.getInt("edad");
                int dpto_id = result.getInt("dpto_id");

                DTOEmployee employee = new DTOEmployee(name, age, dpto_id);
                employee.setId(result.getInt("id"));
                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<DTOEmployee> getEmployeesOrderedByID(String orderBy) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Empleados ORDER BY id " + orderBy);
            ArrayList<DTOEmployee> employees = new ArrayList<>();

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("nombre");
                int age = result.getInt("edad");
                int dpto_id = result.getInt("dpto_id");

                DTOEmployee employee = new DTOEmployee(name, age, dpto_id);
                employee.setId(result.getInt("id"));
                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<DTOEmployee> getAllEmployeesByDptoID(int dptoID) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Empleados WHERE dpto_id = ?");
            statement.setInt(1, dptoID);
            ArrayList<DTOEmployee> employees = new ArrayList<>();

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("nombre");
                int age = result.getInt("edad");
                int dpto_id = result.getInt("dpto_id");

                DTOEmployee employee = new DTOEmployee(name, age, dpto_id);
                employee.setId(id);

                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<DTOEmployee> getAllEmployees() {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Empleados");
            ArrayList<DTOEmployee> employees = new ArrayList<>();

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String name = result.getString("nombre");
                int age = result.getInt("edad");
                int dptoID = result.getInt("dpto_id");

                DTOEmployee employee = new DTOEmployee(name, age, dptoID);
                employee.setId(result.getInt("id"));
                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return null;
    }

    public int addEmployee(DTOEmployee employee) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO Empleados (nombre, edad, dpto_id) VALUES (?, ?, ?)");

            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setInt(3, employee.getDptoID());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return -1;
    }

    public int updateEmployee(DTOEmployee employee) {
        try {
            PreparedStatement statement = con.prepareStatement("UPDATE Empleados SET nombre = ?, edad = ?, dpto_id = ? WHERE id = ?");

            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setInt(3, employee.getDptoID());
            statement.setInt(4, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return -1;
    }

    public int deleteEmployeeByID(int id) {
        try {
            PreparedStatement statement = con.prepareStatement("DELETE FROM Empleados WHERE id = ?");

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return -1;
    }

    public int deleteEmployeeByName(String name) {
        try {
            PreparedStatement statement = con.prepareStatement("DELETE FROM Empleados WHERE nombre = ?");

            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return -1;
    }

    public int deleteAllEmployees() {
        try {
            PreparedStatement statement = con.prepareStatement("DELETE FROM Empleados");

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return -1;
    }

    public void restoreEmployees() {
        String[] names = {"Carlos", "Juan", "Alejandro", "María", "Pedro", "Lucía", "Jose", "Bea","Carlota", "Alberto"};
        Random random = new Random();
        for (String name : names) {
            int age = random.nextInt(18, 51);
            int dptoID = random.nextInt(1, 101);
            addEmployee(new DTOEmployee(name, age, dptoID));
        }
    }
}
