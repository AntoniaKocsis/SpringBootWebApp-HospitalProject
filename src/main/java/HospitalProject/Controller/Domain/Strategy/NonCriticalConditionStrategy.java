package HospitalProject.Controller.Domain.Strategy;

import HospitalProject.Controller.Domain.HospitalStaff.Doctor;
import HospitalProject.Controller.Domain.Beneficiaries.Patient;
import HospitalProject.Controller.Domain.Interfaces.PatientHandlingStrategy;

public class NonCriticalConditionStrategy implements PatientHandlingStrategy {
    @Override
    public void handlePatient(Patient patient, Doctor doctor) {
        System.out.println("Doctor: "+doctor+" Writing prescription for patient: " + patient+ " with NON-CRITICAL condition.");
    }
}
