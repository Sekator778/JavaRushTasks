package strategy;

public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int one, int two) {
        return one + two;
    }
}
