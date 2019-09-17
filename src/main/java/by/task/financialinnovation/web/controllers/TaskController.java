package by.task.financialinnovation.web.controllers;

import by.task.financialinnovation.View;
import by.task.financialinnovation.model.Task;
import by.task.financialinnovation.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository repository;

    @Autowired
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{person_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getAll(@PathVariable int person_id){
        return repository.getAll(person_id);
    }

    @PostMapping("/{person_id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void create(@Validated(View.Web.class) @RequestBody Task task,@PathVariable int person_id) {
        repository.save(task,person_id);
    }
}
