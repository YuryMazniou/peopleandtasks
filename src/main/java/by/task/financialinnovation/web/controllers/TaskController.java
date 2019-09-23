package by.task.financialinnovation.web.controllers;

import by.task.financialinnovation.View;
import by.task.financialinnovation.model.Task;
import by.task.financialinnovation.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.task.financialinnovation.util.ValidationUtil.*;

@RestController
@RequestMapping
public class TaskController {

    private final Logger log = LoggerFactory.getLogger(TaskController.class);

    private final TaskRepository repository;

    @Autowired
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/rest/persons/{person_id}/tasks",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getAll(@PathVariable int person_id){
        log.info("getAll tasks");
        return repository.getAll(person_id);
    }

    @PostMapping("/rest/persons/{person_id}/tasks")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void create(@Validated(View.Web.class) @RequestBody Task task,@PathVariable int person_id) {
        log.info("Start create task");
        checkNotFound(repository.save(task,person_id)!=null,"Object did not create/update");
        log.info("Create a task successly");
    }
}
