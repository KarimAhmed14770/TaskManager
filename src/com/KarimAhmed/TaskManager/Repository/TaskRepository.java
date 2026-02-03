package com.KarimAhmed.TaskManager.Repository;


import com.KarimAhmed.TaskManager.Model.Task;
import com.KarimAhmed.TaskManager.Model.TaskStatus;

import java.util.List;
import java.util.ArrayList;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;


public class TaskRepository {
    private final String FilePath="tasks.txt";

    /*this functions writes all the tasks in the list to a txt file*/
    public void saveTasks(List<Task> tasksList){
        try(PrintWriter pw=new PrintWriter(new FileWriter(FilePath))){
            for(Task x:tasksList){
                pw.println(x.getId()+"|"+x.getName()+"|"+x.getStatus()+"|"+x.getDescription());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /*this functions loads all data from the file, stores them in a list, returns the list*/
    public List<Task> loadTasks(){
        List<Task> x=new ArrayList<>();
        Task a=null;
        String line=null;
        String[] values=new String[4];
       // System.out.println("Saving to: " + new File(FilePath).getAbsolutePath()); debugging purpose
        try(BufferedReader br=new BufferedReader(new FileReader(FilePath))){
            while((line=br.readLine())!=null){
                values=line.split("\\|");
                a=new Task(values[1],values[3]);
                a.setId(Integer.parseInt(values[0]));
                a.setStatus(TaskStatus.valueOf(values[2]));
                x.add(a);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return x;
    }

}
