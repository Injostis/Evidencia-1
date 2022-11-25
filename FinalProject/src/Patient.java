public class Patient {
    private static int numPatient = 0;
    private int id;
    private String name;

    public Patient() {
        numPatient++;
        id = numPatient;
    }

    public Patient(String name) {
        this();
        this.name = name;
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

    @Override
    public String toString() {
        return "ID = " + this.id + ", Nombre = " + this.name;
    }
}
