package Chuhnakov.ru;

import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs) {

        int wordsMaxLength = Arrays.asList(strs).stream().sorted((e2, e1) -> e1.length() > e2.length() ? -1 : 1).findFirst().get().length();

        String result = new String(strs[0].toCharArray(), 0, wordsMaxLength);//
        if (strs.length != 1) {
            for (int i = 1; i < strs.length; i++) {
                while (!strs[i].contains(result)) {
                    if (wordsMaxLength < 1)
                        return "";
                    wordsMaxLength--;
                    result = new String(result.toCharArray(), 0, wordsMaxLength);//
                }
            }
        }
        return result;
    }
}
