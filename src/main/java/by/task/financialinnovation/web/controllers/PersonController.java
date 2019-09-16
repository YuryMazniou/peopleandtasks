package by.task.financialinnovation.web.controllers;

import by.task.financialinnovation.model.Person;
import by.task.financialinnovation.repository.PersonRepository;
import by.task.financialinnovation.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public void createOrUpdate(@Valid Person person) {
        checkNotFound(repository.save(person)!=null,"Object did not create/update");
    }
}
