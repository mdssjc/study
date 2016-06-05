package creator;

import product.AbstractProductA;
import product.AbstractProductB;

public interface AbstractFactory {

    public AbstractProductA createProductA();

    public AbstractProductB createProductB();
}
