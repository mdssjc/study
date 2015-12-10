package creator;

import product.ClassGeneral;
import product.ClassOne;

public class ClassOneFactoryMethod extends FactoryMethod {

    @Override
    public ClassGeneral makeClass() {
        ClassGeneral classOne = new ClassOne();
        classOne.setName(super.name);
        return classOne;
    }
}
