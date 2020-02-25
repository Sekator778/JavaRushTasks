package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'


*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", "41");
        System.out.println(getQuery(map));
        String s = null;
        System.out.println(s.join(" and ", "mama", "papa", "anya", "mariia"));



    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
      for (Map.Entry<String, String> pair : params.entrySet()){
            if (pair.getValue() != null && !pair.getValue().isEmpty())  {
                sb.append(pair.getKey() + " = " + "'" + pair.getValue() + "'" + "\n");
          }
      }
      return String.join(" and ", sb.toString().split("\\n"));
    }

}
