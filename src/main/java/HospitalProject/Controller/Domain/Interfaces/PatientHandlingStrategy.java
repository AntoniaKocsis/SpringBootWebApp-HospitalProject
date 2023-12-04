package HospitalProject.Controller.Domain.Interfaces;

import HospitalProject.Controller.Domain.HospitalStaff.Doctor;
import HospitalProject.Controller.Domain.Beneficiaries.Patient;

public interface PatientHandlingStrategy {
    void handlePatient(Patient patient, Doctor doctor);
}
