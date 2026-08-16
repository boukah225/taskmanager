package com.boukah.taskmanager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void shouldReturnTaskWhenIdExist(){

        Task task = new Task(1,"Apprendre Spring Boot",false);

        when(taskRepository.findById(1)).thenReturn(Optional.of(task));

        Task result = taskService.getTask(1);

        assertEquals(1,result.getId());
        assertEquals("Apprendre Spring Boot", result.getTitle());
    }

    @Test
    public void shouldThrowExceptionWhenTaskDoesNotExist(){

        when(taskRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class, () -> {taskService.getTask(99);});
    }

    @Test
    public void shouldAddTask(){

        Task task = new Task(2,"Apprendre la patience",false);

        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.addTask(task);

        assertEquals(task, result);
    }

    @Test
    void shouldUpdateTask(){

        Task oldOne = new Task(1,"Apprendre Spring Boot",false);

        Task newOne = new Task(3,"Apprendre Spring Boot",true);

        when(taskRepository.findById(1)).thenReturn(Optional.of(oldOne));

        when(taskRepository.save(any(Task.class))).thenReturn(newOne);

        Task task = taskService.updateTask(1, newOne);

        assertTrue(task.getCompleted());
    }

    @Test
    void shouldDeleteTaskWhenIdExist(){

        Task task = new Task(1, "Appprendre Spring Boot", false);

        when(taskRepository.findById(1)).thenReturn(Optional.of(task));

        taskService.deleteTask(1);

        verify(taskRepository).deleteById(1);


    }
}


