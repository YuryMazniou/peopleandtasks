package by.task.financialinnovation.web.controllers;
import by.task.financialinnovation.model.Person;
import by.task.financialinnovation.repository.PersonRepository;
import by.task.financialinnovation.web.AbstractControllerTest;
import by.task.financialinnovation.web.json.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static by.task.financialinnovation.PersonTaskLogsData.*;
import static by.task.financialinnovation.PersonTaskLogsData.contentJson;
import static by.task.financialinnovation.util.exception.ErrorType.VALIDATION_ERROR;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PersonControllerTest extends AbstractControllerTest {

    @Autowired
    private PersonRepository repository;

    private static final String REST_URL = "/persons";

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(PERSON1,PERSON2,PERSON3));
    }

    @Test
    void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL +"/" +1))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(PERSON1));
    }

    @Test
    void getNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL +"/" +"1000000000"))
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }


    @Test
    void create() throws Exception {
        Person expected = new Person(null, PERSON_CREATE.getFirstName(),PERSON_CREATE.getLastName()
                ,PERSON_CREATE.getPatronymic(),PERSON_CREATE.getEmail(),PERSON_CREATE.getPassword());
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isNoContent());

        assertMatch(repository.getAll(),PERSON1,PERSON2,PERSON3,PERSON_CREATE);
    }

    @Test
    void createInvalid() throws Exception {
        Person expected = new Person(null, "c","create","create","creatertert","create");
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(VALIDATION_ERROR))
                .andDo(print());
    }
    @Test
    @Transactional(propagation = Propagation.NEVER)
    void createDuplicate() throws Exception {
        Person invalid = new Person(null, "create","create","create","user@gmail.com","create");
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid)))
                .andDo(print())
                .andExpect(content().string("{\"url\":\"http://localhost/persons\",\"type\":\"VALIDATION_ERROR\",\"typeMessage\":\"Validation error\",\"details\":[\"User with this email already exists\"]}"))
                .andExpect(status().isConflict())
                .andExpect(errorType(VALIDATION_ERROR));
    }


    @Test
    void update() throws Exception {
        Person expected = new Person(PERSON1.getId(), "update","update","update","update@update","update");
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isNoContent());

        assertMatch(repository.get(PERSON1.getId()),expected);
    }

    @Test
    void updateInvalid() throws Exception {
        Person expected = new Person(PERSON1.getId(), "update","update","update","update","update");
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(VALIDATION_ERROR))
                .andDo(print());
    }
}