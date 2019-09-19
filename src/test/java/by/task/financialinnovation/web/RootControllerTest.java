package by.task.financialinnovation.web;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RootControllerTest extends AbstractControllerTest {

    @Test
    void getRoot() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:persons"))
                .andExpect(redirectedUrl("persons"));
    }

    @Test
    void getPersons() throws Exception {
        mockMvc.perform(get("/persons"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("persons"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/persons.jsp"));
    }

    @Test
    void getTasks() throws Exception {
        mockMvc.perform(get("/tasks"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("tasks"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/tasks.jsp"));
    }

    @Test
    void getLogs() throws Exception {
        mockMvc.perform(get("/logs"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("logs"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/logs.jsp"));
    }
}