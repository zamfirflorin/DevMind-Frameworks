package com.devmind.adnotari;

import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] A, int K) {
        if (K > A.length) {
            return -1;
        }

        int[] sortedDescArr = IntStream.of(A)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
        int[] evens = IntStream.of(A).boxed()
                .filter(Solution::isEven)
                .mapToInt(i -> i)
                .toArray();
        int[] odds = IntStream.of(A).boxed()
                .filter(n -> !isEven(n))
                .mapToInt(i -> i)
                .toArray();
        int maxSum = 0;

        int evenIndex = 0;
        int oddIndex = 0;


        while (K > 0) {
            if (K % 2 == 1) {
                if ((evens.length) > 0) {
                    maxSum += evens[evenIndex];
                    evenIndex += 1;
                    K -= 1;
                } else {
                    return -1;
                }
            } else {
                if (evenIndex < (evens.length - 1) && oddIndex < (odds.length - 1)) {
                    maxSum += Math.max(evens[evenIndex] + evens[evenIndex + 1], odds[oddIndex] + odds[oddIndex + 1]);
                    evenIndex += 2;
                    oddIndex += 2;
                } else if (evenIndex < (evens.length - 1)) {
                    maxSum += evens[evenIndex] + evens[evenIndex + 1];
                    evenIndex += 2;
                } else if (oddIndex < odds.length - 1) {
                    maxSum += odds[oddIndex] + odds[oddIndex + 1];
                    oddIndex += 2;
                }
                K -= 2;
            }
        }
        return maxSum;
    }


    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}