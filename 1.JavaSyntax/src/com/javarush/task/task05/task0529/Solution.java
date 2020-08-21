package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        int a=0;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String s = buffer.readLine();
            if (s.equals("сумма"))
                break;
            else {
             a = Integer.parseInt(s);
          //  int a = Integer.parseInt(buffer.readLine());
            sum = a + sum;
         //   System.out.println("sum v seredini while = "+ sum);
                }
        }
        System.out.println(sum);    //напишите тут ваш код
    }
}
