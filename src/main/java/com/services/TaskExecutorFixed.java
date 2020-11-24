package com.services;

import com.entities.Task;

import java.time.LocalDateTime;

public interface TaskExecutorFixed {

    void exec();

    void addTask(Task taskExecutorFixed, LocalDateTime localDateTime);

}
