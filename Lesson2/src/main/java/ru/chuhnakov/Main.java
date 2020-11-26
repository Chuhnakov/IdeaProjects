package ru.chuhnakov;

public class Main {
    public static void main(String[] args) {
        System.out.println("lesson 2");
        Solution s = new Solution();
        int out = s.maxArea(new int[]{3, 5, 2, 4, 10, 9, 6});
        System.out.println(out);
        out = s.maxArea(new int[]{3, 9, 3, 4, 7, 2, 12, 6});
        System.out.println(out);
        out = s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(out);
    }
}
