package teststorage;

import java.util.List;

public interface Strategy {
    boolean add(Food food, List<Food> foods);
}
