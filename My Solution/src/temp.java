import java.util.ArrayList;
import java.util.List;

class temp {
    void main() {
        List <String> list = new ArrayList<>();
        list.add("1");
        clear(list);
        System.out.println(list);
    }
    void clear (List<String> list) {
        list.add("2");
    }

    public static void main(String[] args) {
        temp temp = new temp();
        temp.main();
        String name = "Donald";
        name.concat("Duck");
    }
}