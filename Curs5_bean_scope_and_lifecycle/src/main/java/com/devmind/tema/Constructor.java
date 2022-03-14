package com.devmind.tema;

import java.util.Arrays;

public class Constructor {

    static String str;

    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(maxSubseq(arr));

    }
    static int maxSubseq(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        Arrays.sort(arr);
        int counter = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i + 1] - arr[i] <= 1) {
                counter++;
            } else {
                counter = 1;
            }
            if (counter > max ) {
                max = counter;
            }
        }
        return max;
    }

}
