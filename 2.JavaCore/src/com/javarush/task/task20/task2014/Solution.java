package com.javarush.task.task20.task2014;

import javax.tools.FileObject;
import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        try{
        FileOutputStream fileOutput  = new FileOutputStream("temp_serializable");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        FileInputStream fileInput = new FileInputStream("temp_serializable");
        ObjectInputStream inputStream = new ObjectInputStream(fileInput);
// --- создал обект и записал
        Solution savedObject = new Solution(36);

//        if (!savedObject.equals(null)){
            outputStream.writeObject(savedObject);
//        }
        outputStream.flush();
        fileOutput.close();
        outputStream.close();
// == закрил поток записи ====
        // == создал 2й екземпляр класса
        Solution someObject = new Solution(16);
        Solution loadObject = (Solution)inputStream.readObject();

        fileInput.close();
        inputStream.close();

            System.out.println("и что получается какие стринги ? - " + savedObject.string.equals(loadObject.string));


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }


        System.out.println(new Solution(4));


        // Object object = objectStream.readObject();
        // fiStream.close();
        // objectStream.close();
        //
        // Cat newCat = (Cat)object;

    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
