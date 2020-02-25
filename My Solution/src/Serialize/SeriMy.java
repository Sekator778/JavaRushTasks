package Serialize;

import java.io.Serializable;

public class SeriMy implements Serializable{
    private static final long serialVersionUID = -1921221377331502941L;
    private String name;
    private int age;

    public SeriMy() {
    }

    public SeriMy(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

   @Override
   public String toString() {
      return "name " + name + " age " + age;
   }
}
