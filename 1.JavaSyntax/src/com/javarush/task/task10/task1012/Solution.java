package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
//        ________________________________________
        Map <Character, Integer> map = new LinkedHashMap<>();
        int count;  char ch;
        for (int i = 0; i <alphabet.size() ; i++) {
            ch = alphabet.get(i);
            count=0;
            for (int j = 0; j <list.size() ; j++) {
                char[] strToArray = list.get(j).toCharArray(); // Преобразуем строку str в массив символов (char)
                for (int k = 0; k <strToArray.length ; k++) {
                    if (ch == strToArray[k]){
                        count++;
                    }
                }
            }
            map.put(ch, count);
        }
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + "  " + pair.getValue());
        }

    }
}
