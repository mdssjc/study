package com.github.mdssjc.mja.cap15;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.github.mdssjc.mja.cap15.Tasks.work1;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        work1();
        scheduledExecutorService.schedule(Tasks::work2, 10, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
