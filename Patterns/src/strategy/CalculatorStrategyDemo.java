package strategy;

public class CalculatorStrategyDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("5 + 5 = " + context.executeStrategy(5, 5));
        context = new Context(new OperationSubstract());
        System.out.println("5 - 5 = " + context.executeStrategy(5, 5));
        context = new Context(new OperationMultiply());
        System.out.println("5 * 5 = " + context.executeStrategy(5, 5));
    }
}
