package creator;

import product.Product;
import product.ProductA;

public class ConcreteFactoryPA extends FactoryMethod {

    @Override
    public Product factoryMethod() {
        return new ProductA();
    }
}
