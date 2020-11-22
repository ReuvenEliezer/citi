package com.services;

import java.time.LocalDateTime;

public interface Functionality {

    void exec();

    void addTask(Functionality functionality, LocalDateTime localDateTime);

}
