package by.task.financialinnovation.repository;

import by.task.financialinnovation.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaPersonRepository implements PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Person save(Person person) {
        if (person.isNew()) {
            em.persist(person);
            return person;
        } else {
            return em.merge(person);
        }
    }

    @Override
    public Person get(int id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        return em.createNamedQuery(Person.ALL_SORTED, Person.class).getResultList();
    }
}
