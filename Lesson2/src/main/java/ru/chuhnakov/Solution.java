package ru.chuhnakov;

public class Solution {

    public Solution() {
    }

    public int maxArea(int[] height) {
        int area = -1;
        int i = 0;                  //Начало массива
        int j = height.length - 1;  //Конец массива
        int temp = 0;
        while (i != j) {
            if (height[i] < height[j]) {
                temp = height[i] * (j - i);
                if (temp > area)
                    area = temp;
                i++;
            } else {
                temp = height[j] * (j - i);
                if (temp > area)
                    area = temp;
                j--;
            }
        }
        return area;
    }
}