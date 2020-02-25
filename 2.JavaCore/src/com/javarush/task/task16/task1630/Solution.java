package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
    public static class  ReadFileThread extends Thread implements ReadFileInterface {

        String fileName;

        ArrayList<String> list = new ArrayList<>();

        String result = "";

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        public String getFileContent() {
            for (int i = 0; i < list.size(); i++) {
                result = result + list.get(i);
                if (i < list.size()-1) result += " ";
            }
            return result;
        }

        public void run() {
            String line = null;
            try{
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                while ((line = reader.readLine()) != null){
                    list.add(line);
                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //add your code here - добавьте код тут
}
