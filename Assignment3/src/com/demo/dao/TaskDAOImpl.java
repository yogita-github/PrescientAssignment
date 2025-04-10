package com.demo.dao;

import com.demo.beans.Task;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TaskDAOImpl implements TaskDAO {
    private List<Task> tasks;
    private static final String FILE_NAME = "tasks.txt";

    public TaskDAOImpl() {
        this.tasks = new LinkedList<>();
        loadTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task Added: " + task);
    }
    
    public void removeTask(int taskID) {
        ListIterator<Task> iterator = tasks.listIterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTaskID() == taskID) {
                iterator.remove();
                System.out.println("Task Removed: " + task);
                return;
            }
        }
        System.out.println("Task Not Found.");
    }

    public void updateTask(int taskID, String newDescription, String newDueDate) {
        for (Task task : tasks) {
            if (task.getTaskID() == taskID) {
                task.setDescription(newDescription);
                task.setDueDate(newDueDate);
                System.out.println("Task Updated: " + task);
                return;
            }
        }
        System.out.println("Task Not Found.");
    }

    public void markTaskCompleted(int taskID) {
        for (Task task : tasks) {
            if (task.getTaskID() == taskID) {
                task.markCompleted();
                System.out.println("Task Marked as Completed: " + task);
                return;
            }
        }
        System.out.println("Task Not Found.");
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void saveTasks() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(tasks);
            System.out.println("Tasks Saved!");
        } catch (IOException e) {
            System.out.println("Error Saving Tasks: " + e.getMessage());
        }
    }

    public void loadTasks() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (List<Task>) in.readObject();
            System.out.println("Tasks Loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("No existing task file found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error Loading Tasks: " + e.getMessage());
        }
    }
}
