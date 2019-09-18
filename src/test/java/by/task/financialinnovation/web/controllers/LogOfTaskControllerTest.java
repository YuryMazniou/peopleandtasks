package by.task.financialinnovation.web.controllers;
import by.task.financialinnovation.web.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static by.task.financialinnovation.PersonTaskLogsData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LogOfTaskControllerTest extends AbstractControllerTest {

    private static final String REST_URL = "/logs";

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL+"/"+6))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(LOG_OF_TASK7,LOG_OF_TASK6));
    }
}