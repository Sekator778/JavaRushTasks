package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?

0. обязательно почитать док https://docs.oracle.com/javase/7/docs/api/java/lang/ClassLoader.html
(это помимо ссылок, приведенных в остальных комментариях)

1. свой ClassLoader - использовать обязательно.
 1.1.  В данном случае достаточно написать свой метод Class load (path)
   1.1.1  - считываете Path в byte[] b  // Files.readAllBytes
   1.1.2 - return defineClass в аргументах которого  (дабы не заморачиваться) первый параметр можно писать null /*из полученного Class вы и без имени сможете вытащить конструкторы и интерфейсы.

2. из аргумента String pathToAnimals получаем  список файлов //new File(pathToAnimals).listFiles()
  2.1 на всякий случай для каждого полученного File проверяем файл ли это и заканчивается ли его имя на ".class".
 2.2  для кaждого File своим ClassLoader  получаем объект Class

3. Обрабатываем полученный объект. В частности - интерфейсы и конструкторы.
  3.1 clazz.getInterfaces()
  3.2 clazz.getConstructors()

3. если ок, то clazz.newInstance() -  и д



*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + "/";
        File dir = new File(pathToAnimals);
        String[] pathes = dir.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir1, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });
        for (String p : pathes) {
            try {
                final String finalPathToAnimals = pathToAnimals;
                boolean hasInterface = false;
                boolean hasConstructor = false;

                ClassLoader loader = new ClassLoader() {
                    @Override
                    public Class<?> findClass(String className) throws ClassNotFoundException {
                        try {
                            byte[] b = fetchClassFromFS(finalPathToAnimals + className + ".class");
                            return defineClass(null, b, 0, b.length);
                        } catch (IOException ex) {
                            return super.findClass(className);
                        }
                    }
                };
                String className = p.substring(0, p.length() - 6);
                Class clazz = loader.loadClass(className);

                Class[] interfaces = clazz.getInterfaces();
                for (Class i : interfaces) {
                    if (Animal.class == i) {
                        hasInterface = true;
                        break;
                    }
                }
                if (!hasInterface) continue;

                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors) {
                    if (c.getParameterTypes().length == 0) {
                        hasConstructor = true;
                        break;
                    }
                }
                if (!hasConstructor) continue;
                result.add((Animal) clazz.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    private static byte[] fetchClassFromFS(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        // Get the size of the file
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}
