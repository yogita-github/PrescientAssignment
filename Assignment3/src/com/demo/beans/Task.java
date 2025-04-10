package com.demo.beans;

import java.io.Serializable;

public class Task implements Serializable {
    private static int idCounter = 1;
    private int taskID;
    private String description;
    private String dueDate;
    private boolean status;

    public Task(String description, String dueDate) {
        this.taskID = idCounter++;
        this.description = description;
        this.dueDate = dueDate;
        this.status = false;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return status;
    }

    public void markCompleted() {
        this.status = true;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskID + ", Description: " + description +
                ", Due Date: " + dueDate + ", Status: " + (status ? "Completed" : "Pending");
    }
}
