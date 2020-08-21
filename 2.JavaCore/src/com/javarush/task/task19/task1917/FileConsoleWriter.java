package com.javarush.task.task19.task1917;

/*
Свой FileWriter
1. Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter, которое не должно быть сразу проинициализировано.
2. Класс FileConsoleWriter должен иметь пять конструкторов которые инициализируют fileWriter для записи.
3. Класс FileConsoleWriter должен содержать метод write(char[] cbuf, int off, int len) throws IOException, в котором
данные для записи должны записываться в fileWriter и дублироваться в консоль.
4. Класс FileConsoleWriter должен содержать метод write(int c) throws IOException, в котором данные для записи должны
записываться в fileWriter и дублироваться в консоль.
5. Класс FileConsoleWriter должен содержать метод write(String str) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
6. Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
7. Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
8. Класс FileConsoleWriter должен содержать метод close() throws IOException, в котором должен вызываться такой же метод поля fileWriter.
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter  {
    private FileWriter fileWriter=null;


    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter=new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName,append);

    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file,append);


    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter =new FileWriter(fd);
    }


    public static void main(String[] args) {

    }



    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }


    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for(char i:cbuf)
            System.out.print(i);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for(int i=off;i<off+len;i++)
            System.out.print(cbuf[i]);
    }


    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }


    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off,off+len));
    }


    public void close() throws IOException {
        fileWriter.close();
    }
}