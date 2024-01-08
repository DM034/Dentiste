package dentiste.demo.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dentiste.demo.model.Alea;


@Controller
@RequestMapping("/alea")
public class AleaController {
    
    @GetMapping("/")
    public String actB() {
        return "indexAlea";
    }

    
    // @GetMapping("/detailAlea")
    // public String actB(Model model,@RequestParam String nify,@RequestParam String note ) {
    //     try {
    //         Route  actbq = new Route();
    //         LinkedList<Route> bq = actbq.getAllRoute();
    //         model.addAttribute("acb", bq);
    //     } catch (Exception e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    //     return "indexAlea";
    // }

    @GetMapping("/processInput")
    @ResponseBody
    public String processInput(@RequestParam String nify,@RequestParam String note ) {
        String[] resultNify;
        String[] resultNote;

        if (nify.contains("-")) {

            String[] parts = nify.split("-");
            int start = Integer.parseInt(parts[0].substring(1));
            int end = Integer.parseInt(parts[1].substring(1));
            resultNify = generateRange(start, end);
        } else if (nify.contains(";")) {

            resultNify = nify.split(";");
        } else {

            resultNify = new String[]{nify};
        }

        if (note.contains("-")) {

            String[] parts = note.split("-");
            int start = Integer.parseInt(parts[0].substring(1));
            int end = Integer.parseInt(parts[1].substring(1));
            resultNote = generateRange(start, end);
        } else if (note.contains(";")) {

            resultNote = note.split(";");
        } else {

            resultNote = new String[]{note};
        }

        try {
            for (int i = 0; i < 32; i++) {
                Alea alea = new Alea(resultNify[i], resultNote[resultNote.length-1]);
                alea.insert();
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }


        return "Résultat : " + String.join(", ", resultNify)+ " == " + String.join(", ", resultNote);
    }

    private String[] generateRange(int start, int end) {
        String[] result = new String[end - start + 1];
        for (int i = start; i <= end; i++) {
            result[i - start] = "D" + i;
        }
        return result;
    }

}
