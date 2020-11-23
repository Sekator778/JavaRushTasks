package com.javarush.task.task18.task1827;
//----------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы
*/

public class Solution {
    public static class Product {
        int id;
        String name;
        String price;
        String quantity;

        public Product(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        List<Product> products = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                Product product = getProduct(fileReader.readLine());
                products.add(product);
            }
        }

        if ("-c".equals(args[0])) {
            int id = 0;
            for (Product product : products) {
                if (product.id > id) id = product.id;
            }
            String name = "";
            for (int i = 1; i < args.length - 2; i++) {
                name += args[i] + " ";
            }
            if (name.length() > 30) {
                name = name.substring(0, 30);
            }
            String price = args[args.length - 2];
            if (price.length() > 8) {
                price = price.substring(0, 8);
            }
            String quantity = args[args.length - 1];
            if (quantity.length() > 4) {
                quantity = quantity.substring(0, 4);
            }
            Product product = new Product(++id, name.trim(), price, quantity);
            products.add(product);
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Product product : products) {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            }
        }
    }

    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);
    }
}
//
//
////---------------
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.concurrent.atomic.AtomicInteger;
//
///*
//Прайсы
//*/
//
//public class Solution {
//
//    public static void main(String[] args) {
//        String fileName = readNameConsole();
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
//            if (args[0].equals("-c")) {
//                String id = nextPosition(fileName);
//                String productName = args[1];
//                String price = args[2];
//                String quantity = args[3];
//                writer.write(id, 0, id.length());
//                writer.write(productName, 0, productName.length());
//                writer.write(price, 0, price.length());
//                writer.write(quantity, 0, quantity.length());
//                writer.append('\n');
//                writer.flush();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * read wit console name file for update
//     * @return name file
//     */
//    private static String readNameConsole() {
//        Scanner scanner = new Scanner(System.in);
//        String answer = scanner.nextLine();
//        scanner.close();
//        return answer;
//    }
//
//    /**
//     * read last string into file
//     * and add next position
//     */
//    private static String nextPosition(String fileName) {
//        String current, result = "", last = null;
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
//            while ((current = bufferedReader.readLine()) != null) {
//                last = current;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (last == null || last.length() < 4) {
//            return null;
//        }
//        for (int i = 0; i < last.length(); i++) {
//            if (Character.isDigit(last.charAt(i))) {
//                result = result + last.charAt(i);
//            } else {
//                break;
//            }
//        }
//        int id = Integer.parseInt(result) + 1;
//        result = String.valueOf(id);
//        return result;
//    }
//}
