package algoritm;

public class SecondMin {
    public static void main(String[] args) {
        int [] array = new int[] {12, 23, 23, 34, 45, 45, 67, 87};

        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min2 = min;
                min = array[i];
            } else if (array[i] < min2 && array[i] != min) {
                min2 = array[i];
            }
        }


        System.out.println("min element: " + min);
        if (min2 != Integer.MAX_VALUE) {
            System.out.println("second min element: " + min2);
        } else {
            System.out.println("no present second min element");
        }
    }
}
