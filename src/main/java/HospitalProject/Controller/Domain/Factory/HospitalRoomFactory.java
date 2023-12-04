package HospitalProject.Controller.Domain.Factory;

import HospitalProject.Controller.Domain.HospitalConfiguration.HospitalRoom.ExaminationRoom;
import HospitalProject.Controller.Domain.HospitalConfiguration.HospitalRoom.AdmissionRoom;
import HospitalProject.Controller.Domain.HospitalConfiguration.HospitalRoom.HospitalRoom;

public class HospitalRoomFactory {
    public HospitalRoom createExaminationRoom(int roomNumber) {
        return new ExaminationRoom(roomNumber);
    }

    public HospitalRoom createAdmissionRoom(int roomNumber) {
        return  new AdmissionRoom(roomNumber);
    }
}
