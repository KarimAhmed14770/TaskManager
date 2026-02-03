package com.KarimAhmed.TaskManager.Service;


/*
* Think of the TaskService as the "Engine Room." It doesn't care about Scanner
* or System.out.print (that belongs in Main). It only cares about manipulating the data.
*
* */



/*importing packages*/

import com.KarimAhmed.TaskManager.Model.Task;
import com.KarimAhmed.TaskManager.Model.TaskStatus;
import com.KarimAhmed.TaskManager.Repository.TaskRepository;

import java.util.List;
import java.util.ArrayList;


public class TaskService {
    private List<Task> tasksList;//List interface which would give me freedom
    //to either implement it as ArrayList or as LinkedList
    private int nextID=1;
    //the Unique ID for each Task
    private TaskRepository repository;
    //the repository object responsible for handling storage data


    public TaskService(TaskRepository repository){
        tasksList=new ArrayList<>();
        this.repository=repository;
        nextID=1;//function for calculating id;
    }

    /*helper Methods*/
    private int calculateID(){

        return 0;
    }

    /*public methods*/
    public void addTask(String name,String description){
        Task x=new Task(name,description);
        x.setId(calculateID());
        tasksList.add(x);
    }


}
