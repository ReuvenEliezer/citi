package com;

import com.app.CitiApp;
import com.services.TaskExecutor;
import com.services.TaskExecutorFixed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CitiApp.class)
public class CitiTest {

    @Autowired
    private TaskExecutorFixed taskExecutorFixed;

    @Autowired
    private TaskExecutor taskExecutor;

    @Test
    public void citiTest() {
        LocalDateTime now = LocalDateTime.now();
        taskExecutorFixed.addTask(null, now.plusHours(2));
        taskExecutorFixed.addTask(null, now.plusHours(1));
        taskExecutorFixed.addTask(null, now.plusHours(3));
        taskExecutor.runTask(null, now.plusHours(3));

    }
}
