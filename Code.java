import java.util.*;
public class Hospital_Management_System {
    private static ArrayList<Patient> patients=new ArrayList<>();
    private static ArrayList<Doctor> doctors=new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    public static class Patient{
        private static int i=0;
        private String Name;
        private int age;
        private String gender;
        private int ID;
        public Patient(String Name,String gender,int age){
            this.ID=++i;
            this.Name=Name;
            this.gender=gender;
            this.age=age;
        }
        public int getId(){
            return ID;
        }
        public String toString(){
            return "Patient ID: "+ID+", Patient Name: "+Name+" , Age: "+age+", gender: "+gender;
        }
    }
    public static class Doctor{
        private static int j=0;
        private String name;
        private int id;
        private String speciality;
        public Doctor(String name,String speciality){
            this.id=++j;
            this.name =name;
            this.speciality=speciality;
        }
        public int getId(){
            return id;
        }
        public String toString(){
            return "Doctor ID: "+id+", Doctor Name: "+name+", speciality: "+speciality;
        }
    }
    public static class Appointment{
        private Patient patient;
        private Doctor doctor;
        private String date;
        public Appointment(Patient patient,Doctor doctor,String date){
            this.patient=patient;
            this.doctor=doctor;
            this.date=date;
        }
        public String toString(){
            return "[Patient: "+patient+", Doctor: "+doctor+", Date: "+date+"]";
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int choice;
        do{
        System.out.println("Hospital Management System");
        System.out.println("1. Add patients");
        System.out.println("2. Add doctor");
        System.out.println("3. Schedule appointment");
        System.out.println("4. view patients");
        System.out.println("5. view doctor");
        System.out.println("6. view appointments");
        System.out.println("0.Exit");
        choice=sc.nextInt();
        sc.nextLine();
            switch(choice){
                case 1:
                AddPatient(sc);
                break;
                case 2:
                AddDoctor(sc);
                break;
                case 3: 
                scheduleAppointment(sc);
                break;
                case 4:
                viewPatients();
                break;
                case 5:
                viewDoctors();
                break;
                case 6:
                viewAppointments();
                break;
                case 0:
                System.out.println("Exiting........");
                break;
                default:
                System.out.println("Invalid choice. please try again");
                break;
            }
        }
        while(choice!=0);

    }
    private static void AddPatient(Scanner sc){
        System.out.println("Enter patient name: ");
        String name=sc.nextLine();
        System.out.println("Enter the gender: ");
        String gender=sc.nextLine();
        System.out.println("Enter the age: ");
        int age=sc.nextInt();
        Patient patient=new Patient(name,gender,age);
        patients.add(patient);
        System.out.println("Patient added successfully.");
    }
    private static void AddDoctor(Scanner sc){
        System.out.println("Enter doctor name: ");
        String name=sc.nextLine();
        System.out.println("Enter the speciality: ");
        String speciality=sc.nextLine();
        Doctor doctor=new Doctor(name,speciality);
        doctors.add(doctor);
        System.out.println("Doctor added successfully");
    }
    private static void scheduleAppointment(Scanner sc) {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Please add at least one patient and doctor first.");
            return;
        }

        System.out.println("Available Patients:");
        for (Patient p : patients)
            System.out.println(p.getId() + ". " + p);

        System.out.print("Enter patient ID: ");
        int pid = sc.nextInt();
        sc.nextLine();

        Patient patient = null;
        for (Patient p : patients) {
            if (p.getId() == pid) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            System.out.println("Invalid patient ID.");
            return;
        }

        System.out.println("Available Doctors:");
        for (Doctor d : doctors)
            System.out.println(d.getId() + ". " + d);

        System.out.print("Enter doctor ID: ");
        int did = sc.nextInt();
        sc.nextLine();

        Doctor doctor = null;
        for (Doctor d : doctors) {
            if (d.getId() == did) {
                doctor = d;
                break;
            }
        }

        if (doctor == null) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        System.out.print("Enter appointment date (e.g., 2025-07-11): ");
        String date = sc.nextLine();

        Appointment appointment = new Appointment(patient, doctor, date);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully.");
    }


    // ===== View Patients =====
    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        System.out.println("=== Patient List ===");
        for (Patient p : patients)
            System.out.println(p);
    }

    // ===== View Doctors =====
    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        System.out.println("=== Doctor List ===");
        for (Doctor d : doctors)
            System.out.println(d);
    }

    // ===== View Appointments =====
    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        System.out.println("=== Appointments ===");
        for (Appointment a : appointments)
            System.out.println(a);
    }
}
