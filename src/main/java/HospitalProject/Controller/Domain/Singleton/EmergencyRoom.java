package HospitalProject.Controller.Domain.Singleton;//package Domain.Singleton;
//
//import Domain.Beneficiaries.Patient;
//import Domain.HospitalServices.Admission;
//import Domain.HospitalServices.Prescription;
//import Domain.HospitalStaff.Doctor;
//import Domain.Strategy.CriticalConditionStrategy;
//import Domain.Strategy.NonCriticalConditionStrategy;
//import Interfaces.PatientHandlingStrategy;
//import PatientState.PatientCondition;
//import Repository.AdmissionRepository;
//import Repository.DoctorRepository;
//import Repository.HospitalRoomRepository;
//import Repository.PrescriptionRepository;
//
//import java.util.*;
//
//public class EmergencyRoom {
//
//    private PatientHandlingStrategy strategy;
//    private static EmergencyRoom instance;
//    private ArrayList<Doctor> doctorsOnCall;
//    private ArrayList<PatientInfo> waitingList;
//
//    private EmergencyRoom() {
//        waitingList = new ArrayList<>();
//        doctorsOnCall = new ArrayList<>();
//    }
//
//    public static EmergencyRoom getInstance() {
//        if (instance == null) {
//            instance = new EmergencyRoom();
//        }
//        return instance;
//    }
//
//    public void resetWaitingList() {
//        this.waitingList.clear();
//    }
//
//    public void setDoctorsOnCall(ArrayList<Doctor> doctorsOnCall) {
//        this.doctorsOnCall = doctorsOnCall;
//    }
//
//    public Doctor findDocByID(int id) {
//        for (Doctor doctor : doctorsOnCall) {
//            if (doctor.getDoctorID() == id)
//                return doctor;
//        }
//        return null;
//    }
//
//    public boolean removeOnCallDoctor(int id, DoctorRepository doctorRepository) {
//        Doctor doctor = findDocByID(id);
//        if (doctor == null)
//            return false;
//        doctorRepository.setDoctorOffCall(id);
//        return doctorsOnCall.remove(doctor);
//    }
//
//    public void addToWaitingList(Patient patient, PatientCondition patientCondition, Date date) {
//        PatientInfo patientInfo = new PatientInfo(patient, patientCondition, date);
//        waitingList.add(patientInfo);
//        Collections.sort(waitingList, Comparator.comparingInt(PatientInfo::getConditionPriority));
//    }
//
//    public PatientInfo findPatientByID(int id) {
//        for (PatientInfo patientInfo : waitingList) {
//            if (patientInfo.getPatient().getPatientID() == id)
//                return patientInfo;
//        }
//        return null;
//    }
//
//    public boolean removeFromWaitingList(int id) {
//        PatientInfo patientInfo = findPatientByID(id);
//        if (patientInfo == null)
//            return false;
//        return waitingList.remove(patientInfo);
//    }
//
//    public ArrayList<Doctor> getDoctorsOnCall() {
//        return doctorsOnCall;
//    }
//
//    public ArrayList<PatientInfo> getWaitingList() {
//        return waitingList;
//    }
//
//    public Doctor assignDoctor() {
//        Random random = new Random();
//
//        int randomIndex = random.nextInt(doctorsOnCall.size());
//
//        return doctorsOnCall.get(randomIndex);
//    }
//
//    public boolean handleNextPatient(AdmissionRepository admissionRepository, PrescriptionRepository prescriptionRepository, HospitalRoomRepository hospitalRoomRepository) {
//        if (waitingList.isEmpty())
//            return false;
//        PatientInfo patientInfo = waitingList.getFirst();
//        Date date = patientInfo.getDate();
//        Patient patient = waitingList.getFirst().getPatient();
//        PatientCondition patientCondition = waitingList.getFirst().getCondition();
//        waitingList.remove(patientInfo);
//        Doctor assignedDoctor = assignDoctor();
//        if (patientCondition == PatientCondition.CRITICAL || patientCondition == PatientCondition.SERIOUS) {
//            Admission admission = new Admission(patient, assignedDoctor, date);
//            admissionRepository.add(admission);
//            boolean result = admissionRepository.setAdmissionRoom(admission.getAdmissionID(),hospitalRoomRepository);
//            if(!result)
//                return false;
//            setStrategy(new CriticalConditionStrategy());
//        } else if (patientCondition == PatientCondition.STABLE) {
//            Prescription prescription = new Prescription(assignedDoctor, patient, date);
//            prescriptionRepository.add(prescription);
//            setStrategy(new NonCriticalConditionStrategy());
//        }
//        strategy.handlePatient(patient, assignedDoctor);
//        return true;
//
//    }
//
//    public void setStrategy(PatientHandlingStrategy strategy) {
//        this.strategy = strategy;
//    }
//
//    public boolean addOnCallDoctor(int id, DoctorRepository doctorRepository) {
//        Doctor doctor = doctorRepository.findByID(id);
//        if (doctor == null)
//            return false;
//        doctor.setOnCall(true);
//        this.setDoctorsOnCall(doctorRepository.getOnCallDoctors());
//        return true;
//    }
//}
