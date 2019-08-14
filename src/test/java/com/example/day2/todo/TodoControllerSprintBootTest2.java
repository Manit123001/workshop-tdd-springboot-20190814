package com.example.day2.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodoControllerSprintBootTest2 {
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void success_with_getAll() {

        // Arrange
        ArrayList<Task> stubs = new ArrayList<>();
        stubs.add(new Task(1,"Task 1"));
        stubs.add(new Task(2,"Task 2"));

        given(taskRepository.findAll()).willReturn(stubs);

        TaskResponseList body = this.restTemplate.getForObject(
                "/todos",
                TaskResponseList.class);

        assertThat(body.getResults().size()).isEqualTo(2);
        assertThat(body.getResults().get(0).getId()).isEqualTo(1);
        assertThat(body.getResults().get(0).getName()).isEqualTo("Task 1");

        taskRepository.deleteAll();
    }
}