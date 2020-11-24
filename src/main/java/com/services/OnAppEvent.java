//package com.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Component
//public class OnAppEvent implements ApplicationListener<ApplicationReadyEvent> {
//
//    @Autowired
//    private IOutTask iTaskExecutor;
//
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
//        iTaskExecutor.runTask(null, LocalDateTime.now());
//    }
//}
