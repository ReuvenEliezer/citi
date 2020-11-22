package com.entities;

import com.services.Functionality;

import java.time.LocalDateTime;
import java.util.Objects;

public class TaskTime {

    private Functionality functionality;
    private LocalDateTime taskExecutionTime;

    public TaskTime(Functionality functionality, LocalDateTime taskExecutionTime) {
        this.functionality = functionality;
        this.taskExecutionTime = taskExecutionTime;
    }

    public Functionality getFunctionality() {
        return functionality;
    }

    public LocalDateTime getTaskExecutionTime() {
        return taskExecutionTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskTime taskTime = (TaskTime) o;
        return Objects.equals(functionality, taskTime.functionality) &&
                Objects.equals(taskExecutionTime, taskTime.taskExecutionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionality, taskExecutionTime);
    }

    @Override
    public String toString() {
        return "TaskTime{" +
                "functionality=" + functionality +
                ", taskExecutionTime=" + taskExecutionTime +
                '}';
    }
}
