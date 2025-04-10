package com.demo.service;

import com.demo.beans.Task;
import java.util.List;

public interface TaskService {
    void addTask(String description, String dueDate);
    void removeTask(int taskID);
    void updateTask(int taskID, String newDescription, String newDueDate);
    void markTaskCompleted(int taskID);
    void displayTasks();
    void saveTasks();
}
