package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        FileInputStream fis;
        while ((fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())).available() >= 1000) {

        }
        fis.close();
       throw new DownloadException ();

    }

    public static class DownloadException extends Exception {

    }
}
