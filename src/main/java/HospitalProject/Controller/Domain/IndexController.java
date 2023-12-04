package HospitalProject.Controller.Domain;

import HospitalProject.Controller.Domain.Beneficiaries.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/doctors_index")
    public String showDoctors() {
        return "doctors_index";
    }
    @GetMapping("/departments_index")
    public String showDepartments() {

        return "departments_index";
    }
    @GetMapping("/facilities_index")
    public String showFacilities() {
        return "facilities_index";
    }
}
