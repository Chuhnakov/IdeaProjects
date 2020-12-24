package ru.chuhnakov;


import java.util.ArrayList;
import java.util.List;

public class Solution {


    public int[] beautifulArray(int N) {
        List<Integer> pass = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) pass.add(i);

        List<Integer> ans = dfs(pass);

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> dfs(List<Integer> arr) {
        if (arr.size() < 3) return arr;

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0) even.add(arr.get(i));
            else odd.add(arr.get(i));
        }

        odd = dfs(odd);
        even = dfs(even);
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(odd);
        tmp.addAll(even);

        return tmp;
    }
    //1,9, 11, 5, 3, 7, 2, 10, 6, 8, 4
//1, 9, 5, 7, 3, 11, 4, 8, 2, 10, 6

    public int minPatches(int[] nums, int N) {
// 1 5 10   N = 20
        int res = 0;
        int sum = 0;
        int index = 0;

        while (sum < N) {
            if (index < nums.length)
                sum += nums[index];
            else {
                res++;
                sum += index;
            }
            index++;
        }
        return res;
    }

    public int[] beautifulArray_old(int N) {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array [i] = i+1;
        }
       // sortForBtfArray(array,N);
        return array;
    }
//    private int[] sortForBtfArray(int[] array,int n){
//        int[] even = new int[n/2];//чётный
//        int[] odd = new int[(int)(n/2+0.5)];//нечётный
//        int index = 0;
//        for (int i = 1; index < array.length; i++, index++) {
//            if (i % 2 == 0) {
//                array[index] = i - 1;
//            } else {
//                array[index] = i + 1;
//                if (index == array.length - 1) {
//                    array[index] = i;
//                }
//            }
//        }
//        return new int[] {even , odd};
//    }
}