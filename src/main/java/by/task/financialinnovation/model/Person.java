package by.task.financialinnovation.model;

import by.task.financialinnovation.View;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.SafeHtml;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(name = Person.DELETE, query = "DELETE FROM Person p WHERE p.id=:id"),
        @NamedQuery(name = Person.BY_EMAIL, query = "SELECT DISTINCT p FROM Person p WHERE p.email=?1"),
        @NamedQuery(name = Person.ALL_SORTED, query = "SELECT p FROM Person p ORDER BY p.firstName, p.email"),
})
@Entity
@Table(name = "persons", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "persons_unique_email_idx")})
public class Person extends AbstractBaseEntity{

    public static final String DELETE = "User.delete";
    public static final String BY_EMAIL = "User.getByEmail";
    public static final String ALL_SORTED = "User.getAllSorted";

    @Column(name = "firstName", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    @SafeHtml(groups = {View.Web.class})
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    @SafeHtml(groups = {View.Web.class})
    private String lastName;

    @Column(name = "patronymic", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    @SafeHtml(groups = {View.Web.class})
    private String patronymic;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    @SafeHtml(groups = {View.Web.class})
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public Person() {
    }

    public Person(Integer id, String firstName, String lastName, String patronymic, String email, String password) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
