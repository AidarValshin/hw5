package com.github.javarar.rejected.task;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Log4j2
public final class CustomThreadExecutors {

    public static Executor logRejectedThreadPoolExecutor(int corePoolSize,
                                                         int maximumPoolSize,
                                                         long keepAliveTime,
                                                         TimeUnit unit,
                                                         BlockingQueue<Runnable> workQueue,
                                                         int maxQueueSize) {
        RejectedExecutionHandler logRejectedExecutioHandler = (runnable, executor) -> {
            try {
                if (executor.getQueue().size() > maxQueueSize) {
                    executor.getQueue().put(runnable);
                } else {
                    log.error("Не удалось добавить задание в очередь {}", runnable);
                }
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
        };

        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, logRejectedExecutioHandler);
    }
}
