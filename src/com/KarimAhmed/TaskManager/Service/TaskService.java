package com.KarimAhmed.TaskManager.Service;




/*importing packages*/

import com.KarimAhmed.TaskManager.Model.Task;
import com.KarimAhmed.TaskManager.Model.TaskStatus;
import com.KarimAhmed.TaskManager.Repository.TaskRepository;

import java.util.List;


public class TaskService {
    private List<Task> tasksList;//List interface which would give me freedom
    //to either implement it as ArrayList or as LinkedList
    private int nextId;
    //the Unique ID for each Task
    private TaskRepository repository;
    //the repository object responsible for handling storage data


    /*dependency injection */
    public TaskService(TaskRepository repository) {
        this.repository = repository;
        tasksList = repository.loadTasks();
        nextId = calculateId(tasksList);//function for calculating id;
    }

    /*helper Methods*/

    /*calculate the id of the next task, ensuring each task having a unique ID*/
    private int calculateId(List<Task> tasksList) {
        int next;
        if (tasksList.isEmpty()) {
            next = 1;
        } else {
            next = tasksList.getFirst().getId();
            for (Task x : tasksList) {
                if (x.getId() >= next) {
                    next = x.getId();
                }
            }
            next++;
        }
        return next;
    }

    /*returns the index of the task if found, if not it returns -1*/
    private int searchByID(int id) {
        int result = -1;
        for (int i = 0; i < tasksList.size(); i++) {
            if (id == tasksList.get(i).getId()) {
                result = i;
                break;
            }
        }
        return result;
    }

    /*public methods*/
    public void addTask(String name, String description) {
        Task x = new Task(name, description);
        x.setId(nextId);
        nextId++;
        tasksList.add(x);
        repository.saveTasks(tasksList);
    }

    public void displayTasks() {
        for (Task x : tasksList) {
            System.out.println(x);
        }
    }

    public void updateTaskStatus(int id, TaskStatus status) {
        if (id > 0 && id < nextId) {
            int index = searchByID(id);
            if (index != -1) {
                tasksList.get(index).setStatus(status);
                repository.saveTasks(tasksList);
            } else {
                //index with that id is not found
                System.out.println("Task wit ID: "+id+" is not found");
            }
        }
        else{
            System.out.println("Invalid ID");
        }
    }

    public void deleteTask(int id) {
        if (id > 0 && id < nextId) {
            int index = searchByID(id);
            if (index != -1) {
                tasksList.remove(index);
                repository.saveTasks(tasksList);
            } else {
                //index with thatid is not found
                System.out.println("Task wit ID: "+id+" is not found");
            }
        }
        else{
            System.out.println("Invalid ID");
        }

    }

    public boolean taskExists(int id){
        return searchByID(id)!=-1;
    }
}
