package com.boukah.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private int nextId = 3;
    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskService(){
        tasks.add(new Task(1,"Apprendre Sprint Boot",false));
        tasks.add(new Task(2,"prier",true));
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public Task addTask(Task task){
        task.setId(nextId);
        nextId++;
        tasks.add(task);
        return task;
    }

    public Task getTask( int id){
        for (int ind = 0; ind<tasks.size();ind++){
            if (tasks.get(ind).getId() == id) {
                return tasks.get(ind);
            }
        }
        throw new TaskNotFoundException("Task with id " + id + " not found");

    }

    public Task updateTask(int id, Task newTask){
        for (int i = 0; i<tasks.size(); i++){
            Task task = tasks.get(i);
            if (task.getId() == id){
                task.setTitle(newTask.getTitle());
                task.setCompleted(newTask.getCompleted());
                return task;
            }
        }
        throw new TaskNotFoundException("task with " + id + " not found");
    }

    public String deleteTask( int id){
        for (int i = 0; i<tasks.size(); i++){
            if (tasks.get(i).getId() == id){
                tasks.remove(tasks.get(i));
                return "Remove successufly";
            }
        }
        throw new TaskNotFoundException("task with " + id + " not found");
    }

}
