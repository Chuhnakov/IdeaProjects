package ru.chuchnakov;

import jdk.nashorn.internal.runtime.Debug;

public class Solution {
    public static void main(String[] args) {
    boolean a = isStrobogrammatic("69");
    boolean b = isPowerOfFour(16);
    }
    public static boolean isStrobogrammatic(String num ) {
        String revNum = "";//TODO убрать пробелы
       for (int i = 0; i < num.length(); i++)
       {
           switch (num.charAt(i))
           {
               case '6':
                   revNum = '9' + revNum;
                   break;
               case  '9':
                   revNum = '6' + revNum;
                   break;
               default:
                   revNum = num.charAt(i) + revNum;
                   break;
           }
       }
        return  num.equals(revNum);
    }
    public static boolean isPowerOfFour(int n){
        if((int)Math.pow(-2,31) >= n ||
                n >= (int)Math.pow(2,31)-1)
            return false;//TODO Сообщение об исключении
        if (n == 1)
            return  true;
        return Math.sqrt(n) % 4 == 0;
    }

}
