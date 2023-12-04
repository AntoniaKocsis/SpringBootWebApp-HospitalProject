package HospitalProject.Controller.Domain.HospitalServices.Medications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {
    @Autowired private MedicationRepository repository;

    public List<Medication> listAll() {
        return (List<Medication>) repository.findAll();
    }

    public void save(Medication medication) {
        repository.save(medication);
    }

    public Medication get(Integer id) throws MedicationNotFoundException {
        Optional<Medication> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new MedicationNotFoundException("Could not find any medication with ID " + id);
    }

    public void delete(Integer id) throws MedicationNotFoundException {
        Long count = repository.countById(id);
        if (count == null || count == 0) {
            throw new MedicationNotFoundException("Could not find any medication with ID " + id);
        }
        repository.deleteById(id);

    }
}
