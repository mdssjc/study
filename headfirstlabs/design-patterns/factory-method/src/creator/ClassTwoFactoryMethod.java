package creator;

import product.ClassGeneral;
import product.ClassTwo;

public class ClassTwoFactoryMethod extends FactoryMethod {

    @Override
    public ClassGeneral makeClass() {
        ClassGeneral classTwo = new ClassTwo();
        classTwo.setName(super.name);
        return classTwo;
    }
}
