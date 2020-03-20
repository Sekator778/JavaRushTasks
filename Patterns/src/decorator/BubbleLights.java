package decorator;

public class BubbleLights extends TreeDecorator {

    public BubbleLights(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithBubble();
    }

    private String decorateWithBubble() {
        return "with Bubble Lights ";
    }
}
