package by.task.financialinnovation.repository;

import by.task.financialinnovation.model.LogOfTask;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaLogOfTaskRepository implements LogOfTaskRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<LogOfTask> getAll(int task_id) {
        return em.createNamedQuery(LogOfTask.ALL_SORTED, LogOfTask.class)
                .setParameter("task_id", task_id)
                .getResultList();
    }
}
