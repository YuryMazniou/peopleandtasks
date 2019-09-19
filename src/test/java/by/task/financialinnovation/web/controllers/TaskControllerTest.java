package by.task.financialinnovation.web.controllers;

import by.task.financialinnovation.model.Task;
import by.task.financialinnovation.repository.TaskRepository;
import by.task.financialinnovation.web.AbstractControllerTest;
import by.task.financialinnovation.web.json.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static by.task.financialinnovation.PersonTaskLogsData.*;
import static by.task.financialinnovation.util.exception.ErrorType.VALIDATION_ERROR;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TaskControllerTest extends AbstractControllerTest {

    @Autowired
    private TaskRepository repository;

    private static final String REST_URL = "/task";

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL+"/"+1))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(TASK2,TASK1));
    }

    @Test
    void create() throws Exception {
        Task expected = new Task(null, TASK_CREATE.getName(),TASK_CREATE.getState());
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL+"/"+1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isNoContent());
    }

    @Test
    void createNotFound() throws Exception {
        Task expected = new Task(null, TASK_CREATE.getName(),TASK_CREATE.getState());
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL+"/"+"10000000")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isConflict());
    }

    @Test
    void createInvalid() throws Exception {
        Task expected = new Task(null, "",TASK_CREATE.getState());
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL+"/"+1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(VALIDATION_ERROR))
                .andDo(print());
    }
}