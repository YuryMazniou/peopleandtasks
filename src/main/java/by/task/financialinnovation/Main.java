package by.task.financialinnovation;

import by.task.financialinnovation.repository.PersonRepository;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.getEnvironment().setActiveProfiles("mysql","jpa");
            appCtx.load("spring/spring-db.xml");
            appCtx.refresh();
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            PersonRepository repository=appCtx.getBean(PersonRepository.class);
        }
    }
}
