public interface Swim {
    int dept = 100;

    void swiming();
    default void swimAll () {
        System.out.println("all need learn swiming");
    }
    static void noSwim () {
        System.out.println("no swim");
    }

}
