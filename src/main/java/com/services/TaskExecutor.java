package com.services;

import com.entities.Task;

import java.time.LocalDateTime;

public interface TaskExecutor {

    void runTask(Task taskExecutorFixed, LocalDateTime localDateTime);

}
