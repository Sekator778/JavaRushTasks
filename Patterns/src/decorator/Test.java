package decorator;

public class Test {
    public static void main(String[] args) {

    ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
        System.out.println(tree1.decorate());
//      "Christmas tree with Garland");

    ChristmasTree tree2 = new BubbleLights(
      new Garland(new Garland(new ChristmasTreeImpl())));
        System.out.println(tree2.decorate());
//      "Christmas tree with Garland with Garland with Bubble Lights");
    }
}
