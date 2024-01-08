package dentiste.demo.control;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import dentiste.demo.model.Budget_patient;
import dentiste.demo.model.Dent_patient;
import dentiste.demo.model.Patient;
import dentiste.demo.model.Type;

@Controller
@RequestMapping("/dentiste")
public class DentisteController {
    
    @GetMapping("/")
    public String actB(Model model) {
        try {
            Patient  actbq = new Patient();
            LinkedList<Patient> bq = actbq.getAllPatient();
            model.addAttribute("acb", bq);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/traitementPatient")
    public RedirectView traitement(@RequestParam int type, @RequestParam int idPatient) {
        try {
            Patient actbq = new Patient().selectById(idPatient);
            actbq.traiterDent(type);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new RedirectView("/dentiste/");
    }

    @GetMapping("/detailPatient")
    public String act(Model model, @RequestParam int idPatient) {
        try {
            Patient actbq = new Patient().selectById(idPatient);
            Budget_patient bq = actbq.getBudgetPatientByIdPatient();
            LinkedList<Dent_patient> dph = actbq.getDentPatientHByIdPatient();
            LinkedList<Dent_patient> dpb = actbq.getDentPatientBByIdPatient();
            LinkedList<Type> type = new Type().getAllType();
            model.addAttribute("actbq", actbq);
            model.addAttribute("acb", bq);
            model.addAttribute("dph", dph);
            model.addAttribute("dpb", dpb);
            model.addAttribute("type", type);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "detailPatient";
    }
}
