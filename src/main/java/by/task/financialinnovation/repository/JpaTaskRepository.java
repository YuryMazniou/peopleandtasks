package by.task.financialinnovation.repository;

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

    public JpaTaskRepository() {
        super();
    }

    @Override
    public List<Task> getAll(int person_id) {
        return null;
    }

    @Override
    public Task save(Task task) {
        return null;
    }
}
