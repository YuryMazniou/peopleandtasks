package by.task.financialinnovation.model;

import by.task.financialinnovation.View;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(name = Task.ALL_SORTED, query = "SELECT t FROM Task t WHERE t.person.id=:person_id ORDER BY t.name"),
})
@Entity
@Table(name = "tasks")
public class Task extends AbstractBaseEntity {
    public static final String ALL_SORTED = "Task.getAll";

    @Column(name = "name",nullable = false)
    @NotBlank
    @SafeHtml(groups = {View.Web.class})
    @Size(min = 2, max = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    @NotNull(groups = View.Persist.class)
    private Person person;

    @Column(name = "state",nullable = false)
    @NotNull
    private Boolean state;

    public Task() {
    }

    public Task(Integer id, String name, boolean state) {
        super(id);
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", state=" + state +
                ", id=" + id +
                '}';
    }
}
