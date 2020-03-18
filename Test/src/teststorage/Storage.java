package teststorage;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private Strategy strategy;
    private List<Food> foods;

    public Storage(Strategy strategy) {
        this.strategy = strategy;
        this.foods = new ArrayList<>();
    }
        public boolean add(Food food) {
        return this.strategy.add(food, this.foods);
        }
}
