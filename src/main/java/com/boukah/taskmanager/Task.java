package com.boukah.taskmanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
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
