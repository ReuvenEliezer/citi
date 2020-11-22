package com.services;

import java.time.LocalDateTime;

public interface ITaskExecutor {

    void runTask(Functionality functionality, LocalDateTime localDateTime);
}
