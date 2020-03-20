package com.javarush.task.task14.task1421;

 class Singleton {
    private Singleton() {
     }
    private static Singleton instance = new Singleton();
    
    public static Singleton getInstance () {
        return instance;
    }


}
