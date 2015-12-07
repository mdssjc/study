import types.Builder;
import types.Type;
import types.Wood;

public class GuitarSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;

    public GuitarSpec() {
    }

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
	this.model = model;
	this.builder = builder;
	this.type = type;
	this.backWood = backWood;
	this.topWood = topWood;
    }

    public String getModel() {
	return this.model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public Builder getBuilder() {
	return this.builder;
    }

    public void setBuilder(Builder builder) {
	this.builder = builder;
    }

    public Type getType() {
	return this.type;
    }

    public void setType(Type type) {
	this.type = type;
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

    public boolean check(GuitarSpec other) {
	return getBuilder().equals(other.getBuilder()) || getModel().equals(other.getModel())
		|| getType().equals(other.getType()) || getBackWood().equals(other.getBackWood())
		|| getTopWood().equals(other.getTopWood());
    }
}