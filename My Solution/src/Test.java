import WorkFile.Car;

public class Test{

    public static void main(String[] args) {
        int a = 1;
        Car car = new Car();
        car.setName("Opel");
        System.out.println(a);
        System.out.println(car.getName());
        System.out.println("a 1: " + a);

        setName(car);
        System.out.println("2 name car: " + car.getName());
        setName2(a);
        System.out.println("a 2: " + a);


    }
    public static void setName (Car car) {
        car.setName("Volvo");
    }
    public static void setName1 (Car car) {
        car.setName("Kamaz");
    }
    public static void setName2 (int a) {
        a = 2;
    }
    public static void setName3 (int a) {
        a = 3;
    }


    }