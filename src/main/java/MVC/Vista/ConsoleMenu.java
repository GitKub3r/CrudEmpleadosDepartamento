package MVC.Vista;

import MVC.Modelo.DAODepartment;
import MVC.Modelo.DAOEmployee;
import MVC.Modelo.DTODepartment;
import MVC.Modelo.DTOEmployee;

import java.util.Scanner;

public class ConsoleMenu {

    public static void openMenu() {
        Scanner reader = new Scanner(System.in);
        DAOEmployee DAOEmp = new DAOEmployee();
        DAODepartment DAODep = new DAODepartment();

        int menuOption;
        int submenuOption;
        int thirdOption ;
        int fourthOption;

        boolean menuExit = false;
        boolean submenuExit;
        boolean thirdExit;
        boolean fourthExit;

        do {
            System.out.println("MENÚ PRINCIPAL | ACCIONES");
            System.out.println("1. Mostrar Información");
            System.out.println("2. Añadir Información");
            System.out.println("3. Modificar Información");
            System.out.println("4. Eliminar Información");
            System.out.println("5. Restaurar Información");
            System.out.println("0. Salir\n");

            menuOption = reader.nextInt();

            switch (menuOption) {
                case 0:
                    menuExit = true;
                    break;
                case 1:
                    submenuExit = false;
                    do {
                        System.out.println("MENÚ SECUNDARIO | TABLAS");
                        System.out.println("1. Empleados");
                        System.out.println("2. Departamentos");
                        System.out.println("0. Salir");

                        submenuOption = reader.nextInt();

                        switch (submenuOption) {
                            case 0:
                                submenuExit = true;
                                break;
                            case 1:
                                thirdExit = false;
                                do {
                                    System.out.println("MENÚ TERCIARIO | ORDEN EMPLEADOS");
                                    System.out.println("1. Ascendente (ASC)");
                                    System.out.println("2. Descendente (DESC)");

                                    thirdOption = reader.nextInt();

                                    switch (thirdOption) {
                                        case 1:
                                            fourthExit = false;
                                            do {
                                                System.out.println("MENÚ CUATERNARIO | OPCIONES (ASC)");
                                                System.out.println("1. ID");
                                                System.out.println("2. Nombre");
                                                System.out.println("3. Edad");
                                                System.out.println("0. Salir");

                                                fourthOption = reader.nextInt();
                                                switch (fourthOption) {
                                                    case 0:
                                                        fourthExit = true;
                                                        break;
                                                    case 1:
                                                        DAOEmp.showEmployees(DAOEmp.getEmployeesOrderedByID("ASC"));
                                                        break;
                                                    case 2:
                                                        DAOEmp.showEmployees(DAOEmp.getEmployeesOrderedByName("ASC"));
                                                        break;
                                                    case 3:
                                                        DAOEmp.showEmployees(DAOEmp.getEmployeesOrderedByAge("ASC"));
                                                        break;
                                                }
                                            } while(!fourthExit);
                                            break;
                                        case 2:
                                            fourthExit = false;
                                            do {
                                                System.out.println("MENÚ CUATERNARIO | OPCIONES (DESC)");
                                                System.out.println("1. ID");
                                                System.out.println("2. Nombre");
                                                System.out.println("3. Edad");
                                                System.out.println("0. Salir");

                                                fourthOption = reader.nextInt();
                                                switch (fourthOption) {
                                                    case 0:
                                                        fourthExit = true;
                                                        break;
                                                    case 1:
                                                        DAOEmp.showEmployees(DAOEmp.getEmployeesOrderedByID("DESC"));
                                                        break;
                                                    case 2:
                                                        DAOEmp.showEmployees(DAOEmp.getEmployeesOrderedByName("DESC"));
                                                        break;
                                                    case 3:
                                                        DAOEmp.showEmployees(DAOEmp.getEmployeesOrderedByAge("DESC"));
                                                        break;
                                                }
                                            } while(!fourthExit);
                                            break;
                                    }
                                } while(thirdExit);
                                break;
                            case 2:
                                thirdExit = false;
                                do {
                                    System.out.println("MENÚ TERCIARIO | ORDEN DEPARTAMENTOS");
                                    System.out.println("1. Ascendente (ASC)");
                                    System.out.println("2. Descendente (DESC)");

                                    thirdOption = reader.nextInt();

                                    switch (thirdOption) {
                                        case 1:
                                            fourthExit = false;
                                            do {
                                                System.out.println("MENÚ CUATERNARIO | OPCIONES (ASC)");
                                                System.out.println("1. ID");
                                                System.out.println("2. Nombre");
                                                System.out.println("0. Salir");

                                                fourthOption = reader.nextInt();
                                                switch (fourthOption) {
                                                    case 0:
                                                        fourthExit = true;
                                                        break;
                                                    case 1:
                                                        DAODep.showDepartments(DAODep.getDepartmentsOrderedById("ASC"));
                                                        break;
                                                    case 2:
                                                        DAODep.showDepartments(DAODep.getDepartmentsOrderedByName("ASC"));
                                                        break;
                                                }
                                            } while(!fourthExit);
                                            break;
                                        case 2:
                                            fourthExit = false;
                                            do {
                                                System.out.println("MENÚ CUATERNARIO | OPCIONES (DESC)");
                                                System.out.println("1. ID");
                                                System.out.println("2. Nombre");
                                                System.out.println("0. Salir");

                                                fourthOption = reader.nextInt();
                                                switch (fourthOption) {
                                                    case 0:
                                                        fourthExit = true;
                                                        break;
                                                    case 1:
                                                        DAODep.showDepartments(DAODep.getDepartmentsOrderedById("DESC"));
                                                        break;
                                                    case 2:
                                                        DAODep.showDepartments(DAODep.getDepartmentsOrderedByName("DESC"));
                                                        break;
                                                }
                                            } while(!fourthExit);
                                            break;

                                    }
                                } while(thirdExit);
                                break;
                        }
                    } while (!submenuExit);
                    break;
                case 2:
                    submenuExit = false;
                    do {
                        System.out.println("MENÚ SECUNDARIO | TABLAS");
                        System.out.println("1. Empleados");
                        System.out.println("2. Departamentos");
                        System.out.println("0. Salir");

                        submenuOption = reader.nextInt();
                        switch (submenuOption) {
                            case 0:
                                submenuExit = true;
                                break;
                            case 1:
                                System.out.print("Introduce el nombre: ");
                                reader.nextLine();
                                String newName = reader.nextLine();
                                System.out.print("Introduce la edad: ");
                                int newAge = reader.nextInt();
                                System.out.print("Introduce el ID de departamento: ");
                                int newDptoID = reader.nextInt();

                                DAOEmp.addEmployee(new DTOEmployee(newName, newAge, newDptoID));
                                break;
                            case 2:
                                System.out.print("Introduce el nombre: ");
                                reader.nextLine();
                                String newDptoName = reader.nextLine();

                                DAODep.addDepartment(new DTODepartment(newDptoName));
                                break;
                        }
                    } while (!submenuExit);
                    break;
                case 3:
                    submenuExit = false;
                    do {
                        System.out.println("MENÚ SECUNDARIO | TABLAS");
                        System.out.println("1. Empleados");
                        System.out.println("2. Departamentos");
                        System.out.println("0. Salir");

                        submenuOption = reader.nextInt();
                        switch (submenuOption) {
                            case 0:
                                submenuExit = true;
                                break;
                            case 1:
                                System.out.print("Introduce el ID del empleado: ");
                                int modifyID = reader.nextInt();
                                System.out.print("Introduce el nombre:");
                                reader.nextLine();
                                String modifyName = reader.nextLine();
                                System.out.print("Introduce la edad: ");
                                int modifyAge = reader.nextInt();
                                System.out.print("Introduce el ID de departamento: ");
                                int modifyDptoID = reader.nextInt();

                                DTOEmployee employee = new DTOEmployee(modifyName, modifyAge, modifyDptoID);
                                employee.setId(modifyID);

                                DAOEmp.updateEmployee(employee);
                                break;
                            case 2:
                                System.out.print("Introduce el ID del departamento: ");
                                int modifyDepartID = reader.nextInt();
                                System.out.print("Introduce el nombre: ");
                                reader.nextLine();
                                String modifyDPtoName = reader.nextLine();

                                DAODep.updateDepartment(new DTODepartment(modifyDepartID, modifyDPtoName));
                                break;
                        }
                    } while (!submenuExit);
                    break;
                case 4:
                    submenuExit = false;
                    do {
                        System.out.println("MENÚ SECUNDARIO | TABLAS");
                        System.out.println("1. Empleados");
                        System.out.println("2. Departamentos");
                        System.out.println("3. Todos");
                        System.out.println("0. Salir");

                        submenuOption = reader.nextInt();
                        switch (submenuOption) {
                            case 0:
                                submenuExit = true;
                                break;
                            case 1:
                                thirdExit = false;
                                do {
                                    System.out.println("MENÚ TERCIARIO | FILTROS");
                                    System.out.println("1. ID");
                                    System.out.println("2. Nombre");
                                    System.out.println("0. Salir");

                                    thirdOption = reader.nextInt();

                                    switch(thirdOption) {
                                        case 0:
                                            thirdExit = true;
                                            break;
                                        case 1:
                                            System.out.print("Introduce el ID del empleado: ");
                                            int deleteID = reader.nextInt();

                                            DAOEmp.deleteEmployeeByID(deleteID);
                                            break;
                                        case 2:
                                            System.out.print("Introduce el nombre del empleado: ");
                                            reader.nextLine();
                                            String deleteName = reader.nextLine();

                                            DAOEmp.deleteEmployeeByName(deleteName);
                                            break;
                                    }
                                } while(!thirdExit);
                                break;
                            case 2:

                                    System.out.print("Introduce el ID del departamento: ");
                                    int deleteDptoID = reader.nextInt();

                                    DAODep.deleteDepartmentByID(deleteDptoID);
                                    break;
                            case 3:
                                DAOEmp.deleteAllEmployees();
                                DAODep.deleteAllDepartments();
                                break;
                        }
                    } while (!submenuExit);
                    break;
                case 5:
                    submenuExit = false;
                    do {
                        System.out.println("MENÚ SECUNDARIO | TABLAS");
                        System.out.println("1. Empleados");
                        System.out.println("2. Departamentos");
                        System.out.println("0. Salir");

                        submenuOption = reader.nextInt();
                        switch (submenuOption) {
                            case 0:
                                submenuExit = true;
                                break;
                            case 1:
                                DAOEmp.restoreEmployees();
                                break;
                            case 2:
                                DAODep.restoreDepartments();
                                break;
                        }
                    } while (!submenuExit);
                    break;
            }
        } while (!menuExit);
    }
}
