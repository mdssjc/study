package creator;

import product.AbstractProductA;
import product.AbstractProductB;
import product.ProductA2;
import product.ProductB2;

public class ConcreteFactory2 implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
