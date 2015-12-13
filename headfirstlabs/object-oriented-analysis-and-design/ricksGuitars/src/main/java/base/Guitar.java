package base;

public class Guitar {

    private String     serialNumber;
    private double     price;
    private GuitarSpec spec;

    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

    public GuitarSpec getSpec() {
        return spec;
    }

    public void setSpec(GuitarSpec spec) {
        this.spec = spec;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Guitar) {
            return this.serialNumber.equals(((Guitar) other).getSerialNumber());
        } else if (other instanceof GuitarSpec) {
            return spec.matches((GuitarSpec) other);
        } else if (other instanceof String) {
            return this.serialNumber.equals((String) other);
        }
        return false;
    }
}
