package com;

import com.app.CitiApp;
import com.services.Functionality;
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
    private Functionality functionality;

    @Test
    public void citiTest() {
        LocalDateTime now = LocalDateTime.now();
        functionality.addTask(null, now.plusHours(2));
        functionality.addTask(null, now.plusHours(1));
        functionality.addTask(null, now.plusHours(3));

    }
}
