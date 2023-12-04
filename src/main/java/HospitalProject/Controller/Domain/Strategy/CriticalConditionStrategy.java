package HospitalProject.Controller.Domain.Strategy;

import HospitalProject.Controller.Domain.HospitalStaff.Doctor;
import HospitalProject.Controller.Domain.Beneficiaries.Patient;
import HospitalProject.Controller.Domain.Interfaces.PatientHandlingStrategy;

public class CriticalConditionStrategy implements PatientHandlingStrategy {
    @Override
    public void handlePatient(Patient patient, Doctor doctor) {
        System.out.println("Doctor" +  doctor + " Admitting patient " + patient + " with CRITICAL/SERIOUS condition.");
    }
}
