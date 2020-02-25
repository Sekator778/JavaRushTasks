package noObject;

import java.io.File;

public class Main {

    public static void main(String[] args) {
       Animal animal = getAnimal();
       animal.eatAnimal();

    }
    static Animal getAnimal(){
        try {
            if (new File("nosuchfile.txt").exists()){
                return new Wolf();
            }
        }finally {
            return new NoObject();
        }
    }
}



class Wolf implements Animal{
    @Override
    public void eatAnimal() {
        System.out.println("lion eat");
    }
}
interface Animal{
    void eatAnimal();
}

class NoObject implements Animal{
    @Override
    public void eatAnimal() {
        System.out.println("chto poshlo ne tak %)");
    }
}
