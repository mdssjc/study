package creator;

import product.Product;
import product.ProductB;

public class ConcreteFactoryPB extends FactoryMethod {

    @Override
    public Product factoryMethod() {
        return new ProductB();
    }
}
