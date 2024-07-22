package com.github.javarar.lucky.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LuckyTicketFinder {

    public List<Long> findLeningradLuckyTicket(int numberOfFigits) {
        if (numberOfFigits < 4 || numberOfFigits > 12) {
            throw new IllegalArgumentException("numberOfFigits must be between 4 and 12");
        }
        List<Long> result = new ArrayList<>();
        List<LuckyTicketFinderInRange> tasks = new ArrayList<>(10);
        for (int i = 2; i < 12; i++) {
            tasks.add(new LuckyTicketFinderInRange(numberOfFigits, i, new LeningradLuckyTicketPredicate()));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            List<Future<List<Long>>> futures = executorService.invokeAll(tasks);
            while (!futures.stream().allMatch(fut -> {
                if (fut.isDone() || fut.isCancelled()) {
                    return true;
                }
                return false;
            })){
                Thread.sleep(500);
            }
            for(Future<List<Long>> future : futures){
                result.addAll(future.get());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdownNow();
        }
        return result;
    }
    public List<Long> findMoscowLuckyTicket(int numberOfFigits) {
        if (numberOfFigits < 4 || numberOfFigits > 12) {
            throw new IllegalArgumentException("numberOfFigits must be between 4 and 12");
        }
        List<Long> result = new ArrayList<>();
        List<LuckyTicketFinderInRange> tasks = new ArrayList<>(10);
        for (int i = 2; i < 12; i++) {
            tasks.add(new LuckyTicketFinderInRange(numberOfFigits, i, new MoscowLuckyTicketPredicate()));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            List<Future<List<Long>>> futures = executorService.invokeAll(tasks);
            while (!futures.stream().allMatch(fut -> {
                if (fut.isDone() || fut.isCancelled()) {
                    return true;
                }
                return false;
            })){
                Thread.sleep(500);
            }
            for(Future<List<Long>> future : futures){
                result.addAll(future.get());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdownNow();
        }
        return result;
    }

}
