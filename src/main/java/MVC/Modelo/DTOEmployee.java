package MVC.Modelo;

public class DTOEmployee {
    private int id;
    private String name;
    private int age;
    private int dptoID;

    public DTOEmployee() {

    }

    public DTOEmployee(String name, int age, int dptoID) {
        this.name = name;
        this.age = age;
        this.dptoID = dptoID;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDptoID() {
        return dptoID;
    }

    public void setDptoID(int dptoID) {
        this.dptoID = dptoID;
    }

    @Override
    public String toString() {
        return "DTOEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dptoID=" + dptoID +
                '}';
    }
}
