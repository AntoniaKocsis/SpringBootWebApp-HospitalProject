package HospitalProject.Controller.Domain.Beneficiaries;

public class PatientNotFoundException extends Throwable {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
