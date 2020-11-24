package com.services;

import com.entities.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskExecutorImpl implements TaskExecutor {

    @Override
    public void runTask(Task taskExecutorFixed, LocalDateTime localDateTime) {
        // outsource impl
    }
}
