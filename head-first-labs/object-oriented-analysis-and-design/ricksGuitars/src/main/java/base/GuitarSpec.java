package base;

import types.Builder;
import types.Type;
import types.Wood;

public class GuitarSpec {
    private Builder builder;
    private String  model;
    private Type    type;
    private int     numStrings;
    private Wood    backWood;
    private Wood    topWood;

    public GuitarSpec() {
    }

    public GuitarSpec(Builder builder, String model, Type type, int numStrings,
            Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.numStrings = numStrings;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public Builder getBuilder() {
        return this.builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getNumStrings() {
        return this.numStrings;
    }

    public void setNumStrings(int numStrings) {
        this.numStrings = numStrings;
    }

    public Wood getBackWood() {
        return this.backWood;
    }

    public void setBackWood(Wood backWood) {
        this.backWood = backWood;
    }

    public Wood getTopWood() {
        return this.topWood;
    }

    public void setTopWood(Wood topWood) {
        this.topWood = topWood;
    }

    public boolean matches(GuitarSpec otherSpec) {
        if (builder != otherSpec.builder) {
            return false;
        }
        if ((model != null) && (!model.equals(""))
                && (!model.equals(otherSpec.model))) {
            return false;
        }
        if (type != otherSpec.type) {
            return false;
        }
        if (numStrings != otherSpec.numStrings) {
            return false;
        }
        if (backWood != otherSpec.backWood) {
            return false;
        }
        if (topWood != otherSpec.topWood) {
            return false;
        }
        return true;
    }
}
