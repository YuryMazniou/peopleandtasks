package by.task.financialinnovation.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "redirect:persons";
    }

    @GetMapping("/persons")
    public String getMeals() {
        return "persons";
    }
}
