package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        String key = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("START");//ввести с консоли несколько ключей (строк), пункт 7

        while (true){
            key = reader.readLine();
            // MovieFactory.getMovie(string);
            //                System.out.println(movie.getClass().toString());
            if (key.equals("soapOpera")) { Movie movie = MovieFactory.getMovie(key); System.out.println(movie.getClass().getSimpleName());}
               else if (key.equals("thriller")) { Movie movie = MovieFactory.getMovie(key); System.out.println(movie.getClass().getSimpleName());}
                else if (key.equals("cartoon")) { Movie movie = MovieFactory.getMovie(key); System.out.println(movie.getClass().getSimpleName());}

             else { Movie movie = MovieFactory.getMovie(key); break;}
                  }
        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {

    }

    static class SoapOpera extends Movie {

    }
    static class Cartoon extends Movie {
    }
    static class Thriller extends Movie {
    }
    //Напишите тут ваши классы, пункт 3
}
