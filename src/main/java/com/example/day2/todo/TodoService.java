package com.example.day2.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class TodoService {

    private TaskRepository taskRepository;

    @Autowired
    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponse> inquiryAll() {

        // Get data from repository
        List<Task> tasks = (List<Task>) taskRepository.findAll();

        // Map to response
        List<TaskResponse> data  = new ArrayList<>();
        tasks.forEach(task -> {
            data.add(new TaskResponse(task.getId(), task.getName()));
        });

        return data;
    }
}
