package com.services;

import com.entities.TaskTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

@Component
public class FunctionalityImpl implements Functionality {

    private PriorityBlockingQueue<TaskTime> queue = new PriorityBlockingQueue(2, Comparator.comparing(TaskTime::getTaskExecutionTime));

//    @Autowired
//    private TaskExecutor taskExecutor;

    @Override
    public void addTask(Functionality functionality, LocalDateTime localDateTime) {
        queue.add(new TaskTime(functionality, localDateTime));
        printQueue();
        exec();
    }

    private void printQueue() {
        queue.stream().forEach(taskTime -> System.out.println("current queue: " + taskTime.toString()));
    }

    @Override
    public void exec() {
        TaskTime taskTime = queue.peek();
        if (taskTime.getTaskExecutionTime().isBefore(LocalDateTime.now()))
            queue.remove(taskTime);
        else if (taskTime != null) {
            System.out.println(String.format("runTask %s", taskTime.toString()));
            TaskExecutor taskExecutor = new TaskExecutor();
            taskExecutor.runTask(taskTime.getFunctionality(), taskTime.getTaskExecutionTime());
        }
    }

}
