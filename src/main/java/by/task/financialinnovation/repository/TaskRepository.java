package by.task.financialinnovation.repository;

import by.task.financialinnovation.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> getAll(int person_id);

    Task save(Task task,int person_id);
}
