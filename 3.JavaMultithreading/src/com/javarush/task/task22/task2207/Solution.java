package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(nameFile));
        StringBuilder sb = new StringBuilder();

        while (reader.ready()){
            sb.append(reader.readLine());
            if (reader.ready()) sb.append(" ");
        }
        String [] arr = sb.toString().split(" ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].equals(new StringBuilder(arr[j]).reverse().toString()) && !arr[i].equals(" ") && i != j){
                    result.add(new Pair(arr[i], arr[j]));
                    arr[i] = " ";
                    arr[j] = " ";

                }
            }

        }
        for (Pair p : result){
            System.out.println(p);
        }



    }

    public static class Pair {
        String first;
        String second;
        public Pair () {}
        public Pair(String s, String s1) {
            this.first = s;
            this.second = s1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
