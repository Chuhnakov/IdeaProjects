package ru.chuhnakov;

public class Solution {

    public int[] beautifulArray(int N) {
        int[] array = new int[N];
        int index = 0;
        for(int i = 1; index < array.length; ++i) {
            if (i % 2 == 0) {
                array[index] = i - 1;
            } else {
                array[index] = i + 1;
                if (index == array.length - 1) {
                    array[index] = i;
                }
            }
            ++index;
        }
        return array;
    }

    public int minPatches(int[] nums, int N) {
        return 1;
    }
}