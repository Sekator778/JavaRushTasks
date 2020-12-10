package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

//    static List<String> makeHeapPollution() {
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        List<String> strings = numbers;
//        strings.add("");
//        return strings;
//    }
//
//    public static void main(String[] args) {
//
//        List<String> stringsWithHeapPollution = makeHeapPollution();
//
//        System.out.println(stringsWithHeapPollution.get(0));
//    }
//}

    static void makeHeapPollution(MyClass... stringsLists) {
        List<Integer> numbersList = Arrays.asList(66,22,44,12);

        ((Object[]) stringsLists)[0] = numbersList;
        MyClass str = stringsLists[0];
    }

    public static void main(String[] args) {
        MyClass m1 = new MyClass("1");
        MyClass m2 = new MyClass("2");
        makeHeapPollution(m1, m2);
    }
    static class MyClass{
        String id;

        public String getId() {
            return id;
        }

        public MyClass(String id) {
            this.id = id;
        }
    }
}