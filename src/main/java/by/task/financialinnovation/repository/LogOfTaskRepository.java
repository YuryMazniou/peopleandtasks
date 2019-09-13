package by.task.financialinnovation.repository;

import by.task.financialinnovation.model.LogOfTask;

import java.util.List;

public interface LogOfTaskRepository {
    List<LogOfTask> getAll (int task_id);
}
