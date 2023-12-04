package HospitalProject.Controller.Domain.HospitalConfiguration;

import HospitalProject.Controller.Domain.HospitalStaff.Doctor;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 45, nullable = false, name = "department_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Department_Doctor",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors;

    public Department(){
        doctors = new ArrayList<>();
    }
    public Department(String name) {
        this.name = name;
        doctors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enrollDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public ArrayList<Doctor> getDoctors() {
        return(ArrayList<Doctor>) doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public boolean removeDoctor(Doctor doctor) {
        return doctors.remove(doctor);
    }
}
