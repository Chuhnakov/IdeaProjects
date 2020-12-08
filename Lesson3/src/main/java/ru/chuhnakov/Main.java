package ru.chuhnakov;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] temp = s.beautifulArray(5);

        for (int j : temp) {
            System.out.print(j + " ");
        }
        System.out.println("");
        System.out.println("___________Patches________________");

        System.out.print(s.minPatches(temp, 20));
    }
}
