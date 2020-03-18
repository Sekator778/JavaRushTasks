package teststorage;

import java.util.List;

public class Shop implements Strategy {
    @Override
    public boolean add(Food food, List<Food> foods) {
        boolean rsl = false;
        if (food.weight < 200) {
            rsl = true;
            rsl = foods.add(food);
        }
        return rsl;
    }
}
