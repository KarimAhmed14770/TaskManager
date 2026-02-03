package com.KarimAhmed.TaskManager.Model;

public class Task {
    private int id;
    private String name;
    private String description;
    private TaskStatus status;


    public Task(String name,String description){
        this.name=name;
        this.description=description;
        status=TaskStatus.PENDING;
    }
    /*setters*/
    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setStatus(TaskStatus status){
        this.status=status;
    }

    /*getters*/
    public int getId(){
        return id;
    }
    public String  getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public TaskStatus getStatus(){
        return status;
    }


    /*toString*/
    @Override
    public String toString(){
        return String.format("ID: %d | Name: %-20s | Status: %s | Description: %s "
                ,id,name,status,description);
    }
}
