package teststorage;

public abstract class Food {
    String name;
    int weight;

    public Food(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int calculateWeight(Food food) {
        return food.weight * 2;
    }
}
