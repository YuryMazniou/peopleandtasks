package by.task.financialinnovation.web.controllers;

import by.task.financialinnovation.model.LogOfTask;
import by.task.financialinnovation.repository.LogOfTaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping
public class LogOfTaskController {

    private final Logger log = LoggerFactory.getLogger(LogOfTaskController.class);

    private final LogOfTaskRepository repository;

    @Autowired
    public LogOfTaskController(LogOfTaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/rest/tasks/{task_id}/logs",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogOfTask> getAll(@PathVariable int task_id){
        log.info("getAll logs of task");
        return repository.getAll(task_id);
    }
}
