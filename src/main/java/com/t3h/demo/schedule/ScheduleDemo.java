package com.t3h.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleDemo {

//    @Scheduled(initialDelay = 1500, fixedDelay = 5000)
    public void testInitDelay() {
        log.info("Thread: {} - {} > testInitDelay = 1500, fixedDelay = 5000",
                Thread.currentThread().getName(), Thread.currentThread().getId());
    }

//    @Scheduled(fixedRate = 3000)
    public void testRate() {
        log.info("Thread: {} - {} > testRate = 3000",
                Thread.currentThread().getName(), Thread.currentThread().getId());
    }

    @Scheduled(cron = "1 * * * * *")
    public void testCronjob() {
        log.info("Thread: {} - {} > testCronjob every second",
                Thread.currentThread().getName(), Thread.currentThread().getId());
    }
}
