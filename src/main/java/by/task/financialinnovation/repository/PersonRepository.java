package by.task.financialinnovation.repository;

import by.task.financialinnovation.model.Person;

import java.util.List;

public interface PersonRepository {
    // null if not found, when updated
    Person save(Person person);

    // false if not found
    boolean delete(int id);

    // null if not found
    Person get(int id);

    // null if not found
    Person getByEmail(String email);

    List<Person> getAll();
}