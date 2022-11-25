public class Doctor {
    private static int numDoctor = 0;
    private int id;
    private String name;
    private String speciality;

    public Doctor() {
        numDoctor++;
        id = numDoctor;
    }

    public Doctor(String name, String speciality) {
        this();
        this.name = name;
        this.speciality = speciality;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "ID = " + this.id + ", Nombre = " + this.name + ", Especialidad = " + this.speciality;
    }
}
