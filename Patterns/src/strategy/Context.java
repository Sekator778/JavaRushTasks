package strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int one, int two) {
        return strategy.doOperation(one, two);
    }
}
