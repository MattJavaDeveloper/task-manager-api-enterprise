package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void shouldSaveAndFindTask() {
        Task task = new Task();
        task.setTitle("Repository Test Task");

        Task savedTask = taskRepository.save(task);
        Task foundTask = taskRepository.findById(savedTask.getId()).orElse(null);

        assertThat(foundTask).isNotNull();
        assertThat(foundTask.getTitle()).isEqualTo("Repository Test Task");
    }
}