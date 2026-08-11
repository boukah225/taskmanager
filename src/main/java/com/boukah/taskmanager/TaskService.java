package com.boukah.taskmanager;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public Task getTask( Integer id){
        return taskRepository.findById(id)
                .orElseThrow(() ->
                            new TaskNotFoundException("Task with id " + id + " not found"));

    }

    public Task updateTask(Integer id, Task newTask){
        Task task = taskRepository.findById(id)
                    .orElseThrow(() ->
                                new TaskNotFoundException("task with " + id + " not found"));

        task.setTitle(newTask.getTitle());
        task.setCompleted(newTask.getCompleted());

        return taskRepository.save(task);
    }

    public String deleteTask( Integer id){
         taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("task with " + id + " not found"));

         taskRepository.deleteById(id);
         return "Task deleted successfully";
    }

}
