package teststorage;

import java.util.List;

public class SortStation {
    private final List<Storage> storages;

    public SortStation(List<Storage> storages) {
        this.storages = storages;
    }

    public boolean sort(Food food) {
        boolean rsl = false;
        for (Storage storage : storages
             ) {
            if (storage.add(food)) {
                rsl = true;
                break;
            }
        }
        if (rsl) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        return rsl;
    }

    public static void main(String[] args) {
        Storage shop = new Storage(new Shop());
        Food apple1 = new Apple("light", 5);
        Food apple2 = new Apple("heavy", 500);
        List<Storage> storages = List.of(shop);
        SortStation station = new SortStation(storages);
        station.sort(apple1);
        System.out.println("two apple");
        station.sort(apple2);

    }

}
