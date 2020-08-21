package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {

       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String file_name = reader.readLine();
       reader.close();
try {
    InputStream inputStream = new FileInputStream(file_name);
    load(inputStream);}
catch (Exception e){
    e.printStackTrace();
}
try {
    OutputStream outputStream = new FileOutputStream("F:\\Java\\JavaRush\\JavaRushTasks\\property1.properties");
    save(outputStream);
}
catch (Exception e){
    e.printStackTrace();
}

       //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties  prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, null);
//         или бегаем по мапе
//                  for (Map.Entry<String, String> entry: properties.entrySet()) {
////                    prop.setProperty(entry.getKey(), entry.getValue());
////                      }
////                prop.store(outputStream, null);

    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();  // вот тут делаем проперти
        prop.load(inputStream);                // а тут в него заливаем поток
        for (Map.Entry<Object, Object> entry : prop.entrySet() ){ // тут 
            properties.put((String)entry.getKey(), (String)entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().fillInPropertiesMap();
    }
}
