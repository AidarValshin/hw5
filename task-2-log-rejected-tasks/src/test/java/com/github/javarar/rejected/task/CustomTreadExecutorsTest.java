package com.github.javarar.rejected.task;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomTreadExecutorsTest {

    @Test
    public void threadPoolDoesNotThrowExceptionOnQueueOverflow() {
        int maxSize = 2;
        final int corePoolSize = 2;
        final int maximumPoolSize = 2;
        final long keepAliveTime = 100L;
        final TimeUnit unit = TimeUnit.MILLISECONDS;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) CustomThreadExecutors.logRejectedThreadPoolExecutor(
                corePoolSize, maximumPoolSize, keepAliveTime, unit, new ArrayBlockingQueue<>(maxSize), maximumPoolSize);

        try {
            for (int i = 0; i <= 30; i++) {
                int finalI = i;
                executor.execute(() -> {
                    System.out.println(finalI);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } finally {
            executor.shutdown();
        }
        assertNotEquals(31, executor.getCompletedTaskCount());
    }
}
