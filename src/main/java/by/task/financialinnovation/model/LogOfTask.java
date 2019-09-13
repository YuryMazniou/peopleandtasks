package by.task.financialinnovation.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "log_of_task")
public class LogOfTask extends AbstractBaseEntity {
    private Task task;
    private Long spentOfTime;
    private String comment;

    public LogOfTask() {
    }

    public LogOfTask(Integer id, Task task, Long spentOfTime, String comment) {
        super(id);
        this.task = task;
        this.spentOfTime = spentOfTime;
        this.comment = comment;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Long getSpentOfTime() {
        return spentOfTime;
    }

    public void setSpentOfTime(Long spentOfTime) {
        this.spentOfTime = spentOfTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "LogOfTask{" +
                "spentOfTime=" + spentOfTime +
                ", comment='" + comment + '\'' +
                ", id=" + id +
                '}';
    }
}
