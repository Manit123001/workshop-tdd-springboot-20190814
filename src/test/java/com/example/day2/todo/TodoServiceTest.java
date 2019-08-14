package com.example.day2.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void success_inquiryAll() {
        // Arrange
        ArrayList<Task> stubs = new ArrayList<>();
        stubs.add(new Task(1,"Task 1"));
        stubs.add(new Task(2,"Task 2"));

        given(taskRepository.findAll()).willReturn(stubs);

        // Act
        TodoService todoService = new TodoService(taskRepository);
        List<TaskResponse> data = todoService.inquiryAll();

        // Assert
        assertThat(data.size()).isEqualTo(2);
        assertThat(data.get(0).getId()).isEqualTo(1);
        assertThat(data.get(0).getName()).isEqualTo("Task 1");

    }
}