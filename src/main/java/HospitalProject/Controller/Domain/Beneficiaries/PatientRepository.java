package HospitalProject.Controller.Domain.Beneficiaries;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
    public Long countById(Integer id);
}
