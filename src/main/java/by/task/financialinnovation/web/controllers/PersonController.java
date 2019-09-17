package by.task.financialinnovation.web.controllers;

import by.task.financialinnovation.View;
import by.task.financialinnovation.model.Person;
import by.task.financialinnovation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static by.task.financialinnovation.util.ValidationUtil.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getAll(){
        return repository.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person get(@PathVariable int id) {
        return checkNotFoundWithId(repository.get(id),id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createOrUpdate(@Validated(View.Web.class) @RequestBody Person person) {
        checkNotFound(repository.save(person)!=null,"Object did not create/update");
    }
}
