package factory;

public abstract class Coffee {
    public void makeCoffee(){
        System.out.println("делаем кофе");
    }
    public void pourIntoCup(){
        System.out.println("наливаем в чашку");
    }
}