import java.util.Scanner;
import java.util.*;
import java.nio.file.*;
import java.io.*;
import java.util.stream.*;
class Task {

    private String title;
    private boolean isDone;

    Task(String title) {
        this.title = title;
        this.isDone = false;

    }

    public String getTitle() {
        return title;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void markDone() {
        isDone = true;
    }

    public String toString() {
        return (isDone ? "[X]" : "[ ]") + title;
    }

    public String toFileString() {

        return isDone + "," + title;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
}

class TaskManager {

    List<Task> tasks =  new ArrayList<>();

    public void addTask(String title) {
        tasks.add(new Task(title));
    }

    public void removeTask(int index) {
        if(index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void isMarkDone(int index) {
        if(index >= 0 && index < tasks.size()) {
            tasks.get(index).markDone();
        }
    }
    public void showAll() {
        for(int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) +" . " + tasks.get(i));
        }
    }

    public List<Task> getTask() {
        return tasks;
    }

    public void setTask(List<Task> tasks) {
        this.tasks = tasks;
    }

}

class FileHandler {

    private static final Path FILE = Path.of("list.txt");

    public void saveFile(List<Task> tasks) {
        List<String> line = new ArrayList<>();
        for(Task task : tasks) {
            line.add(task.toFileString());
        }

        try {
            Files.write(FILE,line);
        }catch(IOException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }

    public List<Task> readFile() {
        List<Task> tasks = new ArrayList<>();

        try{

            List<String> line = Files.readAllLines(FILE);
            for(String parts : line) {
                String [] part = parts.split(",");
                Task task = new Task(part[1]);
                task.setIsDone(Boolean.parseBoolean(part[0]));
                tasks.add(task);

               
            }
        }catch( IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
        
         return tasks;

    }
}

public class Main {

    private static Scanner sc = new Scanner(System.in);
   

    public static void main(String[] args) {
        TaskManager manage = new TaskManager();
        FileHandler fileDemo = new FileHandler();
        manage.setTask(fileDemo.readFile());
        List<Task> newTask = manage.getTask();
        for(int i = 0; i < newTask.size(); i++) {
            System.out.println(i + 1 + "." + newTask.get(i));
        }
        int choose;
        do {

        System.out.println("---------------------");
        System.out.println("----To_Do_List_App---");
        System.out.println("---------------------");
        System.out.println();

        System.out.println("Menu");
        System.out.println("1.Add Task");
        System.out.println("2.Delete Task");
        System.out.println("3.Mark Task");
        System.out.println("4.Save File");
        System.out.println("0.Exit");
        System.out.print("Choose one : ");
        choose = sc.nextInt();

            switch(choose) {
            case 1 -> {
                    sc.nextLine();
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    manage.addTask(title);
                    System.out.println("Task added successfully.");
                }
            case 2 -> {
                    sc.nextLine();
                    System.out.print("Enter task number to delete: ");
                    int index = sc.nextInt()-1;
                    manage.removeTask(index);
                    System.out.println("Task deleted.");
                }
            case 3 -> {
                    newTask.stream().forEach(a -> System.out.println(a));
                    sc.nextLine();
                    System.out.print("Enter task number to mark as done: ");
                    int index = sc.nextInt() - 1;
                    manage.isMarkDone(index);
                    System.out.println("Task marked as done.");
                }
            case 4 -> {
                    fileDemo.saveFile(manage.getTask());
                    System.out.println("Tasks saved.");
            }
            default -> System.out.println("Invalid task number. Please try again.");
            }
        }while(choose != 0);
        

    }
}