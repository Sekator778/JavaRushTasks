package decorator;

public class Garland extends TreeDecorator {
    public Garland(ChristmasTree tree) {
        super(tree);
    }
    private String garlandDecore() {
        return "garland lights";
    }

    @Override
    public String decorate() {
        return super.decorate() + garlandDecore();
    }
}
