package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (input.equals("helicopter")) result = new Helicopter();
        if (input.equals("plane")) {
            int count = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            result = new Plane(count);

        }
    }
}
