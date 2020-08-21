package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(reader.readLine());
        int a2 = Integer.parseInt(reader.readLine());
        int a3 = Integer.parseInt(reader.readLine());
        int a4 = Integer.parseInt(reader.readLine());
        int a5 = Integer.parseInt(reader.readLine());

      int arr [] = {a1, a2, a3, a4, a5};  // sozdali i zapolnili massiv
        bubblesort(arr);

        }
public static void bubblesort(int [] arr){
        for (int i = arr.length-1; i>0; i--){
            for (int j=0; j<i; j++){
                if (arr[j]>arr[j+1]){
                    int a = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=a;
                }
            }
        }
      for(int i=0; i<arr.length; i++){
          System.out.println(arr[i]);//напишите тут ваш код
      }
    }

}
