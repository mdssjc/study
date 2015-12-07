import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory<T> {
    private List<Guitar> list;

    public Inventory() {
	list = new LinkedList<Guitar>();
    }

    public void addGuitar(Guitar type) {
	list.add(type);
    }

    public Guitar getGuitar(String serialNumber) {
	for (Guitar guitar : list) {
	    if (guitar.getSerialNumber().equals(serialNumber)) {
		return guitar;
	    }
	}
	return null;
    }

    public List<Guitar> search(GuitarSpec searchGuitar) {
	List<Guitar> result = new ArrayList<>();
	for (Guitar guitar : list) {
	    // Ignore serial number since that's unique
	    // Ignore price since that's unique
	    if (guitar.getSpec().check(searchGuitar)) {
		result.add(guitar);
	    }
	}
	return result;
    }
}
