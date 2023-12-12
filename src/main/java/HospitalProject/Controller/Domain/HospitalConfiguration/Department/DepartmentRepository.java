package HospitalProject.Controller.Domain.HospitalConfiguration.Department;

import HospitalProject.Controller.Domain.Beneficiaries.Patient;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Integer> {
    public Long countById(Integer id);
}
