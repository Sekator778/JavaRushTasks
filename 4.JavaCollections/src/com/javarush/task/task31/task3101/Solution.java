package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
public class Solution {
//    private static ArrayList<File> fileList = new ArrayList<>();
    private Map<String, String> map = new TreeMap<>();
    
    public Map<String, String> getMap() {
        return map;
    }
    public void getPath(File path) {
        for (File folder : path.listFiles()) {
            System.out.println(folder);
            if (folder.isFile()){
                try(FileInputStream reader = new FileInputStream(folder)){
                    if (reader.available() <= 50){
                        map.put(folder.getName(), folder.getParent());
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }else {
                getPath(folder);
            }
        }
    }
    
    

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]); //
        File resultFileAbsolutePath = new File(args[1]);
        File newFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, newFile);
        Solution solution = new Solution();
        solution.getPath(path);
        FileOutputStream fileWriter = new FileOutputStream(newFile, true);

        for (Map.Entry<String, String> pair : solution.getMap().entrySet()) {
            try (FileInputStream fileReader = new FileInputStream(pair.getValue() + "/" + pair.getKey());
                 ) {
                if (fileReader.available() > 0) {
                    byte[] byteArray = new byte[fileReader.available()];
                    int value = fileReader.read(byteArray);
                    fileWriter.write(byteArray);
                }
                fileWriter.write("\n".getBytes());

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    fileWriter.close();
    }
}


//        try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)) {
//            fillFileList(path.getPath());
//            fileList.sort(new FileNameComparator());
//
//            for (File f : fileList) {
//                FileInputStream fileInputStream = new FileInputStream(f);
//                while (fileInputStream.available() > 0) {
//                    fileOutputStream.write(fileInputStream.read());
//                }
//                fileOutputStream.write(System.lineSeparator().getBytes());
//                fileOutputStream.flush();
//
//                fileOutputStream.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void deleteFile(File file) {
//        if (!file.delete())
//            System.out.println("Не могу удалить файл" + file.getName());
//    }
//
//
//    // pекурсия считіваем все директории и записіваем все файл больше 50 удаляем
//    private static void fillFileList(String path) {
//        File[] files = new File(path).listFiles();
//        for (File f : files) {
//            if (f.isDirectory()) {
//                fillFileList(f.getAbsolutePath());
//                continue;
//            }
//            if (f.length() > 50) {
//                FileUtils.deleteFile(f);
//            } else fileList.add(f);
//        }
//    }
//}
//
//    // сортировка по имени
//     class FileNameComparator implements Comparator<File>{
//
//        @Override
//        public int compare(File o1, File o2) {
//            return o1.getName().compareTo(o2.getName());
//        }
//    }


