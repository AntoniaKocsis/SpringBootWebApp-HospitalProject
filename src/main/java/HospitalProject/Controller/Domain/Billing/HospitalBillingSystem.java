package HospitalProject.Controller.Domain.Billing;

import HospitalProject.Controller.Domain.Beneficiaries.Patient;
import HospitalProject.Controller.Domain.HospitalServices.Appointments.Appointment;
import HospitalProject.Controller.Domain.HospitalServices.LabTestResult.LabTestResult;
import HospitalProject.Controller.Domain.Singleton.EmergencyRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HospitalBillingSystem {
    private static HospitalBillingSystem instance;

    private HospitalBillingSystem() {
    }

    public static HospitalBillingSystem getInstance() {
        if (instance == null) {
            instance = new HospitalBillingSystem();
        }
        return instance;
    }
    public double patientAppointmentBill(){
        Billing billingWithConsultation = new ConsultationFeeDecorator(new BasicBilling());
        return billingWithConsultation.calculateCost();
    }
    public double patientTestsBill(){
        Billing billingWithTest = new TestFeeDecorator(new BasicBilling());
        return billingWithTest.calculateCost();
    }
}
