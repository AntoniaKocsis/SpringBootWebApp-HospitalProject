package HospitalProject.Controller.Domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {

    @GetMapping("/departments_index")
    public String showDepartments(){
        return "departments_index";
    }


    @GetMapping("/doctors_index")
    public String showDoctors(){
        return "doctors_index";
    }

    @GetMapping("/facilities_index")
    public String showFacilities(){
        return "facilities_index";
    }

}

