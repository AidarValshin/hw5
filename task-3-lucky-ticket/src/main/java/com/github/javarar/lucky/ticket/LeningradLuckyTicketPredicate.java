package com.github.javarar.lucky.ticket;

public class LeningradLuckyTicketPredicate implements LuckyTicketPredicate {
    @Override
    public boolean isLucky(long number) {
        char[] charArray = Long.toString(number).toCharArray();
        int numberOfDigits = charArray.length;
        int middle = numberOfDigits / 2; //rounded e.g. 5/2 =2
        long left = 0;
        long right = 0;

        for (int i = 0; i < middle; i++) {
            left+=Character.getNumericValue(charArray[i]);
            right+=Character.getNumericValue(charArray[numberOfDigits-1-i]);
        }
       return left==right;
    }
}
