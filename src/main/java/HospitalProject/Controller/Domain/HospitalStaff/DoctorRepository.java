package HospitalProject.Controller.Domain.HospitalStaff;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
    public Long countById(Integer id);
}