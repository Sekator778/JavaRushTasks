package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/* 
MVC - простая версия
*/

public class Solution {
    public static void main(String[] args) {
        new View().fireShowDataEvent();
//        new Solution().fireShowDataEvent();
    }
///* это запись данных в модель */
//    public List<String> getData() {
//        List<String> data = new ArrayList<>() {{
//            add("First string");
//            add("Second string");
//            add("Third string");
//        }};
//        return data;
//    }
///* это вывод на экран*/
//    public void fireShowDataEvent() {
//        System.out.println(onShowDataList());
//    }
///* достаем из базы данных модель  нашу
// */
//    public List<String> getStringDataList() {
//        return getData();
//    }
///**
// * вывод куда - то наверно контролер*/
//    public List<String> onShowDataList() {
//        return getStringDataList();
//    }
}
