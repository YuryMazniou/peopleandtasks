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
    public String getPersons() {
        return "persons";
    }

    @GetMapping("/tasks")
    public String getTasks() {
        return "tasks";
    }

    @GetMapping("/logs")
    public String getLogs() {
        return "logs";
    }
}
