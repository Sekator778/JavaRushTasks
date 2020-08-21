package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("л") && list.get(i).contains("р")) {
                continue;
            }
            else {
                if (list.get(i).contains("л")) {
                    list.add(i, list.get(i));
                    i++;
                }
                else {
                    if (list.get(i).contains("р")) {
                        list.remove(i);
                        i--;
                    }
                }
            }
        }
        return list;




        //напишите тут ваш код

    }
}