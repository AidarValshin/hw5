package com.github.javarar.lucky.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class LuckyTicketFinderInRange implements Callable<List<Long>> {
    private LuckyTicketPredicate luckyTicketPredicate;

    public LuckyTicketFinderInRange(int numberOfDigits, int maxInt, LuckyTicketPredicate luckyTicketPredicate) {
        this.numberOfDigits = numberOfDigits;
        this.maxInt = maxInt;
        this.luckyTicketPredicate = luckyTicketPredicate;
    }

    private int numberOfDigits;
    private int maxInt;


    @Override
    public List<Long> call() throws Exception {
        List<Long> result = new ArrayList<>();
        long startRange = (long) ((maxInt - 1) * Math.pow(10, (numberOfDigits - 1)));
        long endRange = (long) ((maxInt) * Math.pow(10, (numberOfDigits - 1)));

        for (long i = startRange; i < endRange; i++) {
            if (luckyTicketPredicate.isLucky(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
