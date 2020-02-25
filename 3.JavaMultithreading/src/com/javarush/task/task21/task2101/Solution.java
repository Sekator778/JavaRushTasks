package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
        //--------------------
//        int x = 192;
//        System.out.println("int 192 = byte - " + (byte)x);
//        System.out.println("ip");
//        for (int i = 0; i < ip.length; i++) {
//            System.out.println(ip[i]);
//        }
//        System.out.println("----------------");
//        System.out.println("mask");
//        for (int i = 0; i < mask.length; i++) {
//            System.out.println(mask[i]);
//        }
//        System.out.println("----------------");
//        System.out.println("netAddress");
//        for (int i = 0; i < netAddress.length; i++) {
//            System.out.println(netAddress[i]);
//        }
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        return new byte[]{
                (byte)(ip[0] & mask[0]),
                (byte)(ip[1] & mask[1]),
                (byte)(ip[2] & mask[2]),
                (byte)(ip[3] & mask[3])
        };
    }

    public static void print(byte[] bytes) {
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.print(Integer.toBinaryString(bytes[i] | -512).substring(24) + " ");
//        }
        System.out.println(
                Integer.toBinaryString(bytes[0] | -512).substring(24) + " " +
                        Integer.toBinaryString(bytes[1] | -512).substring(24) + " " +
                        Integer.toBinaryString(bytes[2] | -512).substring(24) + " " +
                        Integer.toBinaryString(bytes[3] | -512).substring(24));
    }
}
