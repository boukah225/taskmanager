package com.boukah.taskmanager;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskController {


    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }


    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return service.getTasks();
    }

    @PostMapping("/tasks")
    public Task addTask(@Valid @RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id){
        return service.getTask(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable int id,@Valid @RequestBody Task newTask){
        return service.updateTask(id,newTask);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable int id){
        return service.deleteTask(id);
    }
}
