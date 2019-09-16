package by.task.financialinnovation.repository;

import by.task.financialinnovation.model.Person;

import java.util.List;

public interface PersonRepository {

    Person save(Person person);

    Person get(int id);

    List<Person> getAll();
}