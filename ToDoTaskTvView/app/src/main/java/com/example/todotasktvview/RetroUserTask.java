package com.example.todotasktvview;

import com.google.gson.annotations.SerializedName;

public class RetroUserTask {
    @SerializedName("userName")
    private  String userName;

    @SerializedName("task")
    private  String task;

    public RetroUserTask() {
    }

    public RetroUserTask(String userName, String task, String taskDate, String description) {
        this.userName = userName;
        this.task = task;
        this.taskDate = taskDate;
        this.description = description;
    }

    @SerializedName("taskDate")
    private  String taskDate;

    @SerializedName("description")
    private  String description;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
