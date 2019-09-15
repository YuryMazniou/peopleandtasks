package by.task.financialinnovation.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task extends AbstractBaseEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "state",nullable = false)
    private boolean state;

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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
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
