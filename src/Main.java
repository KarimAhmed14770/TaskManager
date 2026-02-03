
import com.KarimAhmed.TaskManager.Model.TaskStatus;
import com.KarimAhmed.TaskManager.Repository.TaskRepository;
import com.KarimAhmed.TaskManager.Service.TaskService;

import java.util.Scanner;

public class Main {
    public static void main(String[] Args){
        TaskRepository storage=new TaskRepository();
        TaskService ts=new TaskService(storage);
        Scanner sc=new Scanner(System.in);
        boolean running=true;
        while(running){
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. Display All Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice=sc.nextInt();
            sc.nextLine();//clear buffer
            switch (choice){
                case 1->{
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    ts.addTask(name, desc);
                }
                case 2->{
                    ts.displayTasks();
                }
                case 3->{
                    System.out.print("Enter Task Id: ");
                    int id=sc.nextInt();
                    sc.nextLine();//clear buffer
                    System.out.print("Enter task Status: 1(Pending), 2(In Progress), 3(Completed)");
                    int status=sc.nextInt();
                    sc.nextLine();
                    TaskStatus userStatus=switch (status){
                        case 1->TaskStatus.PENDING;
                        case 2->TaskStatus.IN_PROGRESS;
                        case 3->TaskStatus.COMPLETED;
                        default -> throw new IllegalArgumentException("Invalid status number");
                    };
                    ts.updateTaskStatus(id,userStatus);
                }
                case 4->{
                    System.out.print("Enter Task Id: ");
                    int id=sc.nextInt();
                    sc.nextLine();//clear buffer
                    ts.deleteTask(id);
                }
                case 5->{
                    running=false;
                }
                default -> System.out.println("Invalid input, please Try Again");
            }
        }
    }
}
