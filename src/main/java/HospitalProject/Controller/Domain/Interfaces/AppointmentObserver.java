package HospitalProject.Controller.Domain.Interfaces;

import HospitalProject.Controller.Domain.HospitalServices.Appointments.Appointment;

public interface AppointmentObserver {
    void update(Appointment appointment);
}
