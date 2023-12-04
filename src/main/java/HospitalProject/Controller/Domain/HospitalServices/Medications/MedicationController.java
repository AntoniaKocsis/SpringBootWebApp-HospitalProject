package HospitalProject.Controller.Domain.HospitalServices.Medications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicationController {
    @Autowired private MedicationService service;

    @GetMapping("/medications")
    public String showUserList(Model model) {
        List<Medication> listMedications = service.listAll();
        model.addAttribute("listMedications", listMedications);

        return "medications";
    }

    @GetMapping("/medications/new")
    public String showNewForm(Model model) {
        model.addAttribute("medication", new Medication());
        model.addAttribute("pageTitle", "Add New Medication");
        return "medication_form";
    }

    @PostMapping("/medications/save")
    public String saveUser(Medication medication, RedirectAttributes ra) {
        service.save(medication);
        ra.addFlashAttribute("message", "The medication has been saved successfully.");
        return "redirect:/medications";
    }

    @GetMapping("/medications/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Medication medication = service.get(id);
            model.addAttribute("medication", medication);
            model.addAttribute("pageTitle", "Edit Medication (ID: " + id + ")");

            return "medication_form";
        } catch (MedicationNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/medications";
        }
    }

    @GetMapping("/medications/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The medication with ID " + id + " has been deleted.");
        } catch (MedicationNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/medications";
    }
}

