package com.github.javarar.lucky.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LuckyTicketTest {
    @Test
    @DisplayName("Задание 7. Счастливый Ленинградский билет")
    public void leningradTicketNumberPredicateTest() {
        LuckyTicketFinder luckyTicketFinder = new LuckyTicketFinder();
        List<Long> leningradLuckyTickets = luckyTicketFinder.findLeningradLuckyTicket(6);
        assertEquals(53232, leningradLuckyTickets.size());
    }

    @Test
    @DisplayName("Задание 7. Счастливый Москвоский билет")
    public void moscowTicketNumberPredicateTest() {
        LuckyTicketFinder luckyTicketFinder = new LuckyTicketFinder();
        List<Long> leningradLuckyTickets = luckyTicketFinder.findMoscowLuckyTicket(6);
        assertEquals(54747, leningradLuckyTickets.size());
    }
}