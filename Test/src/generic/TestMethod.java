package generic;

public class TestMethod<T> {
    public <T> int method(T t) {
        return t.hashCode();
    }

    public <T> T method2(T t) {
        return t;
    }
}
