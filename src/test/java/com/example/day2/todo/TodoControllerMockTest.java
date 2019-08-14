package com.example.day2.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class TodoControllerMockTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodoService todoService;

    @Test
    public  void success_with_getAll() throws Exception {
        // Arrange
        List<TaskResponse> data  = new ArrayList<>();
        data.add(new TaskResponse(1, "Task 1"));
        data.add(new TaskResponse(2, "Task 2"));

        given(todoService.inquiryAll()).willReturn(data);

        // Act
        MvcResult response = mvc.perform(get("/todos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Convert json string to object
        String json
                = response.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        TaskResponseList body
                = objectMapper.readValue(json, TaskResponseList.class);

        // Assert
        assertThat(body.getResults().size()).isEqualTo(2);
        assertThat(body.getResults().get(0).getId()).isEqualTo(1);
        assertThat(body.getResults().get(0).getName()).isEqualTo("Task 1");

    }

}
