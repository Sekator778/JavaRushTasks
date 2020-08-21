package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static int NOD(int a,int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
    public static void main(String[] args) throws Exception {
        int a = 0, b = 0, x = 0, temp, temp2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        a = Integer.parseUnsignedInt(reader.readLine());
        b = Integer.parseUnsignedInt(reader.readLine());}
        catch (Exception e){
            e.printStackTrace();
        }
        int max = a, min = b;
        if (max < b){max = b; min = a;}
            if ((max % min) == 0 && (min % min) == 0) {x = min; System.out.println(x);}
                  else {System.out.println(NOD(a, b)); }
            }
}
