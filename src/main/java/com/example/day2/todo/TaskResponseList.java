package com.example.day2.todo;

import java.util.List;

public class TaskResponseList {

    private int code;
    private String description;
    private List<TaskResponse> results;

    public List<TaskResponse> getResults() {
        return results;
    }

    public void setResults(List<TaskResponse> results) {
        this.results = results;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}