package MVC.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAODepartment {
    private Connection con = null;

    public DAODepartment() {
        con = Database.openConnection();
    }

    public void showDepartments(ArrayList<DTODepartment> departments) {
        for (DTODepartment department : departments ) {
            System.out.println(department.toString());
        }
    }

    public ArrayList<DTODepartment> getDepartmentsOrderedByName(String orderBy) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Departamento ORDER BY nombre " + orderBy);
            ArrayList<DTODepartment> departments = new ArrayList<>();

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String nombre = result.getString("nombre");

                departments.add(new DTODepartment(id, nombre));
            }

            return departments;
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<DTODepartment> getDepartmentsOrderedById(String orderBy) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Departamento ORDER BY id " + orderBy);
            ArrayList<DTODepartment> departments = new ArrayList<>();

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String nombre = result.getString("nombre");

                departments.add(new DTODepartment(id, nombre));
            }

            return departments;
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<DTODepartment> getAllDepartments() {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Departamento");
            ResultSet result = statement.executeQuery();
            ArrayList<DTODepartment> departments = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("nombre");

                departments.add(new DTODepartment(id, name));
            }

            return departments;
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return null;
    }

    public int addDepartment(DTODepartment department) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO Departamento (nombre) VALUES (?)");
            statement.setString(1, department.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }
        return -1;
    }

    public int updateDepartment(DTODepartment department) {
        try {
            PreparedStatement statement = con.prepareStatement("UPDATE Departamento SET nombre = ? WHERE id = ?");
            statement.setString(1, department.getName());
            statement.setInt(2, department.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return -1;
    }

    public int deleteDepartmentByID(int id) {
        try {
            PreparedStatement statement = con.prepareStatement("DELETE FROM Empleados WHERE dpto_id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();

            statement = con.prepareStatement("DELETE FROM Departamento WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB ERROR (DELETE_ID): " + e.getMessage());
        }

        return -1;
    }

    public int deleteAllDepartments() {
        try {
            PreparedStatement statement = con.prepareStatement("DELETE FROM Departamento");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB ERROR: " + e.getMessage());
        }

        return -1;
    }

    public void restoreDepartments() {
        String[] names = {"Marketing", "RRHH", "Tecnología", "Diseño", "Administración"};

        for (String name : names) {
            addDepartment(new DTODepartment(name));
        }
    }
}
