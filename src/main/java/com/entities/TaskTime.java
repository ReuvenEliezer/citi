package com.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class TaskTime {

    private Task task;
    private LocalDateTime taskExecutionTime;

    public TaskTime(Task task, LocalDateTime taskExecutionTime) {
        this.task = task;
        this.taskExecutionTime = taskExecutionTime;
    }

    public Task getFunctionality() {
        return task;
    }

    public LocalDateTime getTaskExecutionTime() {
        return taskExecutionTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskTime taskTime = (TaskTime) o;
        return Objects.equals(task, taskTime.task) &&
                Objects.equals(taskExecutionTime, taskTime.taskExecutionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, taskExecutionTime);
    }

    @Override
    public String toString() {
        return "TaskTime{" +
                "task=" + task +
                ", taskExecutionTime=" + taskExecutionTime +
                '}';
    }

}
