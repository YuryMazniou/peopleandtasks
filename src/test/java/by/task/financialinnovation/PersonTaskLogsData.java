package by.task.financialinnovation;

import by.task.financialinnovation.model.LogOfTask;
import by.task.financialinnovation.model.Person;
import by.task.financialinnovation.model.Task;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static by.task.financialinnovation.TestUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonTaskLogsData {
    public static final Person PERSON1=new Person(1,"Иван","Иванов","Иванович","user@yandex.ru","password1");
    public static final Person PERSON2=new Person(2,"Петр","Петров","Петрович","user@gmail.com","password2");
    public static final Person PERSON3=new Person(3,"Сидр","Сидоров","Сидорович","user@tut.by","password3");
    public static final Person PERSON_CREATE = new Person(4, "create","create","create","create@create","create");


    public static final Task TASK1=new Task(1,"Доказать теорему Пифагора",true);
    public static final Task TASK2=new Task(2,"Взломать Google",true);
    public static final Task TASK3=new Task(3,"Взломать Facebook",true);
    public static final Task TASK4=new Task(4,"Доказать теорию относительности",true);
    public static final Task TASK5=new Task(5,"Взломать BankOfAmerica",true);
    public static final Task TASK6=new Task(6,"Доказать закон Ньютона",false);
    public static final Task TASK_CREATE=new Task(7,"Create task",false);

    public static final LogOfTask LOG_OF_TASK1=new LogOfTask(1,30L,"Это было легко");
    public static final LogOfTask LOG_OF_TASK2=new LogOfTask(2,50L,"Я боялся ,но сделал");
    public static final LogOfTask LOG_OF_TASK3=new LogOfTask(3,30L,"Я это сделал");
    public static final LogOfTask LOG_OF_TASK4=new LogOfTask(4,70L,"Я не боялся и сделал");
    public static final LogOfTask LOG_OF_TASK5=new LogOfTask(5,101L,"Меня хотели схватить,но я убежал");
    public static final LogOfTask LOG_OF_TASK6=new LogOfTask(6,100L,"У меня не получилось");
    public static final LogOfTask LOG_OF_TASK7=new LogOfTask(7,50L,"Я потратил еще немного времени,но у меня все равно не получилось ее решить");

    public static <T> void assertMatch(Iterable<T> actual, Iterable<T> expected) {
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

    public static <T> void assertMatch(T actual, T expected) {
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    public static ResultMatcher contentJson(Person... expected) {
        return result -> assertMatch(readListFromJsonMvcResult(result, Person.class), List.of(expected));
    }

    public static ResultMatcher contentJson(Person expected) {
        return result -> assertMatch(readFromJsonMvcResult(result, Person.class), expected);
    }

    public static ResultMatcher contentJson(Task... expected) {
        return result -> assertMatch(readListFromJsonMvcResult(result, Task.class), List.of(expected));
    }

    public static ResultMatcher contentJson(Task expected) {
        return result -> assertMatch(readFromJsonMvcResult(result, Task.class), expected);
    }

    public static ResultMatcher contentJson(LogOfTask... expected) {
        return result -> assertMatch(readListFromJsonMvcResult(result, LogOfTask.class), List.of(expected));
    }

    public static ResultMatcher contentJson(LogOfTask expected) {
        return result -> assertMatch(readFromJsonMvcResult(result, LogOfTask.class), expected);
    }
}
