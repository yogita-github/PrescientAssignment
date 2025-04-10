package com.demo.test;

import com.demo.service.TaskService;
import com.demo.service.TaskServiceImpl;
import java.util.Scanner;

public class ToDoListTest {
    public static void main(String[] args) {
        TaskService taskService = new TaskServiceImpl();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n To-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Update Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Display Tasks");
            System.out.println("6. Save & Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Description: ");
                    sc.nextLine();
                    String description = sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String dueDate = sc.next();
                    taskService.addTask(description, dueDate);
                    break;
                case 2:
                    System.out.print("Enter Task ID to Remove: ");
                    taskService.removeTask(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter Task ID to Update: ");
                    int taskID = sc.nextInt();
                    System.out.print("Enter New Description: ");
                    sc.nextLine();
                    String newDesc = sc.nextLine();
                    System.out.print("Enter New Due Date: ");
                    String newDueDate = sc.next();
                    taskService.updateTask(taskID, newDesc, newDueDate);
                    break;
                case 4:
                    System.out.print("Enter Task ID to Mark as Completed: ");
                    taskService.markTaskCompleted(sc.nextInt());
                    break;
                case 5:
                    taskService.displayTasks();
                    break;
                case 6:
                    taskService.saveTasks();
                    System.out.println("Exit!");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 6);
    }
}
