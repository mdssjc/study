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

    public List<Guitar> search(Guitar searchGuitar) {
        List<Guitar> result = new ArrayList<>();
        for (Guitar guitar : list) {
            // Ignore serial number since that's unique
            // Ignore price since that's unique
            if (guitar.getBuilder().equals(searchGuitar.getBuilder())
                    || guitar.getModel().equals(searchGuitar.getModel())
                    || guitar.getType().equals(searchGuitar.getType())
                    || guitar.getBackWood().equals(searchGuitar.getBackWood())
                    || guitar.getTopWood().equals(searchGuitar.getTopWood())) {
                result.add(guitar);
            }
        }
        return result;
    }
}
