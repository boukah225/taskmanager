package com.boukah.taskmanager;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskController {


    private TaskService service = new TaskService();


    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return service.getTasks();
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id){
        return service.getTask(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task newTask){
        return service.updateTask(id,newTask);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable int id){
        return service.deleteTask(id);
    }
}
