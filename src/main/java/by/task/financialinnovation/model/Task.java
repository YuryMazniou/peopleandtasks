package by.task.financialinnovation.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task extends AbstractBaseEntity {
    private String name;
    private Person person;
    private boolean state;

    public Task() {
    }

    public Task(Integer id, String name, Person person, boolean state) {
        super(id);
        this.name = name;
        this.person = person;
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
