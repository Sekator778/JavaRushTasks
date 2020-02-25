package factory;

public class ItalianCoffeeShop extends CoffeeShop {

    @Override
    public Coffee createCoffee (CoffeeType type) {
        Coffee coffee = null;
        switch (type) {
            case AMERICANO:
                coffee = new ItalianStyleAmericano();
                break;
            case ESPRESSO:
                coffee = new ItalianStyleEspresso();
                break;
            case CAPPUCCINO:
                coffee = new ItalianStyleCappuccino();
                break;
            case CAFFE_LATTE:
                coffee = new ItalianStyleCaffeLatte();
                break;
        }
        return coffee;
    }
}
class ItalianStyleAmericano extends Coffee {
    public ItalianStyleAmericano() {
        System.out.println("ItalianStyleAmericano");
    }
}