import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Patient> myPatients = new ArrayList<>();
    public static ArrayList<Doctor> myDoctors = new ArrayList<>();
    public static ArrayList<Appointment> myAppointments = new ArrayList<>();
    public static ArrayList<User> myUsers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de consultorio.");
        initiate();
        do{
            selectOption();
        }while(tryAgain());
    }

    //Permite registrar un nuevo usuario.
    public static void registerUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba su nombre de usuario.");
        String userName = sc.nextLine();
        System.out.println("Escriba su contraseña.");
        String password = sc.nextLine();
        myUsers.add(new User(userName, password));
        initiate();
    }

    //Permite registrar un nuevo paciente con nombre.
    public static void registerPatient(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre del paciente.");
        String name = sc.nextLine();
        myPatients.add(new Patient(name));
    }

    //Permite registrar un nuevo doctor con nombre y especialidad.
    public static void registerDoctor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre del doctor.");
        String name = sc.nextLine();
        System.out.println("Escriba la especialidad del doctor.");
        String speciality = sc.nextLine();
        myDoctors.add(new Doctor(name, speciality));
    }

    //Permite agendar una nueva cita con motivo, doctor, paciente, fecha y hora.
    public static void generateAppointment(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el motivo de la cita.");
        String motive = sc.nextLine();
        Doctor myDoc = searchDoctor();
        Patient myPat = searchPatient();
        System.out.println("Ingrese la fecha de la cita.");
        String date = sc.nextLine();
        System.out.println("Ingrese la hora de la cita.");
        String time = sc.nextLine();
        myAppointments.add(new Appointment(motive, myDoc, myPat, date, time));
    }

    //Permite buscar un doctor por su ID.
    public static Doctor searchDoctor(){
        Scanner sc = new Scanner(System.in);
        int answer;
        System.out.println("Escoja el doctor por su ID.");
        seeDoctors();
        answer = sc.nextInt();
        return myDoctors.get(answer-1);
    }

    //Permite buscar un paciente por su ID.
    public static Patient searchPatient(){
        Scanner sc = new Scanner(System.in);
        int answer;
        System.out.println("Escoja el paciente por su ID.");
        seePatients();
        answer = sc.nextInt();
        return myPatients.get(answer-1);
    }

    //Permite ver una lista de los doctores.
    public static void seeDoctors(){
        for(int i = 0; i < myDoctors.size(); i++){
            System.out.println(myDoctors.get(i).toString());
        }
    }

    //Permite ver una lista de los pacientes.
    public static void seePatients(){
        for(int i = 0; i < myPatients.size(); i++){
            System.out.println(myPatients.get(i).toString());
        }
    }

    //Permite ver una lista de las citas.
    public static void seeAppointments(){
        for(int i = 0; i < myAppointments.size(); i++){
            System.out.println(myAppointments.get(i).toString());
        }
    }

    //Permite confirmar que el usuario que se ingresó existe.
    public static boolean validateUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario.");
        String userName = sc.nextLine();
        System.out.println("Ingrese su contraseña.");
        String password = sc.nextLine();
        if(!myUsers.stream().anyMatch(a -> a.getUserName().equals(userName) && a.getPassword().equals(password))){
            System.out.println("Usuario no encontrado, vuelva a intentarlo.");
            initiate();
        }
        return myUsers.stream().anyMatch(a -> a.getUserName().equals(userName) && a.getPassword().equals(password));
    }

    //Permite registrarte o iniciar sesión.
    public static void initiate(){
        boolean repeat = true;
        while(repeat){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Seleccione una opción:");
                System.out.println("1 Iniciar sesión\n" +
                        "2 Registrarte\n" +
                        "0 Salir");
                int answer = sc.nextInt();
                switch(answer){
                    case 0:
                        System.out.println("Hasta luego!");
                        System.exit(0);
                        break;
                    case 1:
                        validateUser();
                        repeat = false;
                        break;
                    case 2:
                        registerUser();
                        repeat = false;
                        break;
                    default:
                        System.out.println("Opción invalida, vuelva a intentarlo.");
                }
            }catch(Exception e){
                System.out.println("Opción inválida, vuelva a intentarlo.");
            }
        }
    }

    //Permite escoger que desea hacer el usuario.
    public static void selectOption() {
        boolean repeat = true;
        while (repeat) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Seleccione una opción:");
                System.out.print("1 Registrar nuevo doctor\n" +
                        "2 Registrar nuevo paciente\n" +
                        "3 Crear una cita\n" +
                        "4 Mostrar doctores\n" +
                        "5 Mostrar pacientes\n" +
                        "6 Mostrar citas\n" +
                        "0 Salir\n");
                int answer = sc.nextInt();
                switch (answer) {
                    case 0:
                        System.out.println("Hasta luego!");
                        System.exit(0);
                        break;
                    case 1:
                        registerDoctor();
                        repeat = false;
                        break;
                    case 2:
                        registerPatient();
                        repeat = false;
                        break;
                    case 3:
                        generateAppointment();
                        repeat = false;
                        break;
                    case 4:
                        seeDoctors();
                        repeat = false;
                        break;
                    case 5:
                        seePatients();
                        repeat = false;
                        break;
                    case 6:
                        seeAppointments();
                        repeat = false;
                        break;
                    default:
                        System.out.println("Opción inválida, vuelva a intentarlo.");
                }
            } catch (Exception e) {
                System.out.println("Opción inválida, vuelva a intentarlo.");
            }
        }
    }

    //Permite elegir al usuario si continuar o salirse.
    public static boolean tryAgain(){
        boolean tryAgain = false;
        boolean repeat = true;
        try{
            while(repeat){
                Scanner sc = new Scanner(System.in);
                System.out.println("\nQuieres escoger otra opción? (Ss/Nn)");
                char answer = sc.next().charAt(0);
                switch(answer){
                    case 'S':
                    case 's':
                        tryAgain = true;
                        repeat = false;
                        break;
                    case 'N':
                    case 'n':
                        System.out.println("Hasta luego!");
                        repeat = false;
                        break;
                    default:
                        System.out.println("Opción inválida, vuelva a intentarlo.");
                }
            }
        }catch (Exception e){
            System.out.println("Opción inválida, vuelva a intentarlo.");
        }
        return tryAgain;
    }
}