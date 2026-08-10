package com.boukah.taskmanager;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    private Integer id;
    private String title;
    private boolean completed;

    public Task(Integer id,String title,boolean completed){
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Task(){

    }


    public Integer getId() {
        return this.id ;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getCompleted() {
        return this.completed ;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setCompleted(boolean comp) {
        this.completed = comp;
    }

}
