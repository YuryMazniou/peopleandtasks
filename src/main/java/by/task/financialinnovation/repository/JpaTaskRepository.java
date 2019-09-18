package by.task.financialinnovation.repository;

import by.task.financialinnovation.model.Person;
import by.task.financialinnovation.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaTaskRepository implements TaskRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Task> getAll(int person_id) {
        return em.createNamedQuery(Task.ALL_SORTED, Task.class)
                .setParameter("person_id", person_id)
                .getResultList();
    }

    @Override
    @Transactional
    public Task save(Task task,int person_id) {
        if(task.isNew()){
            task.setPerson(em.getReference(Person.class, person_id));
            em.persist(task);
            return task;}
        else return null;
    }
}
