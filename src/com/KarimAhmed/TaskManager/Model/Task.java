package com.KarimAhmed.TaskManager.Model;

/*
* layered architecture:
* to write a professional code you must organize it in a professional way
* usually we have 3 layers:
* 1)Model layer(Package): which contain the object class or data itself, your object structure
* it doesn't contain functionality as logically an object can't function it is just an object
* 2)Service layer(Package):which contains the brain, the rules the math that will be done
* on the objects, adding,creating deleting ... etc this is like the manager of the objects
* 3)Repository layer(the database or files): this is the storage area, it doesn't care about
* why to add why to read, it just add to storage, read from storage... etc
*
*
* note:By separating your code this way, you've made your project modular.
* If you decide to stop saving to a text file and start saving to a SQL Database next week,
* you only have to change the Repository package; your Service and Model won't even notice the
* difference.if you want to change in a functionality of a service, u will only change the file
* in the service package and u will not touch the object class.....etc
*
* */

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
