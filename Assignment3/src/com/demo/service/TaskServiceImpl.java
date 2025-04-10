package com.demo.service;

import com.demo.beans.Task;
import com.demo.dao.TaskDAO;
import com.demo.dao.TaskDAOImpl;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskDAO taskDAO;

    public TaskServiceImpl() {
        this.taskDAO = new TaskDAOImpl();
    }

    @Override
    public void addTask(String description, String dueDate) {
        Task newTask = new Task(description, dueDate);
        taskDAO.addTask(newTask);
    }

    @Override
    public void removeTask(int taskID) {
        taskDAO.removeTask(taskID);
    }

    @Override
    public void updateTask(int taskID, String newDescription, String newDueDate) {
        taskDAO.updateTask(taskID, newDescription, newDueDate);
    }

    @Override
    public void markTaskCompleted(int taskID) {
        taskDAO.markTaskCompleted(taskID);
    }

    @Override
    public void displayTasks() {
        List<Task> tasks = taskDAO.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\nTo-Do List:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    @Override
    public void saveTasks() {
        taskDAO.saveTasks();
    }
}
