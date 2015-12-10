package creator;

import product.ClassGeneral;
import product.ClassThree;

public class ClassThreeFactoryMethod extends FactoryMethod {

    @Override
    public ClassGeneral makeClass() {
        ClassGeneral classThree = new ClassThree();
        classThree.setName(super.name);
        return classThree;
    }
}
