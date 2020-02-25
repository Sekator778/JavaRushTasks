package com.javarush.task.task30.task3012;

/* 
Получи заданное число
https://gigabaza.ru/doc/55220.html
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(111);
    }

    public void createExpression(int number) {
        int[] array = {1, 3, 9, 27, 81, 243, 729, 2187};
        StringBuilder sb = new StringBuilder();
        while (number > 0){
            if (number % 3 == 0) {
                sb.append("0");
                number /= 3;
            }else if (number % 3 == 1){
                sb.append("+");
                number /= 3;
            }else {
                sb.append("-");
                number /= 3;
                number ++;
            }
        }
        int value = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '+') {
                result.append(" + ").append(array[i]);
                value += array[i];
            } else if (sb.charAt(i) == '-') {
                result.append(" - ").append(array[i]);
                value -= array[i];
            }
        }
        System.out.println(value + " =" + result);

    }
}