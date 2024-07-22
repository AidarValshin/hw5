package com.github.javarar.lucky.ticket;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LuckyTicketFinder luckyTicketFinder = new LuckyTicketFinder();
        List<Long> luckyTickets = luckyTicketFinder.findLeningradLuckyTicket(8);
        luckyTickets.forEach(System.out::println);
    }
}
