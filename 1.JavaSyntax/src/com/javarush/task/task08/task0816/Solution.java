package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Джонатан", dateFormat.parse("DECEMBER 23 2000"));
        map.put("Ковальов", dateFormat.parse("APRIL 5 1953"));
        map.put("Борсуков", dateFormat.parse("JULY 18 1976"));
        map.put("Стлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Джоатан", dateFormat.parse("DECEMBER 23 2000"));
        map.put("Ковльов", dateFormat.parse("APRIL 5 1953"));
        map.put("Боруков", dateFormat.parse("JULY 18 1976"));
        map.put("Сталоне", dateFormat.parse("MAY 1 2012"));
        map.put("Джонтан", dateFormat.parse("DECEMBER 23 2000"));

        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        for (Map.Entry<String, Date> pair: map.entrySet()){
    //        while (iterator.hasNext()){
//            Date date = iterator.next().getValue();
//            int month = date.getMonth();
      map.values().removeIf(item -> (item.getMonth() == 5 | item.getMonth() == 6 | item.getMonth() == 7));
         }
    }
//}

    public static void main(String[] args) throws ParseException {
//        Map<String, Date> map = createMap();
//        Map<String, Date> mapSort= createMap();
//        Set set = map.entrySet();
//        for (Object o:set) {
//            System.out.println(o); }
//        removeAllSummerPeople(createMap());
//        System.out.println("---- posle ------");
//        for (Object o:set) {
//        System.out.println(o); }
}
}
