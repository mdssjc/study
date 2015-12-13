package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory<T> {
    private List<T> list;

    public Inventory() {
        list = new LinkedList<T>();
    }

    public void add(T type) {
        list.add(type);
    }

    public T get(String id) {
        for (T element : list) {
            if (element.equals(id)) {
                return element;
            }
        }
        return null;
    }

    public List<T> search(Object search) {
        List<T> matching = new ArrayList<>();
        for (T element : list) {
            if (element.equals(search)) {
                matching.add(element);
            }
        }
        return matching;
    }
}
