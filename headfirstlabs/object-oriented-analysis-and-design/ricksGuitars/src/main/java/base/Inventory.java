package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import base.builder.GuitarBuilder;

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
        List<Guitar> matchingGuitars = new ArrayList<>();
        for (Guitar guitar : list) {
            if (guitar.getSpec().matches(searchGuitar)) {
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }
}
