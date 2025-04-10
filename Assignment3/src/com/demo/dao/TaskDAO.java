package com.demo.dao;

import com.demo.beans.Task;
import java.util.List;

public interface TaskDAO {
    void addTask(Task task);
    void removeTask(int taskID);
    void updateTask(int taskID, String newDescription, String newDueDate);
    void markTaskCompleted(int taskID);
    List<Task> getAllTasks();
    void saveTasks();
    void loadTasks();
}
