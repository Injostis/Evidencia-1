public class Appointment {
    private static int numAppointment = 0;
    private int id;
    private String motive;
    private Doctor doc;
    private Patient pat;
    private String date;
    private String time;

    public Appointment() {
        numAppointment++;
        id = numAppointment;
    }

    public Appointment(String motive, Doctor doc, Patient pat, String date, String time) {
        this();
        this.motive = motive;
        this.doc = doc;
        this.pat = pat;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public Doctor getDoc() {
        return doc;
    }

    public void setDoc(Doctor doc) {
        this.doc = doc;
    }

    public Patient getPat() {
        return pat;
    }

    public void setPat(Patient pat) {
        this.pat = pat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ID = " + this.id +
                "\n Motivo = " + this.motive +
                "\n Doctor = " + this.doc +
                "\n Paciente = " + this.pat +
                "\n Fecha = " + this.date +
                "\n Hora = " + this.time;
    }
}
