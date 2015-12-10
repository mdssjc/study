package creator;

import product.ClassGeneral;

public abstract class FactoryMethod {
    protected String name;

    public abstract ClassGeneral makeClass();

    public void onSetName(String name) {
        this.name = name;
    }
}