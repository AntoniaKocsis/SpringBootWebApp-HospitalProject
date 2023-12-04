package HospitalProject.Controller.Domain.HospitalConfiguration.HospitalRoom;

import HospitalProject.Controller.Domain.HospitalServices.Admissions.Admission;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Admission")
public class AdmissionRoom extends HospitalRoom {
    @OneToMany(mappedBy = "admissionRoom", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Admission> admissions;
    @Column(length = 45, nullable = false, name = "available")
    private boolean available;

    public AdmissionRoom() {admissions = new ArrayList<>();}

    public AdmissionRoom(int roomNumber) {
        super(roomNumber);
        this.available = true;
        admissions = new ArrayList<>();
    }

    public boolean isAvailable() {
        return available;
    }

    public List<Admission> getAdmissions() {
        return admissions;
    }

    public void setAdmissions(List<Admission> admissions) {
        this.admissions = admissions;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }
}
