package by.task.financialinnovation.model;

import javax.persistence.*;

@Entity
@Table(name = "log_of_task")
public class LogOfTask extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "spent_of_time",nullable = false)
    private Long spentOfTime;

    @Column(name = "comment",nullable = false)
    private String comment;

    public LogOfTask() {
    }

    public LogOfTask(Integer id, Long spentOfTime, String comment) {
        super(id);
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
