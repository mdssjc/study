package base.builder;

import base.Guitar;
import base.GuitarSpec;
import types.Builder;
import types.Type;
import types.Wood;

public class GuitarBuilder {
    private String  serialNumber;
    private double  price;
    private Builder builder;
    private String  model;
    private Type    type;
    private int     numStrings;
    private Wood    backWood;
    private Wood    topWood;

    public GuitarBuilder() {
    }

    public GuitarBuilder setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public GuitarBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public GuitarBuilder setBuilder(Builder builder) {
        this.builder = builder;
        return this;
    }

    public GuitarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public GuitarBuilder setType(Type type) {
        this.type = type;
        return this;
    }

    public GuitarBuilder setNumStrings(int numStrings) {
        this.numStrings = numStrings;
        return this;
    }

    public GuitarBuilder setBackWood(Wood backWood) {
        this.backWood = backWood;
        return this;
    }

    public GuitarBuilder setTopWood(Wood topWood) {
        this.topWood = topWood;
        return this;
    }

    public Guitar makeGuitar() {
        return new Guitar(serialNumber, price, new GuitarSpec(builder, model,
                type, numStrings, backWood, topWood));
    }
}
