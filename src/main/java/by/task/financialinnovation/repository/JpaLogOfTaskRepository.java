package by.task.financialinnovation.repository;

import by.task.financialinnovation.model.LogOfTask;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JpaLogOfTaskRepository implements LogOfTaskRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<LogOfTask> getAll(int task_id) {
        return null;
    }
}
