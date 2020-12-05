package ru.chuhnakov;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] temp = s.beautifulArray(5);

        for(int i = 0; i < temp.length; ++i) {
            System.out.print(temp[i] + " ");
        }

    }
}
