public class Singletone3 {
    public static void main(String[] args) {
        Single single = Single.getSingle();
        Single single2 = Single.getSingle();
    }

}

class Single {
    private Single() {
        System.out.println("make");
    }
    static Single single;
    public static Single getSingle() {
        if (single == null){                // lazy singletone
            single = new Single();
        }
        return single;
    }
}
