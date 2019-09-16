package by.task.financialinnovation.web.controllers;

import by.task.financialinnovation.model.LogOfTask;
import by.task.financialinnovation.repository.LogOfTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogOfTaskController {


    private final LogOfTaskRepository repository;

    @Autowired
    public LogOfTaskController(LogOfTaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{task_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogOfTask> getAll(@PathVariable int task_id){
        return repository.getAll(task_id);
    }
}
