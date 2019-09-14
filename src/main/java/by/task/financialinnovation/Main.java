package by.task.financialinnovation;

import by.task.financialinnovation.repository.PersonRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/spring-db.xml","spring/spring-mvc.xml")){
            PersonRepository repository=context.getBean(PersonRepository.class);
        }
    }
}
