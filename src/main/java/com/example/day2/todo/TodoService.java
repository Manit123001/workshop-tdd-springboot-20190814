package com.example.day2.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class TodoService {

    List<TaskResponse> inquiryAll() {
        List<TaskResponse> data  = new ArrayList<>();
        data.add(new TaskResponse(1, "Task 1"));
        data.add(new TaskResponse(2, "Task 2"));

        return data;
    }
}
