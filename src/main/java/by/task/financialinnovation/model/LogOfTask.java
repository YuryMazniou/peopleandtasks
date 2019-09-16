package by.task.financialinnovation.model;

import by.task.financialinnovation.View;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = LogOfTask.ALL_SORTED, query = "SELECT l FROM LogOfTask l WHERE l.task.id=:task_id ORDER BY l.spentOfTime"),
})
@Entity
@Table(name = "log_of_task")
public class LogOfTask extends AbstractBaseEntity {
    public static final String ALL_SORTED = "LogOfTask.getAll";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    @NotNull(groups = View.Persist.class)
    private Task task;

    @Column(name = "spent_of_time",nullable = false)
    @NotNull
    @SafeHtml(groups = {View.Web.class})
    private Long spentOfTime;

    @Column(name = "comment",nullable = false)
    @NotBlank
    @SafeHtml(groups = {View.Web.class})
    private String comment;

    public LogOfTask() {
    }

    public LogOfTask(Long spentOfTime, String comment) {
        this.spentOfTime = spentOfTime;
        this.comment = comment;
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
