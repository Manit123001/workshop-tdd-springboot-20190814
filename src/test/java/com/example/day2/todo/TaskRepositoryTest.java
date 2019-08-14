package com.example.day2.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void get_all_should_have_3_rows(){
        taskRepository.save(new Task("Task 1"));
        taskRepository.save(new Task("Task 2"));
        taskRepository.save(new Task("Task 3"));

        List<Task> tasks = (List<Task>) taskRepository.findAll();

        assertEquals(3, tasks.size());
        assertEquals("Task 1", tasks.get(0).getName());
    }

    @Test
    public void get_all_should_have_2_rows(){
        taskRepository.save(new Task("Task 1"));
        taskRepository.save(new Task("Task 2"));

        List<Task> tasks = (List<Task>) taskRepository.findAll();

        assertEquals(2, tasks.size());
        assertEquals("Task 1", tasks.get(0).getName());
    }
}