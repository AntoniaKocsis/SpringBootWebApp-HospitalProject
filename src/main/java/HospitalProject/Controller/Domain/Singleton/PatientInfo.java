package HospitalProject.Controller.Domain.Singleton;

import HospitalProject.Controller.Domain.Beneficiaries.Patient;
import HospitalProject.Controller.Domain.PatientState.PatientCondition;

import java.util.Date;

public class PatientInfo{
    private Patient patient;
    private PatientCondition patientCondition;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;
    public PatientInfo(Patient patient, PatientCondition condition,Date date) {
        this.patient = patient;
        this.patientCondition = condition;
        this.date = date;
    }


    public Patient getPatient() {
        return patient;
    }

    public PatientCondition getCondition() {
        return patientCondition;
    }
    public int getConditionPriority() {
        switch (patientCondition) {
            case CRITICAL:
                return 0;
            case SERIOUS:
                return 1;
            case STABLE:
                return 2;
            default:
                return Integer.MAX_VALUE; // Handle other conditions if needed
        }
    }

    @Override
    public String toString() {
        return "PatientInfo{" +
                "patient=" + patient +
                ", patientCondition=" + patientCondition +
                ", date=" + date +
                '}';
    }
}