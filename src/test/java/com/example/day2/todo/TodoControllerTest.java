package com.example.day2.todo;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodoControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void success_with_getAll() {

        TaskResponseList body = this.restTemplate.getForObject(
                "/todos",
                TaskResponseList.class);

        assertThat(body.getResults().size()).isEqualTo(2);
        assertThat(body.getResults().get(0).getId()).isEqualTo(1);
        assertThat(body.getResults().get(0).getName()).isEqualTo("Task 1");

    }
}