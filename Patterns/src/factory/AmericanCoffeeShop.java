package factory;

public class AmericanCoffeeShop extends CoffeeShop {
    @Override
    public Coffee createCoffee (CoffeeType type) {
        Coffee coffee = null;

        switch (type) {
            case AMERICANO:
                coffee = new AmericanStyleAmericano();
                break;
            case ESPRESSO:
                coffee = new AmericanStyleEspresso();
                break;
            case CAPPUCCINO:
                coffee = new AmericanStyleCappuccino();
                break;
            case CAFFE_LATTE:
                coffee = new AmericanStyleCaffeLatte();
                break;
        }

        return coffee;
    }
}