package dentiste.demo.control;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import dentiste.demo.model.Budget_fanja;
import dentiste.demo.model.Route;
import dentiste.demo.model.RouteLalana;
import dentiste.demo.model.TypeLalana;

@Controller
@RequestMapping("/lalana")
public class LalanaController {
    
    @GetMapping("/")
    public String actB(Model model) {
        try {
            Route  actbq = new Route();
            LinkedList<Route> bq = actbq.getAllRoute();
            model.addAttribute("acb", bq);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "indexLalana";
    }

    @GetMapping("/traitementRoute")
    public RedirectView traitement(@RequestParam int type, @RequestParam int idRoute) {
        try {
            Route actbq = new Route().selectById(idRoute);
            actbq.traiterLalana(type);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new RedirectView("/lalana/");
    }

    @GetMapping("/detailRoute")
    public String act(Model model, @RequestParam int idRoute) {
        try {
            Route actbq = new Route().selectById(idRoute);
            Budget_fanja bq = actbq.getBudgetFanjaByIdRoute();
            LinkedList<RouteLalana> dph = actbq.getRouteLalanaByIdRoute();
            LinkedList<TypeLalana> type = new TypeLalana().getAllType();
            model.addAttribute("actbq", actbq);
            model.addAttribute("acb", bq);
            model.addAttribute("dph", dph);
            model.addAttribute("type", type);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "detailRoute";
    }
}
