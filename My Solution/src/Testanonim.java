class Animal {
    public void eat() {
        System.out.println("Animal is eating ....");
    }
}






public class Testanonim {


    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();

        Animal animal1 = new Animal(){
            @Override
            public void eat() {
                System.out.println("other animal eating ... ");
            }
        };
        animal1.eat();

    }
}
