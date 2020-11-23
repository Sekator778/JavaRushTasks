package Serialize;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SeriMy ser = new SeriMy();
        ser.setAge(41);
        ser.setName("Alex");
        System.out.println(ser);

       try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("text1.txt"))){
           oos.writeObject(ser);

       }catch (Exception e){
           e.printStackTrace();
       }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("text1.txt"));
        SeriMy ser2 = new SeriMy();
        ser2 = (SeriMy)ois.readObject();
        ois.close();
        System.out.println(ser2);
    }

}



