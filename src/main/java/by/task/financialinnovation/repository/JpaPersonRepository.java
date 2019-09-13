package by.task.financialinnovation.repository;

import by.task.financialinnovation.model.Person;
import org.hibernate.jpa.QueryHints;
import org.springframework.dao.support.DataAccessUtils;
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
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Person.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Person getByEmail(String email) {
        List<Person> users = em.createNamedQuery(Person.BY_EMAIL, Person.class)
                .setParameter(1, email)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .getResultList();
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public List<Person> getAll() {
        return em.createNamedQuery(Person.ALL_SORTED, Person.class).getResultList();
    }
}
