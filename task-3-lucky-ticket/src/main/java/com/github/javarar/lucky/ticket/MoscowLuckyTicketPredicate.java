package com.github.javarar.lucky.ticket;

public class MoscowLuckyTicketPredicate implements LuckyTicketPredicate {
    @Override
    public boolean isLucky(long number) {
        char[] charArray = Long.toString(number).toCharArray();
        int numberOfDigits = charArray.length;
        long even = 0;
        long odd = 0;

        for (int i = 0; i < numberOfDigits; i++) {
            if (i % 2 == 0) {
                even += Character.getNumericValue(charArray[i]);
            } else {
                odd += Character.getNumericValue(charArray[i]);
            }
        }
        return even == odd;
    }
}
