package HospitalProject.Controller.Domain.HospitalStaff;

public class DoctorNotFoundException extends Throwable {
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
