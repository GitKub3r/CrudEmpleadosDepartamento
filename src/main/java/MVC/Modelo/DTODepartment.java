package MVC.Modelo;

import java.util.ArrayList;

public class DTODepartment {
    private int id;
    private String name;
    private ArrayList<DTOEmployee> employees = new ArrayList<>();
    private DAOEmployee DAOEmp = new DAOEmployee();

    public DTODepartment() {
    }

    public DTODepartment(String name) {
        this.name = name;
    }

    public DTODepartment(int id, String name) {
        this.id = id;
        this.name = name;
        this.employees = DAOEmp.getAllEmployeesByDptoID(this.id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<DTOEmployee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<DTOEmployee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "DTODepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
